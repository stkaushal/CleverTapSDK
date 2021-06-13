import java.io.IOException;
import java.util.HashMap;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import Helper.ClevertapInstance;
import Payload.CampaignPayload;
import Payload.Content;
import Payload.TimeInterval;
import Payload.To;
import Payload.Where;
import Response.Response;

public class CampaignAPI {
	public static void main(String[] args) throws IOException, InterruptedException {
    	
	   String Cid = "4R8-K98-8Z6Z";
	   String CPswd = "AOE-RUW-CHUL";
	   ClevertapInstance instance  = new ClevertapInstance(Cid, CPswd);
	   
	   ObjectMapper jsonMapper = new ObjectMapper();
	   jsonMapper.setSerializationInclusion(Include.NON_NULL);
	   jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	   
	   
	   //create campaign by id//
	   
	   CampaignPayload campaignPayload = new CampaignPayload();
	   To sendMessageTo = new To();
	   String[] emailId = {"david@gmail.com"};
	   sendMessageTo.setEmail(emailId);
	   campaignPayload.setSendMessageTo(sendMessageTo);
	   campaignPayload.setTagGroup("Target group for David");
	   campaignPayload.setCampaignId(1000000044);
	   campaignPayload.setRespectFrequencyCaps(false);
	   Content content = new Content();
	   content.setTitle("Hello");
	   content.setBody("How's going?");
	   content.setSubject("For testing purpose");
	   content.setSenderName("Dharmender");
	   campaignPayload.setContent(content);
	   campaignPayload.setCampaignSendTime("20210615 03:20");
	   
	   Response resCreateCampaignTUE = instance.getCampaignInstance().createCampaignTargetId("EMAIL", campaignPayload);
	   JSONObject createCampaignTUEResponse= new JSONObject(jsonMapper.writeValueAsString(resCreateCampaignTUE));
	   System.out.println(createCampaignTUEResponse.toString(4));
//	   
	   //create campaign by user event//
	   
//	   CampaignPayload campaignPayloadUE = new CampaignPayload();
//	   campaignPayloadUE.setCampaignName("David's Webpush API campaign");
//	   campaignPayloadUE.setEstimateOnly(true);
//	   campaignPayloadUE.setTargetMode("webpush");
//	   campaignPayloadUE.setRespectFrequencyCaps(false);
//	   
//	   Content content = new Content();
//	   content.setTitle("Hello there");
//	   content.setBody("How's going brother?");
//	   content.setSubject("This is for testing purpose");
//	   content.setSenderName("Dharmender Sheshma");
//	   HashMap<String, Object> platformSpecific = new  HashMap<String, Object>();
//	   HashMap<String, Object> data = new HashMap<String, Object>();
//	   data.put("icon", "https://neilpatel.com/wp-content/uploads/2017/09/image-editing-tools.jpg");
//	   data.put("ttl", 10);
//	   platformSpecific.put("firefox", data);
//	   content.setPlatformSpecific(platformSpecific);
//	   campaignPayloadUE.setContent(content);
//	   campaignPayloadUE.setCampaignSendTime("now");
//	   
//	   Where campaignSendTo = new Where();
//	   campaignSendTo.setEventName("charged");
//	   campaignSendTo.setFromDate(20210606);
//	   campaignSendTo.setToDate(20210609);
//	   campaignPayloadUE.setCampaignSendTo(campaignSendTo);
//	   
//	   Response resCreateCampaignTUE = instance.getCampaignInstance().createCampaignTargetUserEvents(campaignPayloadUE);
//	   JSONObject createCampaignTUEResponse= new JSONObject(jsonMapper.writeValueAsString(resCreateCampaignTUE));
//	   System.out.println(createCampaignTUEResponse.toString(4));
	   
	   // stop scheduled//
	   
//	   CampaignPayload campaignPayloadStopC = new CampaignPayload();
//	   campaignPayloadStopC.setCampaignId(100001561);
//	   Response resCampaignPayloadStopC = instance.getCampaignInstance().stopScheduledCampaign(campaignPayloadStopC);
//	   JSONObject campaignPayloadStopCResponse= new JSONObject(jsonMapper.writeValueAsString(resCampaignPayloadStopC));
//	   System.out.println(campaignPayloadStopCResponse.toString(4));
	   
	   
	   //get campaigns//
	   
//	   TimeInterval campaignPayloadgetC = new TimeInterval();
//	   campaignPayloadgetC.setFromDate(20210606);
//	   campaignPayloadgetC.setToDate(20210609);
//	   Response resCampaignPayloadgetC = instance.getCampaignInstance().getCampaigns(campaignPayloadgetC);
//	   JSONObject campaignPayloadgetCResponse = new JSONObject(jsonMapper.writeValueAsString(resCampaignPayloadgetC));
//	   System.out.println(campaignPayloadgetCResponse.toString(4));
	   
	   
	   //get campaign report//
	   
//	   CampaignPayload campaignPayloadgetReport = new CampaignPayload();
//	   campaignPayloadgetReport.setCampaignId(100001561);
//	   Response resCampaignPayloadgetReport = instance.getCampaignInstance().getCampaignReport(campaignPayloadgetReport);
//	   JSONObject campaignPayloadgetReportResponse = new JSONObject(jsonMapper.writeValueAsString(resCampaignPayloadgetReport));
//	   System.out.println(campaignPayloadgetReportResponse.toString(4));
	}
}
