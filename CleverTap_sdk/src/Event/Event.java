package Event;

import java.io.IOException;

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
	
	static String urlUploadEvent = "https://api.clevertap.com/1/upload";
	static String urlGetEventCount = "https://api.clevertap.com/1/counts/events.json";
	static String urlGetEventCursor = "https://api.clevertap.com/1/events.json";
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	public Event(){
		this.objectMapper.setSerializationInclusion(Include.NON_NULL);
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	public Response uploadEvents(EventPayload payload) throws IOException, InterruptedException
	{
		HttpClient client = new HttpClient();
		
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.postRequest(urlUploadEvent, json);

		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
	
	
	public Cursor getEventsCursor(EventPayload payload, int batch_size) throws IOException, InterruptedException
	{
		String url = urlGetEventCursor + "?batch_size=" + batch_size;
		
		HttpClient client = new HttpClient();
		
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.postRequest(url, json);
		Cursor cur = objectMapper.readValue(obj.toString(), Cursor.class);
		return cur;	
	}
	
	public GetEventsResponse getEventsData(Cursor cursor) throws IOException, InterruptedException
	{
		String url = urlGetEventCursor + "?cursor=" + cursor.getCursor();
		
		HttpClient client = new HttpClient();
		JSONObject obj = client.getRequest(url);
		
		GetEventsResponse res = objectMapper.readValue(obj.toString(), GetEventsResponse.class);
		
		return res;	
	}
	
	public Response getEventCount(EventPayload payload) throws IOException, InterruptedException
	{
		HttpClient client = new HttpClient();
		
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.postRequest(urlGetEventCount, json);

		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
}
