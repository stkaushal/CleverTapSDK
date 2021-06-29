package Event.Integration;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Event.Event;
import Helper.ClevertapInstance;
import Helper.Cursor;
import Helper.Enums.Region;
import Payload.EventPayload;
import Payload.EventPropertyFilter;
import Response.GetEventsResponse;
import Response.Response;

public class EventTestIntegration {
	String Cid = "4R8-K98-8Z6Z";
	String CPswd = "AOE-RUW-CHUL";
	ClevertapInstance instance = new ClevertapInstance(Cid, CPswd, Region.NONE);
	Event eventInstance = instance.getEventInstance();

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before event integration test call");
	}


	@Test
	void testUploadEvents() throws IOException, InterruptedException {
		EventPayload uploadPayload = new EventPayload();
		uploadPayload.setIdentity("dharmender.sheshma@clevertap.com");
		uploadPayload.setTs(Instant.now().getEpochSecond());
		uploadPayload.setType("event");
		uploadPayload.setEventNameUpload("Product Sold");
		HashMap<String, Object> evtData = new HashMap<String, Object>();
		evtData.put("Product Name", "Printer");
		evtData.put("Category", "Electronics");
		evtData.put("Price", 3000);

		uploadPayload.setEventData(evtData);
		List<EventPayload> uploadList = new ArrayList<EventPayload>();
		uploadList.add(uploadPayload);

		Response resUpload = eventInstance.uploadEvents(uploadList);

		Assertions.assertNotNull(resUpload);
		Assertions.assertEquals("success", resUpload.getStatus());
	}

	@Test
	void testGetEventsCursor() throws IOException, InterruptedException {
		EventPayload payloadgetEventCur = new EventPayload();
		payloadgetEventCur.setEventNameDownload("Product Sold");
		payloadgetEventCur.setFromDate(20210624);
		payloadgetEventCur.setToDate(20210625);

		Cursor eventCursor = eventInstance.getEventsCursor(payloadgetEventCur, 1000, true, true, true);

		Assertions.assertNotNull(eventCursor);
		Assertions.assertEquals("success", eventCursor.getStatus());
		Assertions.assertNotNull(eventCursor.getCursor());

	}

	@Test
	void testGetEventsData() throws IOException, InterruptedException {
		EventPayload payloadgetEventCur = new EventPayload();
		payloadgetEventCur.setEventNameDownload("Product Sold");
		payloadgetEventCur.setFromDate(20210624);
		payloadgetEventCur.setToDate(20210625);

		Cursor eventCursor = eventInstance.getEventsCursor(payloadgetEventCur, 1000, true, true, true);

		GetEventsResponse getEvents = eventInstance.getEventsData(eventCursor.getCursor());

		Assertions.assertNotNull(getEvents);
		Assertions.assertEquals("success", getEvents.getStatus());

	}

	@Test
	void testGetEventCount() throws IOException, InterruptedException {
		EventPayload countPayload = new EventPayload();
		countPayload.setEventNameDownload("Product Sold");
		
		EventPropertyFilter eventProps = new EventPropertyFilter();
		eventProps.setPropertName("Category");
		eventProps.setOperator("equals");
		eventProps.setPropertValue("Electronics");
		List<EventPropertyFilter> eventPropList = new ArrayList<EventPropertyFilter>();
		eventPropList.add(eventProps);

		countPayload.setEventProperties(eventPropList);
		countPayload.setFromDate(20210624);
		countPayload.setToDate(20210625);

		Response resCount = eventInstance.getEventCount(countPayload);	   

		Assertions.assertNotNull(resCount);

		if (resCount.getStatus().equals("partial"))
		{
			Response responseFinal = eventInstance.getEventCountByReqId(resCount.getReqId());	 

			Assertions.assertNotNull(responseFinal);
			Assertions.assertNotNull(responseFinal.getCount());
			Assertions.assertEquals("success", responseFinal.getStatus());

		}
	}

}
