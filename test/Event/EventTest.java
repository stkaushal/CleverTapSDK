package Event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import HTTP.HttpClient;
import Helper.Cursor;
import Payload.EventPayload;
import Response.GetEventsResponse;
import Response.Response;

public class EventTest {
	
	@Mock HttpClient client;
	@Mock Cursor cursorMock;
	@InjectMocks Event event;

	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("Before Event test call");
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testUploadEvents() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		EventPayload payload = new EventPayload();
		payload.setFBID("Random_id");
		payload.setFrom(01012020);
		payload.setTo(01022021);
		payload.setEvent_name("test");
		payload.setTs(0126542);
		payload.setGPID("dummy");
		payload.setEvtName("dummy");
		payload.setType("test");
		payload.setTimestamp("dummy");
		payload.setIdentity("dummy");
		payload.setObjectId("dummy");
		HashMap<String, Object> evtData = new HashMap<String, Object>();
		evtData.put("key", "value");
		HashMap<String, String> event_properties = new HashMap<String, String>();
		event_properties.put("key", "value");
		payload.setEvtData(evtData);
		payload.setEvent_properties(event_properties);
		
		List<EventPayload> payloadList = new ArrayList<EventPayload>();
		payloadList.add(payload);
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = event.uploadEvents(payloadList);
   
		Assertions.assertNotNull(response);
        Assertions.assertEquals("success", response.getStatus());
	}

	@Test
	public void testGetEventsCursor() throws IOException, InterruptedException {
		Cursor cursor = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("cursor", "fhsklaioclamlkkjadajj");
		EventPayload payload = new EventPayload();
		payload.setFBID("Random_id");
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);

		cursor = event.getEventsCursor(payload, 0);
		
		Assertions.assertNotNull(cursor);
		Assertions.assertEquals("fhsklaioclamlkkjadajj", cursor.getCursor());
	}

	@Test
	public void testGetEventsData() throws IOException, InterruptedException {
		GetEventsResponse response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		Mockito.when(client.getRequest(Mockito.anyString())).thenReturn(jsonResponse);
		
		response = event.getEventsData(cursorMock);
		
		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());
	}

	@Test
	public void testGetEventCount() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		EventPayload payload = new EventPayload();
		payload.setFBID("Random_id");
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = event.getEventCount(payload);
   
		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());
	}

}
