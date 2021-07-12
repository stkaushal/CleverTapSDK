package event.unit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import event.Event;
import helper.ClevertapInstance;
import helper.enums.Region;
import http.HttpClient;
import payload.Cursor;
import payload.event.EventPayload;
import payload.event.EventPropertyFilter;
import response.GetEventsResponse;
import response.Response;

public class EventUnitTest {
	
	ClevertapInstance instance  = new ClevertapInstance("dummy", "dummy", Region.NONE);
	Event resEvent = instance.getEventInstance();
	
	@Mock HttpClient client;
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
		payload.setFbid("Random_id");
		payload.setFromDate(01012020);
		payload.setToDate(01022021);
		payload.setEventNameUpload("test");
		payload.setTs(0126542);
		payload.setGpid("dummy");
		payload.setType("test");
		payload.setTimestamp("dummy");
		payload.setIdentity("dummy");
		payload.setObjectId("dummy");
		HashMap<String, Object> evtData = new HashMap<String, Object>();
		evtData.put("key", "value");
		payload.setEventData(evtData);
		
		
		EventPropertyFilter eventProps = new EventPropertyFilter();
	    eventProps.setPropertName("dummy");
	    eventProps.setOperator("dummy");
	    eventProps.setPropertValue("dummy");
	    List<EventPropertyFilter> eventPropList = new ArrayList<EventPropertyFilter>();
	    eventPropList.add(eventProps);
	   
	   payload.setEventProperties(eventPropList);
		
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
		payload.setFbid("Random_id");
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);

		cursor = event.getEventsCursor(payload, 0, true, true, true);
		
		Assertions.assertNotNull(cursor);
		Assertions.assertEquals("fhsklaioclamlkkjadajj", cursor.getCursor());
	}

	@Test
	public void testGetEventsData() throws IOException, InterruptedException {
		GetEventsResponse response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		jsonResponse.put("next_cursor", "dummy");
		
		JSONArray records = new JSONArray();
		JSONObject jsonRecords = new JSONObject();
		JSONObject profile = new JSONObject();
		profile.put("objectId", "dummy");
		profile.put("platform", "dummy");
		profile.put("email", "dummy");
		JSONObject profileData = new JSONObject();
		profileData.put("test", "dummy");
		profile.put("profileData", profileData);
		profile.put("identity", 1);
		profile.put("id", 1);
		jsonRecords.put("profile", profile);
		jsonRecords.put("ts", 1);
		JSONObject event_props = new JSONObject();
		event_props.put("test", "dummy");
		jsonRecords.put("event_props", event_props);
		JSONObject session_props = new JSONObject();
		session_props.put("test", "dummy");
		jsonRecords.put("session_props", session_props);
		
		records.put(jsonRecords);
		jsonResponse.put("records", records);
		
		
		Mockito.when(client.getRequest(Mockito.anyString())).thenReturn(jsonResponse);
		
		response = event.getEventsData("dummy");
		
		Assertions.assertNotNull(response);
		Assertions.assertNotNull(response.getNextCursor());
		Assertions.assertNotNull(response.getRecords());
		Assertions.assertNotNull(response.getRecords().get(0).getEventProps());
		Assertions.assertNotNull(response.getRecords().get(0).getProfile());
		Assertions.assertNotNull(response.getRecords().get(0).getProfile().getEmail());
		Assertions.assertNotNull(response.getRecords().get(0).getProfile().getId());
		Assertions.assertNotNull(response.getRecords().get(0).getProfile().getIdentity());
		Assertions.assertNotNull(response.getRecords().get(0).getProfile().getObjectId());
		Assertions.assertNotNull(response.getRecords().get(0).getProfile().getPlatform());
		Assertions.assertNotNull(response.getRecords().get(0).getProfile().getProfileData());
		Assertions.assertNotNull(response.getRecords().get(0).getSessionProps());
		Assertions.assertNotNull(response.getRecords().get(0).getTimestamp());
		Assertions.assertEquals("success", response.getStatus());
	}

	@Test
	public void testGetEventCount() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		EventPayload payload = new EventPayload();
		payload.setFbid("Random_id");
		payload.setEventNameDownload("dummy");
		
		Mockito.when(client.postRequest(Mockito.anyString(), Mockito.any(JSONObject.class))).thenReturn(jsonResponse);
		
		response = event.getEventCount(payload);
   
		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());
	}
	
	@Test
	public void testGetEventCountByReqId() throws IOException, InterruptedException {
		Response response = null;
		JSONObject jsonResponse = new JSONObject();
		jsonResponse.put("status", "success");
		
		Mockito.when(client.getRequest(Mockito.anyString())).thenReturn(jsonResponse);
		
		response = event.getEventCountByReqId(0);
   
		Assertions.assertNotNull(response);
		Assertions.assertEquals("success", response.getStatus());
	}

}
