package Report;

import java.io.IOException;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import HTTP.HttpClient;
import Payload.ReportPayload;
import Response.Response;

public class ReportTest {
	
	@Mock HttpClient client;
	@InjectMocks Report report;

	@Before
	public void setUp() throws Exception {
		System.out.println("Before profile test call");
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetRealTimeCounts() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		ReportPayload payload = new ReportPayload();
		payload.setEvent_name("Bought watch");;
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = report.getRealTimeCounts(payload);
   
		Assert.assertNotNull(response);
        Assert.assertEquals("success", response.getStatus());
	}

	@Test
	public void testGetMessageReports() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		ReportPayload payload = new ReportPayload();
		payload.setEvent_name("Bought watch");;
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = report.getMessageReports(payload);
   
		Assert.assertNotNull(response);
        Assert.assertEquals("success", response.getStatus());
	}

	@Test
	public void testGetTopPropertyCount() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		ReportPayload payload = new ReportPayload();
		payload.setEvent_name("Bought watch");;
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = report.getTopPropertyCount(payload);
   
		Assert.assertNotNull(response);
        Assert.assertEquals("success", response.getStatus());
	}

	@Test
	public void testGetTrends() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		ReportPayload payload = new ReportPayload();
		payload.setEvent_name("Bought watch");;
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = report.getTrends(payload);
   
		Assert.assertNotNull(response);
        Assert.assertEquals("success", response.getStatus());
	}

}
