package HTTP;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import org.apache.http.conn.HttpClientConnectionManager;

public class Http_Client {
    String Cid = "4R8-K98-8Z6Z";
	String CPswd = "AOE-RUW-CHUL";
	
	private int keepAlive = 5*60*1000;
	CloseableHttpClient httpClient = null;
	private PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
	
	private ConnectionKeepAliveStrategy keepAliveStrategy = new ConnectionKeepAliveStrategy() {
		
		@Override
		public long getKeepAliveDuration(org.apache.http.HttpResponse response, org.apache.http.protocol.HttpContext context) {
			HeaderElementIterator it = new BasicHeaderElementIterator(response.headerIterator(HTTP.CONN_KEEP_ALIVE));
			while (it.hasNext()) {
				HeaderElement he = it.nextElement();
				String param = he.getName();
				String value = he.getValue();
				if (value != null && param.equalsIgnoreCase("timeout")) {
					return Long.parseLong(value) * 1000;
				}
			}
			return keepAlive;
		}
	};
	
	public Http_Client()
	{
		connManager.setMaxTotal(3);
		// Increase default max connection per route
		connManager.setDefaultMaxPerRoute(3);

		// config timeout
		RequestConfig config = RequestConfig.custom()
				.setConnectTimeout(10*1000)
				.setConnectionRequestTimeout(10*1000)
				.setSocketTimeout(10*1000).build();

		httpClient = HttpClients.custom()
				.setKeepAliveStrategy(keepAliveStrategy)
				.setConnectionManager(connManager)
				.setDefaultRequestConfig(config).build();

		// detect idle and expired connections and close them
		IdleConnectionMonitorThread staleMonitor = new IdleConnectionMonitorThread(connManager);
		staleMonitor.start();
	}
	
	
	
	public JSONObject post_request(String url, JSONObject obj) throws IOException
	{
		
		JSONObject res = null;
        HttpPost httppost = new HttpPost(url);
        
        RequestConfig requestConfig = RequestConfig.custom()
	    		  .setSocketTimeout(3000)
	    		  .setConnectTimeout(3000)
	    		  .setConnectionRequestTimeout(3000)
	    		  .build();

        httppost.setConfig(requestConfig);

        //Printing the method used
        //System.out.println("Request Type: "+httppost.getMethod());
        httppost.addHeader("Content-Type", "application/json; charset=UTF-8");
        httppost.addHeader("X-CleverTap-Account-Id", Cid);
        httppost.addHeader("X-CleverTap-Passcode", CPswd);
        
        
        StringEntity params = null;
		try {
			params = new StringEntity(obj.toString());
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}
        httppost.setEntity(params);
        
        CloseableHttpResponse httpresponse = null;
        int tries = 5;
        int timeoutSeed = 1;
		while (true) {
			tries--;
			try {
				httpresponse = httpClient.execute(httppost);
//				if(httpresponse.getStatusLine().getStatusCode()>=500 && httpresponse.getStatusLine().getStatusCode()<=599)
//				{
//					System.out.println("Server status code between 500 to 599. Retrying to post in 3 seconds...");
//					try {
//						TimeUnit.SECONDS.sleep(3);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
				HttpEntity entity = httpresponse.getEntity();
//				Header encodingHeader = (Header) entity.getContentEncoding();
//
//				// you need to know the encoding to parse correctly
//				Charset encoding = encodingHeader == null ? StandardCharsets.UTF_8 : 
//				Charsets.toCharset(((HeaderElement) encodingHeader).getValue());

				// use org.apache.http.util.EntityUtils to read json as string
				String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);

				res = new JSONObject(json);

		        break;
			} catch (ClientProtocolException e1) {
				if (tries < 1)
					throw e1;
			} catch(ConnectTimeoutException | SocketTimeoutException ex) {
				System.out.println("Failed! Timeout in post request, retrying in " + timeoutSeed*2 + " seconds...");
				requestConfig = RequestConfig.custom()
			    		  .setSocketTimeout(timeoutSeed*2*1000)
			    		  .setConnectTimeout(timeoutSeed*2*1000)
			    		  .setConnectionRequestTimeout(timeoutSeed*2*1000)
			    		  .build();
		        httppost.setConfig(requestConfig);
		        timeoutSeed = 2*timeoutSeed;
				if (tries < 1) {
					throw ex;
				}
			} catch(HttpHostConnectException ee) {
				System.out.println("Connection refused by server during post request. Retrying in " + timeoutSeed*2 + " seconds...");
				try {
					TimeUnit.SECONDS.sleep(timeoutSeed*2);
					timeoutSeed = timeoutSeed*2;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (tries < 1)
					throw ee;
			}catch (IOException e1) {
				if (tries < 1)
					throw e1;
			}
			finally {
				if(httpresponse!=null)
				{
					try {
						httpresponse.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return res;
	}
	
	public JSONObject get_request(String url) throws IOException {
		
	    JSONObject res = null;
	   
	    //Creating a HttpGet object
	    HttpGet httpget = new HttpGet(url);
	    
	    RequestConfig requestConfig = RequestConfig.custom()
	    		  .setSocketTimeout(3000)
	    		  .setConnectTimeout(3000)
	    		  .setConnectionRequestTimeout(3000)
	    		  .build();

	    httpget.setConfig(requestConfig);
	    httpget.addHeader("Content-Type", "application/json; charset=UTF-8");
	    httpget.addHeader("X-CleverTap-Account-Id", Cid);
	    httpget.addHeader("X-CleverTap-Passcode", CPswd);

	    //Printing the method used
	    //System.out.println("Request Type: "+httpget.getMethod());

	    //Executing the Get request
	    CloseableHttpResponse httpresponse = null;
	    int tries = 5;
	    int timeoutSeed = 1;
		while (true) {
			tries--;
			try {
				httpresponse = httpClient.execute(httpget);
//				if(httpresponse.getStatusLine().getStatusCode()>=500 && httpresponse.getStatusLine().getStatusCode()<=599)
//				{
//					System.out.println("Server status code between 500 to 599. Retring to post in 3 seconds...");
//					try {
//						TimeUnit.SECONDS.sleep(3);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
				HttpEntity entity = httpresponse.getEntity();
//				Header encodingHeader = (Header) entity.getContentEncoding();
//
//				// you need to know the encoding to parse correctly
//				Charset encoding = encodingHeader == null ? StandardCharsets.UTF_8 : 
//				Charsets.toCharset(((HeaderElement) encodingHeader).getValue());

				// use org.apache.http.util.EntityUtils to read json as string
				String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);

				res = new JSONObject(json);
				break;
			} catch (ClientProtocolException e1) {
				if (tries < 1)
					throw e1;
			} catch(ConnectTimeoutException | SocketTimeoutException ex) {
				System.out.println("Failed! Timeout in get request, retrying in " + timeoutSeed*2 + " seconds...");
				requestConfig = RequestConfig.custom()
			    		  .setSocketTimeout(timeoutSeed*2*1000)
			    		  .setConnectTimeout(timeoutSeed*2*1000)
			    		  .setConnectionRequestTimeout(timeoutSeed*2*1000)
			    		  .build();
		        httpget.setConfig(requestConfig);
		        timeoutSeed = 2*timeoutSeed;
				if (tries < 1) {
					throw ex;
				}
			} catch(HttpHostConnectException ee) {
				System.out.println("Connection refused by server during get request. Retrying in " + timeoutSeed*2 + " seconds...");
				try {
					TimeUnit.SECONDS.sleep(timeoutSeed*2);
					timeoutSeed = timeoutSeed*2;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (tries < 1)
					throw ee;
			}catch (IOException e1) {
				if (tries < 1)
					throw e1;
			} finally {
				if(httpresponse!=null)
				{
					try {
						httpresponse.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
	    	}
		}
	    	
	    
		return res;
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
