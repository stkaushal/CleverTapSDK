import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import Helper.ClevertapInstance;
import Helper.Cursor;
import Payload.EventPayload;
import Response.GetEventsResponse;
import Response.Response;

public class EventsAPI {
	public static void main(String[] args) throws IOException, InterruptedException {
    	
	   String Cid = "4R8-K98-8Z6Z";
	   String CPswd = "AOE-RUW-CHUL";
	   ClevertapInstance instance  = new ClevertapInstance(Cid, CPswd);
	   
	   ObjectMapper jsonMapper = new ObjectMapper();
	   jsonMapper.setSerializationInclusion(Include.NON_NULL);
	   jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	   
	   //Upload events//
	   
//	   EventPayload uploadPayload = new EventPayload();
//	   uploadPayload.setIdentity("rohan@gmail.com");
//	   uploadPayload.setTs(1623380602);
//	   uploadPayload.setType("event");
//	   uploadPayload.setEventNameUpload("charged");
//	   HashMap<String, Object> evtData = new HashMap<String, Object>();
//	   evtData.put("Amount", 100);
//	   evtData.put("Currency", "Cardano");
//	   evtData.put("Payment Method", "Uniswap");
//	   
//	   uploadPayload.setEventData(evtData);
//	   List<EventPayload> uploadList = new ArrayList<EventPayload>();
//	   uploadList.add(uploadPayload);
//	   
//	   Response resUpload = instance.getEventInstance().uploadEvents(uploadList);
//	   
//	   JSONObject uploadEvtResponse= new JSONObject(jsonMapper.writeValueAsString(resUpload));
//	   System.out.println(uploadEvtResponse.toString(4));
	   
	   //Event count//
	   
//	   EventPayload countPayload = new EventPayload();
//	   countPayload.setEventName("charged");
//	   List<HashMap<String, Object>> eventProperties = new ArrayList<HashMap<String, Object>>();
//	   HashMap<String, Object> map = new HashMap<String, Object>();
//	   map.put("Amount", 300);
//	   map.put("Currency", "Bitcoin");
//	   map.put("Payment Method", "Trust wallet transfer");	
//	   eventProperties.add(map);
//	   countPayload.setEventProperties(eventProperties );
//	   countPayload.setFromDate(20210607);
//	   countPayload.setToDate(20210609);
//	   
//	   Response resCount = instance.getEventInstance().getEventCount(countPayload);	   
//	   JSONObject countEvtResponse= new JSONObject(jsonMapper.writeValueAsString(countPayload));
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
//	   payloadgetEventCur.setEventNameDownload("charged");
//	   payloadgetEventCur.setFromDate(20210607);
//	   payloadgetEventCur.setToDate(20210611);
//	   
//	   Cursor eventCursor = instance.getEventInstance().getEventsCursor(payloadgetEventCur, 1);
//	   JSONObject eventCursorResponse= new JSONObject(jsonMapper.writeValueAsString(eventCursor));
//	   System.out.println(eventCursorResponse.toString(4));
//	   
//	   GetEventsResponse getEvents = instance.getEventInstance().getEventsData(eventCursor);
//	   JSONObject getEventsResponse= new JSONObject(jsonMapper.writeValueAsString(getEvents));
//	   System.out.println(getEventsResponse.toString(4));
	}
	
}
