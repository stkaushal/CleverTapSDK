import java.io.IOException;
import java.util.HashMap;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import Helper.ClevertapInstance;
import Helper.Enums.Region;
import Payload.Group;
import Payload.ReportPayload;
import Response.Response;

public class ReportAPI {
	public static void main(String[] args) throws IOException, InterruptedException {
    	
		String Cid = "W8W-897-865Z";
		String CPswd = "042043bfc0ec4fd5ac14291840ec6c1e";
		ClevertapInstance instance  = new ClevertapInstance(Cid, CPswd, Region.DEVELOPMENT);
	   
	   ObjectMapper jsonMapper = new ObjectMapper();
	   jsonMapper.setSerializationInclusion(Include.NON_NULL);
	   jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	   
	   
	   //Realtime count//
	   
//	   ReportPayload realtimeCount = new ReportPayload();
//	   realtimeCount.setUserType(true);
//	   Response resUploadProfile = instance.getReportInstance().getRealTimeCounts(realtimeCount);
//	   JSONObject uploadProfileResponse= new JSONObject(jsonMapper.writeValueAsString(resUploadProfile));
//	   System.out.println(uploadProfileResponse.toString(4));
	   
	   
	   
	   //Message Report// status code 500
	   
//	   ReportPayload messageReport = new ReportPayload();
//	   messageReport.setFromDate(20210629);
//	   messageReport.setToDate(20210629);
//	   
//	   Response resMessageReport = instance.getReportInstance().getMessageReports(messageReport);
//	   
//	   JSONObject messageReportResponse= new JSONObject(jsonMapper.writeValueAsString(resMessageReport));
//	   System.out.println(messageReportResponse.toString(4));
	   
	   
	   // Top property count//
	   
//	   ReportPayload topPropCount = new ReportPayload();
//	   topPropCount.setFromDate(20210606);
//	   topPropCount.setToDate(20210609);
//	   topPropCount.setEventName("charged");
//	   
//	   HashMap<String, Group> groups = new HashMap<String, Group>();
//	   Group group = new Group();
//	   group.setPropertyType("event_properties");
//	   group.setPropertyName("Amount");
//	   groups.put("eventGroup", group);
//	   topPropCount.setGroups(groups);
//	   
//	   Response restopPropCount = instance.getReportInstance().getTopPropertyCount(topPropCount);
//	   JSONObject topPropCountResponse= new JSONObject(jsonMapper.writeValueAsString(restopPropCount));
//	   System.out.println(topPropCountResponse.toString(4));
//	   
//	   if(restopPropCount.getReqId()!=0)
//	   {
//		   Response restopPropCountReqId = instance.getReportInstance().getTopPropertyCountByReqId(restopPropCount.getReqId());
//		   JSONObject topPropCountReqIdResponse= new JSONObject(jsonMapper.writeValueAsString(restopPropCountReqId));
//		   System.out.println(topPropCountReqIdResponse.toString(4));
//	   }
	   
	   //Trends//
	   
//	   ReportPayload trends = new ReportPayload();
//	   trends.setFromDate(20210606);
//	   trends.setToDate(20210609);
//	   trends.setEventName("charged");
//	   trends.setUnique(false);
//	   trends.setSumEventProp("Amount");
//	   
//	   HashMap<String, Group> groups = new HashMap<String, Group>();
//	   Group group = new Group();
//	   group.setTrendType("daily");
//	   groups.put("TrendGroup", group);
//	   trends.setGroups(groups);
//	   
//	   Response resTrends = instance.getReportInstance().getTrends(trends);
//	   JSONObject trendsResponse= new JSONObject(jsonMapper.writeValueAsString(resTrends));
//	   System.out.println(trendsResponse.toString(4));
//	   
//	   if(resTrends.getReqId()!=0)
//	   {
//		   Response resTrendsReqId = instance.getReportInstance().getTrendsByReqId(resTrends.getReqId());
//		   JSONObject trendsReqIdResponse= new JSONObject(jsonMapper.writeValueAsString(resTrendsReqId));
//		   System.out.println(trendsReqIdResponse.toString(4));
//	   }
//	   
	   
	}
}
