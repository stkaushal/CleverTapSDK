package HTTP;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import Helper.ClevertapInstance;

import org.apache.http.conn.HttpClientConnectionManager;

public class HttpClient {
	
	private static final int KEEP_ALIVE = 5*60*1000;
	private static final int MAX_CONN = 3;
	private static final int MAX_CONN_PER_ROUTE = 3;
	private static final int CONN_TIMEOUT = 10*1000;
	private RequestConfig requestConfig;
	private CloseableHttpClient httpClient;
	private CloseableHttpResponse httpResponse;
	private PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
	
	private ConnectionKeepAliveStrategy keepAliveStrategy = new ConnectionKeepAliveStrategy() {
		
		@Override
		public long getKeepAliveDuration(org.apache.http.HttpResponse responseponse, org.apache.http.protocol.HttpContext context) {
			HeaderElementIterator it = new BasicHeaderElementIterator(responseponse.headerIterator(HTTP.CONN_KEEP_ALIVE));
			while (it.hasNext()) {
				HeaderElement he = it.nextElement();
				String param = he.getName();
				String value = he.getValue();
				if (value != null && param.equalsIgnoreCase("timeout")) {
					return Long.parseLong(value) * 1000;
				}
			}
			return KEEP_ALIVE;
		}
	};

	
	public HttpClient()
	{
		this.httpClient = null;
		this.httpResponse = null;
		
		this.requestConfig = RequestConfig.custom()
	    		  .setSocketTimeout(CONN_TIMEOUT)
	    		  .setConnectTimeout(CONN_TIMEOUT)
	    		  .setConnectionRequestTimeout(CONN_TIMEOUT)
	    		  .build();
		
		this.connManager.setMaxTotal(MAX_CONN);
		// Increase default max connection per route
		this.connManager.setDefaultMaxPerRoute(MAX_CONN_PER_ROUTE);

		this.httpClient = HttpClients.custom()
				.setKeepAliveStrategy(keepAliveStrategy)
				.setConnectionManager(connManager)
				.setDefaultRequestConfig(requestConfig).build();

		// detect idle and expired connections and close them
		IdleConnectionMonitorThread staleMonitor = new IdleConnectionMonitorThread(connManager);
		staleMonitor.start();
	}
	
	
	
	public JSONObject postRequest(String url, JSONObject obj) throws IOException, InterruptedException
	{
		JSONObject response = null;
        HttpPost httpPost = new HttpPost(url);
        
        httpPost.setConfig(requestConfig);

        httpPost.addHeader("Content-Type", "application/json; charset=UTF-8");
        httpPost.addHeader("X-CleverTap-Account-Id", ClevertapInstance.getId());
        httpPost.addHeader("X-CleverTap-Passcode", ClevertapInstance.getPassword());
           
        StringEntity params = null;
		params = new StringEntity(obj.toString());
        httpPost.setEntity(params);
        
        int tryStatus500 = 5;
        int tryConnTimeOut = getTryConnTimeOut();
        int tryHttpHostConn = 5;
        int tryIO = 5;
        
        int timeStatus500 = 1;
        int timeConnTimeOut = 1;
        int timeHttpHostConn = 1;
        int timeIO = 1;
        
		while (true) {
			tryStatus500--;
			tryConnTimeOut--;
			tryHttpHostConn--;
			tryIO--;
			try {
				httpResponse = httpClient.execute(httpPost);
				if(httpResponse.getStatusLine().getStatusCode()>=500 && httpResponse.getStatusLine().getStatusCode()<=599)
				{
					System.out.println("Server status " + httpResponse.getStatusLine().getStatusCode() + ". Retrying to post in " + timeStatus500*2 +  " seconds...");
					TimeUnit.SECONDS.sleep(timeStatus500*2);
					timeStatus500 = 2*timeStatus500;
			        if(tryStatus500 == 0)
			        {
						System.out.println("Server status " + httpResponse.getStatusLine().getStatusCode() + ". Maximum retries exceeded, try later.");
			        	break;
			        }
			        continue;
				}
				HttpEntity entity = httpResponse.getEntity();
				String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);
				response = new JSONObject(json);
		        break;
			} catch (ClientProtocolException protocolException) {
				System.out.println("Exception occured: " + protocolException);
				protocolException.printStackTrace();
				break;	
			} catch(ConnectTimeoutException | SocketTimeoutException timeoutException) {
				System.out.println("Failed! Timeout in post request, retrying in " + timeConnTimeOut*2 + " seconds...");
				TimeUnit.SECONDS.sleep(timeConnTimeOut*2);
				timeConnTimeOut = 2*timeConnTimeOut;
			} catch(HttpHostConnectException connectionException) {
				System.out.println("Connection refused by server during post request. Retrying in " + timeHttpHostConn*2 + " seconds...");
				TimeUnit.SECONDS.sleep(timeHttpHostConn*2);
				timeHttpHostConn = timeHttpHostConn*2;
			} catch (IOException ioException) {
				System.out.println("IOException caught during post request: " + ioException + "\n Retrying in " + timeIO*2 + " seconds...");
				TimeUnit.SECONDS.sleep(timeIO*2);
				timeIO = timeIO*2;
			}
			finally {
				if(httpResponse!=null)
				{
					try {
						httpResponse.close();
					} catch (IOException ioException) {
						ioException.printStackTrace();
					}
				}
			}
			if(tryStatus500==0 || tryConnTimeOut==0 || tryHttpHostConn==0 || tryIO==0)
			{
				System.out.println("Maximum retries exceeded, try later.");
				break;
			}
		}
		return response;
	}
	
	protected int getTryConnTimeOut() {
		return 5;
	}



	public JSONObject getRequest(String url) throws IOException, InterruptedException {
		
	    JSONObject response = null;
	   
	    //Creating a HttpGet object
	    HttpGet httpGet = new HttpGet(url);

	    httpGet.setConfig(requestConfig);
	    
	    httpGet.addHeader("Content-Type", "application/json; charset=UTF-8");
	    httpGet.addHeader("X-CleverTap-Account-Id", ClevertapInstance.getId());
	    httpGet.addHeader("X-CleverTap-Passcode", ClevertapInstance.getPassword());

	    int tryStatus500 = 5;
        int tryConnTimeOut = getTryConnTimeOut();
        int tryHttpHostConn = 5;
        int tryIO = 5;
        
        int timeStatus500 = 1;
        int timeConnTimeOut = 1;
        int timeHttpHostConn = 1;
        int timeIO = 1;
        
		while (true) {
			tryStatus500--;
			tryConnTimeOut--;
			tryHttpHostConn--;
			tryIO--;
			try {
				httpResponse = httpClient.execute(httpGet);
				if(httpResponse.getStatusLine().getStatusCode()>=500 && httpResponse.getStatusLine().getStatusCode()<=599)
				{
					System.out.println("Server status " + httpResponse.getStatusLine().getStatusCode() + ". Retrying to get in " + timeStatus500*2 +  " seconds...");
					TimeUnit.SECONDS.sleep(timeStatus500*2);
					timeStatus500 = 2*timeStatus500;
			        if(tryStatus500 == 0)
			        {
						System.out.println("Server status " + httpResponse.getStatusLine().getStatusCode() + ". Maximum retries exceeded, try later.");
			        	break;
			        }
			        continue;
				}
				HttpEntity entity = httpResponse.getEntity();
				String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);
				response = new JSONObject(json);
		        break;
			} catch (ClientProtocolException protocolException) {
				System.out.println("Exception occured: " + protocolException);
				protocolException.printStackTrace();
				break;	
			} catch(ConnectTimeoutException | SocketTimeoutException timeoutException) {
				System.out.println("Failed! Timeout in get request, retrying in " + timeConnTimeOut*2 + " seconds...");
				TimeUnit.SECONDS.sleep(timeConnTimeOut*2);
				timeConnTimeOut = 2*timeConnTimeOut;
			} catch(HttpHostConnectException connectionException) {
				System.out.println("Connection refused by server during get request. Retrying in " + timeHttpHostConn*2 + " seconds...");
				TimeUnit.SECONDS.sleep(timeHttpHostConn*2);
				timeHttpHostConn = timeHttpHostConn*2;
			} catch (IOException ioException) {
				System.out.println("IOException caught during get request: " + ioException + "\n Retrying in " + timeIO*2 + " seconds...");
				TimeUnit.SECONDS.sleep(timeIO*2);
				timeIO = timeIO*2;
			} finally {
				if(httpResponse!=null)
				{
					try {
						httpResponse.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
	    	}
			if(tryStatus500==0 || tryConnTimeOut==0 || tryHttpHostConn==0 || tryIO==0)
			{
				System.out.println("Maximum retries exceeded, try later.");
				break;
			}
		}
		return response;
	}
	
	public static class IdleConnectionMonitorThread extends Thread {

		private final HttpClientConnectionManager connMgr;
		private volatile boolean shutdown;

		public IdleConnectionMonitorThread(HttpClientConnectionManager connMgr) {
			super();
			this.connMgr = connMgr;
		}

		@Override
		public void run() {
			try {
				while (!shutdown) {
					synchronized (this) {
						wait(5000);
						// Close expired connections
						connMgr.closeExpiredConnections();
						// Optionally, close connections
						// that have been idle longer than 60 sec
						connMgr.closeIdleConnections(60, TimeUnit.SECONDS);
					}
				}
			} catch (InterruptedException ex) {
				// terminate
				shutdown();
			}
		}

		public void shutdown() {
			shutdown = true;
			synchronized (this) {
				notifyAll();
			}
		}

	}
}
