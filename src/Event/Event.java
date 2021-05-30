package Event;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import HTTP.HttpClient;
import Helper.Cursor;
import Payload.EventPayload;
import Response.GetEventsResponse;
import Response.Response;

public class Event {
	
	private static final String urlUploadEvent = "https://api.clevertap.com/1/upload";
	private static final String urlGetEventCount = "https://api.clevertap.com/1/counts/events.jsonPayload";
	private static final String urlGetEventCursor = "https://api.clevertap.com/1/events.jsonPayload";
	
	private ObjectMapper objectMapper;
	private HttpClient client;
	
	public Event(){
		this.client = new HttpClient();
		this.objectMapper = new ObjectMapper();
		this.objectMapper.setSerializationInclusion(Include.NON_NULL);
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	public Response uploadEvents(List<EventPayload> payload) throws IOException, InterruptedException
	{
		JSONArray jsonPayloadArray = new JSONArray(objectMapper.writeValueAsString(payload));
		JSONObject jsonPayload = new JSONObject();
		jsonPayload.put("d", jsonPayloadArray);
		JSONObject jsonResponse = client.postRequest(urlUploadEvent, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);	
		return res;
	}
	
	
	public Cursor getEventsCursor(EventPayload payload, int batch_size) throws IOException, InterruptedException
	{
		String url = urlGetEventCursor + "?batch_size=" + String.valueOf(batch_size);
		
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(url, jsonPayload);
		Cursor cur = objectMapper.readValue(jsonResponse.toString(), Cursor.class);
		return cur;	
	}
	
	public GetEventsResponse getEventsData(Cursor cursor) throws IOException, InterruptedException
	{
		String url = urlGetEventCursor + "?cursor=" + cursor.getCursor();
		
		JSONObject jsonResponse = client.getRequest(url);
		GetEventsResponse res = objectMapper.readValue(jsonResponse.toString(), GetEventsResponse.class);
		return res;	
	}
	
	public Response getEventCount(EventPayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlGetEventCount, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		return res;
	}
}