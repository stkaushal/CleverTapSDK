package HTTP;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicStatusLine;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import HTTP.HttpClient;

public class HttpClientTest {
	
	private static String URL_DUMMY = "random";
	
	@Mock private CloseableHttpClient httpClient;
	@Mock private CloseableHttpResponse httpResponse;
	@Mock private HttpEntity entity;
	@Mock private JSONObject payload;
	@InjectMocks private HttpClient client;
	
	@Mock private HttpClient clientMock;
	
	@BeforeEach
	public void setup() {
		System.out.println("Before HttpClient test call");
		MockitoAnnotations.initMocks(this);
	}

	
	@Test
	public void testHttpClient() {
		//fail("Not yet implemented");
	}

	@Test
	public void testPostRequest() {
		JSONObject result = null;
	
        try {
        	Mockito.when(httpResponse.getStatusLine()).thenReturn(new BasicStatusLine(HttpVersion.HTTP_1_1, 200, null));
        	Mockito.when(httpResponse.getEntity()).thenReturn(entity);
        	InputStream stream = new ByteArrayInputStream("{ \"dummy\" : \"string\" }".getBytes());
        	Mockito.when(entity.getContent()).thenReturn(stream);
			Mockito.when(httpClient.execute(Mockito.any(HttpPost.class))).thenReturn(httpResponse);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        try {
            result = client.postRequest(URL_DUMMY, payload);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
        
        Assertions.assertEquals(200, httpResponse.getStatusLine().getStatusCode());
        Assertions.assertNotNull(result);
        Assertions.assertEquals("string", result.getString("dummy"));
	}
	
	@Test
	public void testGetRequest() {
		JSONObject result = null;
		
        try {
        	Mockito.when(httpResponse.getStatusLine()).thenReturn(new BasicStatusLine(HttpVersion.HTTP_1_1, 200, null));
        	Mockito.when(httpResponse.getEntity()).thenReturn(entity);
        	InputStream stream = new ByteArrayInputStream("{ \"dummy\" : \"string\" }".getBytes());
        	Mockito.when(entity.getContent()).thenReturn(stream);
			Mockito.when(httpClient.execute(Mockito.any(HttpGet.class))).thenReturn(httpResponse);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
        try {
            result = client.getRequest(URL_DUMMY);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
        
        Assertions.assertEquals(200, httpResponse.getStatusLine().getStatusCode());
        Assertions.assertNotNull(result);
        Assertions.assertEquals("string", result.getString("dummy"));
	}
	
//	@Test
//	public void testConnectTimeoutException() throws IOException, InterruptedException {
//		
//		Mockito.when(httpResponse.getStatusLine()).thenReturn(new BasicStatusLine(HttpVersion.HTTP_1_1, 500, null));
//    	Mockito.when(httpResponse.getEntity()).thenReturn(entity);
//    	InputStream stream = new ByteArrayInputStream("{ \"dummy\" : \"string\" }".getBytes());
//    	Mockito.when(entity.getContent()).thenReturn(stream);
//    	ConnectTimeoutException connExc = new ConnectTimeoutException();
//    	
//		Mockito.when(httpClient.execute(Mockito.any(HttpPost.class))).thenThrow(connExc).thenReturn(httpResponse);
//		Mockito.when(httpClient.execute(Mockito.any(HttpGet.class))).thenThrow(connExc).thenReturn(httpResponse);
//		
//	    Mockito.doReturn(0).when(clientMock).getTryConnTimeOut();
//		
//		try {
//			clientMock.getRequest(URL_DUMMY);
//			clientMock.postRequest(URL_DUMMY, payload);
//		}catch(ConnectTimeoutException e) {
//			Assert.assertTrue(true);
//		}
//		 Assert.assertEquals(500, httpResponse.getStatusLine().getStatusCode());
//	}
	
//	@Test
//	public void testSocketTimeoutException() throws IOException, InterruptedException {
//		
//		Mockito.when(httpResponse.getStatusLine()).thenReturn(new BasicStatusLine(HttpVersion.HTTP_1_1, 500, null));
//    	Mockito.when(httpResponse.getEntity()).thenReturn(entity);
//    	InputStream stream = new ByteArrayInputStream("{ \"dummy\" : \"string\" }".getBytes());
//    	Mockito.when(entity.getContent()).thenReturn(stream);
//    	SocketTimeoutException connSoc = new SocketTimeoutException();
//    	
//		Mockito.when(httpClient.execute(Mockito.any(HttpPost.class))).thenThrow(connSoc).thenReturn(httpResponse);
//		Mockito.when(httpClient.execute(Mockito.any(HttpGet.class))).thenThrow(connSoc).thenReturn(httpResponse);
//		
//	    Mockito.doReturn(0).when(clientMock).getTryConnTimeOut();
//		
//		try {
//			clientMock.getRequest(URL_DUMMY);
//			clientMock.postRequest(URL_DUMMY, payload);
//		}catch(SocketTimeoutException e) {
//			Assert.assertTrue(true);
//		}
//		Assert.assertEquals(500, httpResponse.getStatusLine().getStatusCode());
//	}
//	
//	@Test
//	public void testClientProtocolException() throws IOException, InterruptedException {
//		
//		Mockito.when(httpResponse.getStatusLine()).thenReturn(new BasicStatusLine(HttpVersion.HTTP_1_1, 200, null));
//    	Mockito.when(httpResponse.getEntity()).thenReturn(entity);
//    	InputStream stream = new ByteArrayInputStream("{ \"dummy\" : \"string\" }".getBytes());
//    	Mockito.when(entity.getContent()).thenReturn(stream);
//    	
//    	ClientProtocolException cliExc = new ClientProtocolException();
//    	
//		Mockito.when(httpClient.execute(Mockito.any(HttpGet.class))).thenThrow(cliExc);
//		Mockito.when(httpClient.execute(Mockito.any(HttpPost.class))).thenThrow(cliExc);
//    	
//		
//		try {
//			client.getRequest(URL_DUMMY);
//			client.postRequest(URL_DUMMY, payload);
//		}catch(ClientProtocolException e) {
//			Assert.assertTrue(true);
//		}
		
//	}
}