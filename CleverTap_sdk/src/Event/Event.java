package Event;

import java.io.IOException;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
		String status;
		int processed;
		String unprocessed;
		int code;
		String error;
		
		Response res = new Response();
		
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlUploadEvent, json);

		if(obj.has("status"))
		{
			status = obj.getString("status");
			res.setStatus(status);
		}
		if(obj.has("processed"))
		{
			processed = obj.getInt("processed");
			res.setProcessed(processed);
		}
		if(obj.has("unprocessed"))
		{
			unprocessed = obj.getString("unprocessed");
			res.setUnprocessed(unprocessed);
		}
		if(obj.has("code"))
		{
			code = obj.getInt("code");
			res.setCode(code);
		}
		if(obj.has("error"))
		{
			error = obj.getString("error");
			res.setError(error);
		}
		return res;
	}
	
	
	public Cursor getEventsCursor(EventPayload payload, int batch_size) throws IOException
	{
		Cursor cur = new Cursor();
		String url = urlGetEventCursor + "?batch_size=" + batch_size;
		
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(url, json);
		
		String cursor = null;
		if(obj.has("cursor")) {
			cursor = obj.getString("cursor");
			cur.setCur(cursor);
		}
		
		return cur;	
	}
	
	public GetEventsResponse getEventsData(Cursor cursor) throws IOException
	{
		String url = urlGetEventCursor + "?cursor=" + cursor.getCur();
		GetEventsResponse res = new GetEventsResponse();
		
		Http_Client client = new Http_Client();
		JSONObject obj = client.get_request(url);
		
		String status = null;
		String next_cur = null;
		JSONObject records;
		
		if(obj.has("status"))
		{
			status = obj.getString("status");
			res.setStatus(status);
		}
		if(obj.has("next_cursor"))
		{
			next_cur = obj.getString("next_cursor");
			res.setNextCursor(next_cur);
		}
		if(obj.has("records"))
		{
			records = obj.getJSONObject("records");
			res.setRecords(records);
		}
		return res;	
	}
	
	public Response getEventCount(EventPayload payload) throws IOException
	{
		String status;
		int count;
		int code;
		String error;
		long req_id;
		
		Response res = new Response();
		
		Http_Client client = new Http_Client();
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JSONObject json = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject obj = client.post_request(urlGetEventCount, json);

		if(obj.has("status"))
		{
			status = obj.getString("status");
			res.setStatus(status);
		}
		if(obj.has("count"))
		{
			count = obj.getInt("count");
			res.setCount(count);
		}
		if(obj.has("req_id"))
		{
			req_id = obj.getLong("req_id");
			res.setReq_id(req_id);
		}
		if(obj.has("code"))
		{
			code = obj.getInt("code");
			res.setCode(code);
		}
		if(obj.has("error"))
		{
			error = obj.getString("error");
			res.setError(error);
		}
		return res;
	}
}
