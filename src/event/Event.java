package event;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import helper.ClevertapInstance;
import helper.Cursor;
import http.HttpClient;
import payload.event.EventPayload;
import response.GetEventsResponse;
import response.Response;

// TODO: Auto-generated Javadoc
/**
 * The Class Event.
 */
public class Event {
	
	/** The Constant urlUploadEvent. */
	private static final String urlUploadEvent = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/upload";
	
	/** The Constant urlGetEventCount. */
	private static final String urlGetEventCount = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/counts/events.json";
	
	/** The Constant urlGetEventCursor. */
	private static final String urlGetEventCursor = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/events.json";
	
	/** The Constant urlGetEventCountByReqId. */
	private static final String urlGetEventCountByReqId = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/counts/events.json?req_id=";
	
	/** The object mapper. */
	private ObjectMapper objectMapper;
	
	/** The client. */
	private HttpClient client;
	
	/**
	 * Instantiates a new event.
	 */
	public Event(){
		this.client = new HttpClient();
		this.objectMapper = new ObjectMapper();
		this.objectMapper.setSerializationInclusion(Include.NON_NULL);
		this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	/**
	 * Upload events.
	 *
	 * @param payload the payload
	 * @return the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response uploadEvents(List<EventPayload> payload) throws IOException, InterruptedException
	{
		JSONArray jsonPayloadArray = new JSONArray(objectMapper.writeValueAsString(payload));
		JSONObject jsonPayload = new JSONObject();
		jsonPayload.put("d", jsonPayloadArray);
		JSONObject jsonResponse = client.postRequest(urlUploadEvent, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);	
		return res;
	}
	
	
	/**
	 * Gets the events cursor.
	 *
	 * @param payload the payload
	 * @param batch_size the batch size
	 * @param app the app
	 * @param events the events
	 * @param profile the profile
	 * @return the events cursor
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Cursor getEventsCursor(EventPayload payload, int batch_size, boolean app, boolean events, boolean profile) throws IOException, InterruptedException
	{
		String url = urlGetEventCursor + "?batch_size=" + String.valueOf(batch_size) + "&" + "?app=" + String.valueOf(app) + 
				"&" + "?events=" + String.valueOf(events) + "&" + "?profile=" + String.valueOf(profile);
		
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(url, jsonPayload);
		Cursor cur = objectMapper.readValue(jsonResponse.toString(), Cursor.class);
		return cur;	
	}
	
	/**
	 * Gets the events data.
	 *
	 * @param cursor the cursor
	 * @return the events data
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public GetEventsResponse getEventsData(String cursor) throws IOException, InterruptedException
	{
		String url = urlGetEventCursor + "?cursor=" + cursor;
		
		JSONObject jsonResponse = client.getRequest(url);
		GetEventsResponse res = objectMapper.readValue(jsonResponse.toString(), GetEventsResponse.class);
		return res;	
	}
	
	/**
	 * Gets the event count.
	 *
	 * @param payload the payload
	 * @return the event count
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response getEventCount(EventPayload payload) throws IOException, InterruptedException
	{
		JSONObject jsonPayload = new JSONObject(objectMapper.writeValueAsString(payload));
		JSONObject jsonResponse = client.postRequest(urlGetEventCount, jsonPayload);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		return res;
	}
	
	/**
	 * Gets the event count by req id.
	 *
	 * @param ReqId the req id
	 * @return the event count by req id
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public Response getEventCountByReqId(long ReqId) throws IOException, InterruptedException
	{
		String url = urlGetEventCountByReqId + String.valueOf(ReqId);
		JSONObject jsonResponse = client.getRequest(url);
		Response res = objectMapper.readValue(jsonResponse.toString(), Response.class);
		return res;
	}
}
