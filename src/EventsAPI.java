import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import helper.ClevertapInstance;
import helper.Cursor;
import helper.enums.Region;
import payload.event.EventPayload;
import response.GetEventsResponse;
import response.Response;

public class EventsAPI {
	public static void main(String[] args) throws IOException, InterruptedException {
    	
	   String Cid = "4R8-K98-8Z6Z";
	   String CPswd = "AOE-RUW-CHUL";
	   ClevertapInstance instance  = new ClevertapInstance(Cid, CPswd, Region.NONE);
	   
	   ObjectMapper jsonMapper = new ObjectMapper();
	   jsonMapper.setSerializationInclusion(Include.NON_NULL);
	   jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	   
	   //Upload events//
	   
//	   EventPayload uploadPayload = new EventPayload();
//	   uploadPayload.setIdentity("dharmendra.shesma@gmail.com");
//	   uploadPayload.setTs(1624008422);
//	   uploadPayload.setType("event");
//	   uploadPayload.setEventNameUpload("Product Bought");
//	   HashMap<String, Object> evtData = new HashMap<String, Object>();
//	   evtData.put("Product Name", "AC");
//	   evtData.put("Category", "Electronics");
//	   evtData.put("Price", 30000);
//	   
//	   uploadPayload.setEventData(evtData);
//	   List<EventPayload> uploadList = new ArrayList<EventPayload>();
//	   uploadList.add(uploadPayload);
//	   
//	   Response resUpload = instance.getEventInstance().uploadEvents(uploadList);
//	   JSONObject uploadEvtResponse= new JSONObject(jsonMapper.writeValueAsString(resUpload));
//	   System.out.println(uploadEvtResponse.toString(4));
	   
	   //Event count//
	   
//	   EventPayload countPayload = new EventPayload();
//	   countPayload.setEventNameDownload("Product Bought");
//	   
//	   EventPropertyFilter eventProps = new EventPropertyFilter();
//	   eventProps.setPropertName("Category");
//	   eventProps.setOperator("equals");
//	   eventProps.setPropertValue("Electronics");
//	   List<EventPropertyFilter> eventPropList = new ArrayList<EventPropertyFilter>();
//	   eventPropList.add(eventProps);
//	   
//	   countPayload.setEventProperties(eventPropList);
//	   
//	   countPayload.setFromDate(20210607);
//	   countPayload.setToDate(20210625);
//	   
//	   Response resCount = instance.getEventInstance().getEventCount(countPayload);	   
//	   JSONObject countEvtResponse= new JSONObject(jsonMapper.writeValueAsString(resCount));
//	   System.out.println(countEvtResponse.toString(4));
//	   
//	   if(resCount.getReqId()!=0)
//	   {
//		   Response resCountByReqId = instance.getEventInstance().getEventCountByReqId(resCount.getReqId());	   
//		   JSONObject countEvtReqIdResponse= new JSONObject(jsonMapper.writeValueAsString(resCountByReqId));
//		   System.out.println(countEvtReqIdResponse.toString(4));
//	   }
	   
	   // get events with cursor//
	   
//	   EventPayload payloadgetEventCur = new EventPayload();
//	   payloadgetEventCur.setEventNameDownload("Product Bought");
//	   payloadgetEventCur.setFromDate(20210606);
//	   payloadgetEventCur.setToDate(20210625);
//	   
//	   Cursor eventCursor = instance.getEventInstance().getEventsCursor(payloadgetEventCur, 1000, true, true, true);
//	   JSONObject eventCursorResponse= new JSONObject(jsonMapper.writeValueAsString(payloadgetEventCur));
//	   System.out.println(eventCursorResponse.toString(4));
//	   
//	   GetEventsResponse getEvents = instance.getEventInstance().getEventsData(eventCursor.getCursor());
//	   JSONObject getEventsResponseFirst= new JSONObject(jsonMapper.writeValueAsString(getEvents));
//	   System.out.println(getEventsResponseFirst.toString(4));
//	   
//	   String cur = getEvents.getNextCursor();
//	   while(cur != null) {
//		   JSONObject getEventsResponse= new JSONObject(jsonMapper.writeValueAsString(getEvents));
//		   System.out.println(getEventsResponse.toString(4));
//		   getEvents = instance.getEventInstance().getEventsData(cur);
//		   cur = getEvents.getNextCursor();
//	   }
	}
	
}
