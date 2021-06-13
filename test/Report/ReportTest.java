package Report;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import HTTP.HttpClient;
import Helper.ClevertapInstance;
import Payload.Group;
import Payload.ReportPayload;
import Response.Response;

public class ReportTest {
	
	ClevertapInstance instance  = new ClevertapInstance("dummy", "dummy");
	Report resReport = instance.getReportInstance();
	
	@Mock HttpClient client;
	@InjectMocks Report report;

	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("Before Report test call");
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetRealTimeCounts() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		ReportPayload payload = new ReportPayload();
		payload.setEventName("Bought watch");
		payload.setFromDate(01012020);
		payload.setToDate(01012021);
		String[] delivery = {"dummy"};
		payload.setDelivery(delivery);
		
		HashMap<String, Group> groups = new HashMap<String, Group>();
		Group group = new Group();
		group.setPropertyName("dummy");
		group.setOrder("dummy");
		group.setPropertyType("dummy");
		group.setTopNValues(1);
		group.setTrendType("dummy");
		groups.put("group", group);
		
		payload.setGroups(groups);
		payload.setUserType(true);
		
		String[] channel = {"dummy"};
		payload.setChannel(channel);
		payload.setDaily(true);
		String[] status = {"dummy"};
		payload.setStatus(status);
		String[] message_type = {"dummy"};
		payload.setMessage_type(message_type);
		String[] lable = {"dummy"};
		payload.setLable(lable);
		payload.setUnique(true);
		payload.setSumEventProp("dummy");
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = report.getRealTimeCounts(payload);
   
		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());
	}

	@Test
	public void testGetMessageReports() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		ReportPayload payload = new ReportPayload();
		payload.setEventName("Bought watch");;
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = report.getMessageReports(payload);
   
		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());
	}

	@Test
	public void testGetTopPropertyCount() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		ReportPayload payload = new ReportPayload();
		payload.setEventName("Bought watch");;
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = report.getTopPropertyCount(payload);
   
		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());
	}

	@Test
	public void testGetTrends() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		ReportPayload payload = new ReportPayload();
		payload.setEventName("Bought watch");;
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = report.getTrends(payload);
   
		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());
	}

}
