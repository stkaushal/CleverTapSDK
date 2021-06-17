import java.io.IOException;
import java.util.HashMap;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import Helper.CampaignMethod;
import Helper.ClevertapInstance;
import Helper.Region;
import Payload.CampaignPayload;
import Payload.Content;
import Payload.DateRangePayload;
import Payload.To;
import Payload.Where;
import Response.Response;

public class CampaignAPI {
	public static void main(String[] args) throws IOException, InterruptedException {
    	
	   String Cid = "4R8-K98-8Z6Z";
	   String CPswd = "AOE-RUW-CHUL";
	   ClevertapInstance instance  = new ClevertapInstance(Cid, CPswd, Region.NONE);
	   
	   ObjectMapper jsonMapper = new ObjectMapper();
	   jsonMapper.setSerializationInclusion(Include.NON_NULL);
	   jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	   
	   
	   //create campaign by id//
	   
//	   CampaignPayload campaignPayload = new CampaignPayload();
//	   To sendMessageTo = new To();
//	   String[] emailId = {"dharmendra.shesma@gmail.com"};
//	   sendMessageTo.setEmail(emailId);
//	   campaignPayload.setSendMessageTo(sendMessageTo);
//	   campaignPayload.setTagGroup("Target group for Dharmender");
//	   campaignPayload.setRespectFrequencyCaps(false);
//	   Content content = new Content();
//	   content.setTitle("Hello");
//	   content.setBody("You have made a purchase so you will be awarded!");
//	   content.setSubject("Your reward is here");
//	   content.setSenderName("Riya");
//	   campaignPayload.setContent(content);
//	   campaignPayload.setCampaignSendTime("20210615 12:41");
//	   
//	   Response resCreateCampaignTUE = instance.getCampaignInstance().createCampaignTargetId(CampaignMethod.EMAIL, campaignPayload);
//	   JSONObject createCampaignTUEResponse= new JSONObject(jsonMapper.writeValueAsString(resCreateCampaignTUE));
//	   System.out.println(createCampaignTUEResponse.toString(4));
//	   
	   //create campaign by user event//
	   
	   CampaignPayload campaignPayloadUE = new CampaignPayload();
	   campaignPayloadUE.setCampaignName("Campaign to target user events");
	   campaignPayloadUE.setCampaignSendTime("now");
	   
	   Content content = new Content();	
	   content.setTitle("Hello there");
	   content.setBody("See I told you this will work :)");
	   content.setSubject("Yayyyy! Campaign working.");
	   content.setSenderName("God Father");
	   campaignPayloadUE.setContent(content);
	   
	   Where campaignSendTo = new Where();
	   campaignSendTo.setEventName("Purchase Made");
	   campaignSendTo.setFromDate(20210606);
	   campaignSendTo.setToDate(20210616);
	   campaignPayloadUE.setCampaignSendTo(campaignSendTo);
	   
	   campaignPayloadUE.setEstimateOnly(false);
	   campaignPayloadUE.setTargetMode(CampaignMethod.EMAIL);
	   campaignPayloadUE.setRespectFrequencyCaps(false);
	   
	   Response resCreateCampaignTUE = instance.getCampaignInstance().createCampaignTargetUserEvents(campaignPayloadUE);
	   JSONObject createCampaignTUEResponse= new JSONObject(jsonMapper.writeValueAsString(resCreateCampaignTUE));
	   System.out.println(createCampaignTUEResponse.toString(4));
	   
	   // stop scheduled//
	   
//	   CampaignPayload campaignPayloadStopC = new CampaignPayload();
//	   campaignPayloadStopC.setCampaignId(100001561);
//	   Response resCampaignPayloadStopC = instance.getCampaignInstance().stopScheduledCampaign(campaignPayloadStopC);
//	   JSONObject campaignPayloadStopCResponse= new JSONObject(jsonMapper.writeValueAsString(resCampaignPayloadStopC));
//	   System.out.println(campaignPayloadStopCResponse.toString(4));
	   
	   
	   //get campaigns//
	   
//	   TimeInterval campaignPayloadgetC = new TimeInterval();
//	   campaignPayloadgetC.setFromDate(20210606);
//	   campaignPayloadgetC.setToDate(20210616);
//	   Response resCampaignPayloadgetC = instance.getCampaignInstance().getCampaigns(campaignPayloadgetC);
//	   JSONObject campaignPayloadgetCResponse = new JSONObject(jsonMapper.writeValueAsString(resCampaignPayloadgetC));
//	   System.out.println(campaignPayloadgetCResponse.toString(4));
	   
	   
	   //get campaign report//
	   
//	   CampaignPayload campaignPayloadgetReport = new CampaignPayload();
//	   campaignPayloadgetReport.setCampaignId(1623808337);
//	   Response resCampaignPayloadgetReport = instance.getCampaignInstance().getCampaignReport(campaignPayloadgetReport);
//	   JSONObject campaignPayloadgetReportResponse = new JSONObject(jsonMapper.writeValueAsString(resCampaignPayloadgetReport));
//	   System.out.println(campaignPayloadgetReportResponse.toString(4));
	}
}
