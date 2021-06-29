package HTTP;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ServiceUnavailableRetryStrategy;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import Helper.ClevertapInstance;

import org.apache.http.conn.HttpClientConnectionManager;

public class HttpClient {

	private static final int KEEP_ALIVE = 5 * 60 * 1000;
	private static final int MAX_CONN = 3;
	private static final int MAX_CONN_PER_ROUTE = 3;
	private static final int CONN_TIMEOUT = 10 * 1000;
	private static final int RETRY_AFTER = 3*1000;
	int maxRetries = 3;
	private RequestConfig requestConfig;
	private CloseableHttpClient httpClient;
	private CloseableHttpResponse httpResponse;
	private PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();

	private ConnectionKeepAliveStrategy keepAliveStrategy = new ConnectionKeepAliveStrategy() {

		@Override
		public long getKeepAliveDuration(org.apache.http.HttpResponse response,
				org.apache.http.protocol.HttpContext context) {
			HeaderElementIterator it = new BasicHeaderElementIterator(
					response.headerIterator(HTTP.CONN_KEEP_ALIVE));
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

	private HttpRequestRetryHandler myHttpRequestRetryHandler = new HttpRequestRetryHandler() {
		@Override
        public boolean retryRequest(IOException exception, int retryTimes, HttpContext context) {
        	//logger.error("retryRequest:"+retryTimes);
        	if (retryTimes >= maxRetries) {
                return false;
            }
			if (exception instanceof ConnectTimeoutException || exception instanceof NoHttpResponseException || exception instanceof SocketTimeoutException
					|| !(exception instanceof UnknownHostException) || !(exception instanceof InterruptedIOException) || !(exception instanceof SSLException)
					|| !(exception instanceof SSLHandshakeException)) {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return true;
			}else {
				 System.out.println("unlogged request exception:" + exception.getClass());
			}

            HttpClientContext clientContext = HttpClientContext.adapt(context);
            HttpRequest request = clientContext.getRequest();
            boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
            if (idempotent) {
            	try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}                     
                return true; // If the request is considered to be idempotent, then try again. That is, repeated execution does not affect other effects of the program.
            }
            return false;

		}
	};

	private ServiceUnavailableRetryStrategy myServiceUnavailableRetryStrategy = new ServiceUnavailableRetryStrategy() {
		int waitPeriod = RETRY_AFTER;
		@Override
		public boolean retryRequest(HttpResponse response, int executionCount, HttpContext context) {
			if(response.getStatusLine().getStatusCode() >= 500 || response.getStatusLine().getStatusCode() == 408)
			{	
				waitPeriod = getRetryAfterTime(response);
				return executionCount <= maxRetries;
			}
			else if(response.getStatusLine().getStatusCode() == 429)
			{
				waitPeriod = getRetryAfterTime(response);
				return executionCount <= maxRetries;
			}
			return false;
		}

		@Override
		public long getRetryInterval() {
			return waitPeriod;
		}
	};
	
	private int getRetryAfterTime(HttpResponse response) {
		String retryAfter = null;
		if(response.getFirstHeader("Retry-After") != null)
		{
			retryAfter = response.getFirstHeader("Retry-After").getValue();
		}
		
		if(retryAfter!=null  && !retryAfter.isEmpty())
		{
			return Integer.parseInt(retryAfter);
		}
		return RETRY_AFTER;
	};

	public HttpClient() {
		this.httpResponse = null;

		this.requestConfig = RequestConfig.custom()
				.setSocketTimeout(CONN_TIMEOUT)
				.setConnectTimeout(CONN_TIMEOUT)
				.setConnectionRequestTimeout(CONN_TIMEOUT)
				.setExpectContinueEnabled(true)
				.build();

		this.connManager.setMaxTotal(MAX_CONN);
		// Increase default max connection per route
		this.connManager.setDefaultMaxPerRoute(MAX_CONN_PER_ROUTE);

		this.httpClient = HttpClients.custom()
				.setKeepAliveStrategy(keepAliveStrategy)
				.setConnectionManager(connManager)
				.setDefaultRequestConfig(requestConfig)
				.setRetryHandler(myHttpRequestRetryHandler)
				.setServiceUnavailableRetryStrategy(myServiceUnavailableRetryStrategy)
				.build();

		// detect idle and expired connections and close them
		IdleConnectionMonitorThread staleMonitor = new IdleConnectionMonitorThread(connManager);
		staleMonitor.start();
	}

	public JSONObject postRequest(String baseUrl, JSONObject obj) throws IOException, InterruptedException {
		JSONObject response = null;
		HttpPost httpPost = new HttpPost(baseUrl);

		httpPost.setConfig(requestConfig);

		httpPost.addHeader("Content-Type", "application/json; charset=UTF-8");
		httpPost.addHeader("X-CleverTap-Account-Id", ClevertapInstance.getId());
		httpPost.addHeader("X-CleverTap-Passcode", ClevertapInstance.getPassword());

		StringEntity params = null;
		params = new StringEntity(obj.toString());
		httpPost.setEntity(params);

		httpResponse = httpClient.execute(httpPost);

		HttpEntity entity = httpResponse.getEntity();
		String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);
		response = new JSONObject(json);

		if (httpResponse != null) {
			try {
				httpResponse.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}

		return response;
	}

	public JSONObject getRequest(String baseUrl) throws IOException, InterruptedException {

		JSONObject response = null;

		// Creating a HttpGet object
		HttpGet httpGet = new HttpGet(baseUrl);

		httpGet.setConfig(requestConfig);

		httpGet.addHeader("Content-Type", "application/json; charset=UTF-8");
		httpGet.addHeader("X-CleverTap-Account-Id", ClevertapInstance.getId());
		httpGet.addHeader("X-CleverTap-Passcode", ClevertapInstance.getPassword());

		httpResponse = httpClient.execute(httpGet);

		HttpEntity entity = httpResponse.getEntity();
		String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);
		response = new JSONObject(json);

		if (httpResponse != null) {
			try {
				httpResponse.close();
			} catch (IOException e) {
				e.printStackTrace();
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
