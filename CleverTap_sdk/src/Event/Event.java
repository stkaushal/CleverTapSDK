package Event;

import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import HTTP.Http_Client;
import Helper.Cursor;
import Payload.EventPayload;
import Response.GetEventsResponse;
import Response.Response;

public class Event {
	
	static String urlUploadEvent = "https://api.clevertap.com/1/upload";
	static String urlGetEventCount = "https://api.clevertap.com/1/counts/events.json";
	static String urlGetEventCursor = "https://api.clevertap.com/1/events.json";
	
	public Response uploadEvents(EventPayload payload) throws IOException
	{
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlUploadEvent, json);

		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
	
	
	public Cursor getEventsCursor(EventPayload payload, int batch_size) throws IOException
	{
		String url = urlGetEventCursor + "?batch_size=" + batch_size;
		
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(url, json);
		
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Cursor cur = objectMapper.readValue(obj.toString(), Cursor.class);
		return cur;	
	}
	
	public GetEventsResponse getEventsData(Cursor cursor) throws IOException
	{
		String url = urlGetEventCursor + "?cursor=" + cursor.getCursor();
		
		Http_Client client = new Http_Client();
		JSONObject obj = client.get_request(url);
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		GetEventsResponse res = objectMapper.readValue(obj.toString(), GetEventsResponse.class);
		
		return res;	
	}
	
	public Response getEventCount(EventPayload payload) throws IOException
	{
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlGetEventCount, json);

		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Response res = objectMapper.readValue(obj.toString(), Response.class);
		
		return res;
	}
}
