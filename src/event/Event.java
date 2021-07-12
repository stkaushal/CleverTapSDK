package event;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import helper.ClevertapInstance;
import helper.ObjectMapperHelper;
import http.HttpClient;
import payload.Cursor;
import payload.event.EventPayload;
import response.GetEventsResponse;
import response.Response;

// TODO: Auto-generated Javadoc
/**
 * The singleton Event Class.
 */
final public class Event {
	
	/** The API endpoint to upload events. */
	private static final String urlUploadEvent = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/upload";
	
	/** The API endpoint to get events counts. */
	private static final String urlGetEventCount = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/counts/events.json";
	
	/** The API endpoint to get events. */
	private static final String urlGetEventCursor = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/events.json";
	
	/** The API endpoint to get events counts using request id. */
	private static final String urlGetEventCountByReqId = "https://" + ClevertapInstance.getRegion() + "api.clevertap.com/1/counts/events.json?req_id=";
	
	/** The object mapper. */
	private ObjectMapper objectMapper;
	
	/** The client. */
	private HttpClient client;
	
	/**
	 * Instantiates a new event.
	 */
	private Event(){
		this.client = HttpClient.getHttpClientInstance();
		this.objectMapper = ObjectMapperHelper.ObjectMapperHelperInstance().getObjectMapper();
	}
	
	/** The event. */
	private static Event event = null;
	
	/**
	 * Gets the events instance.
	 *
	 * @return the events instance
	 */
	public static Event getEventsInstance() {
		 if(event==null)
		 {
			 event = new Event();
		 }
	      return event;
	 }
	
	/**
	 * Upload events.
	 *
	 * @param payload the events payload
	 * @return Response - the response
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
	 * Gets the cursor to fetch the events.
	 *
	 * @param payload the events payload
	 * @param batch_size The number of results to return in each API call
	 * @param app the boolean flag to receive app fields in the response
	 * @param events the boolean flag to receive event summary fields in the response
	 * @param profile the boolean flag to receive the custom profile properties in the response.
	 * @return Cursor - the events cursor
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
	 * Gets the events data using cursor.
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
	 * Retrieves counts for an event in a specified duration.
	 *
	 * @param payload the event payload
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
	 * Retrieves counts for an event in a specified duration using request id.
	 *
	 * @param ReqId the request id
	 * @return the event count 
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
