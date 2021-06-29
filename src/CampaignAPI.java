import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import Helper.Enums.CampaignMethod;
import Helper.ClevertapInstance;
import Helper.Enums.Region;
import Payload.CampaignContent.*;
import Payload.CampaignPayload;
import Payload.Content;
import Payload.DateRangePayload;
import Payload.PlatformSpecificContent;
import Payload.PlatformType.*;
import Payload.To;
import Payload.Where;
import Response.Response;

public class CampaignAPI {
	public static void main(String[] args) throws IOException, InterruptedException {
    	
		String Cid = "W8W-897-865Z";
		String CPswd = "042043bfc0ec4fd5ac14291840ec6c1e";
		ClevertapInstance instance  = new ClevertapInstance(Cid, CPswd, Region.DEVELOPMENT);
	   
	   ObjectMapper jsonMapper = new ObjectMapper();
	   jsonMapper.setSerializationInclusion(Include.NON_NULL);
	   jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	   
	   
	   //create campaign by id//
	   
	   //1. Email by ID
	   
//	   CampaignPayload campaignPayload = new CampaignPayload();
//	   To sendMessageTo = new To();
//	   String[] emailId = {"dharmendra.shesma@gmail.com"};
//	   sendMessageTo.setEmail(emailId);
//	   campaignPayload.setSendMessageTo(sendMessageTo);
//	   campaignPayload.setTagGroup("Target group for Dharmender");
//	   campaignPayload.setRespectFrequencyCaps(false);
//	   Content content = new Content();
//	   content.setTitle("Hello");
//	   content.setBody("Plan limit not over!");
//	   content.setSubject("Open up the mail bro");
//	   content.setSenderName("God Father");
//	   campaignPayload.setContent(content);
//	   campaignPayload.setCampaignSendTime("20210617 12:06");
//	   
//	   Response resCreateCampaignTUE = instance.getCampaignInstance().createCampaignTargetId(CampaignMethod.EMAIL, campaignPayload);
//	   JSONObject createCampaignTUEResponse= new JSONObject(jsonMapper.writeValueAsString(resCreateCampaignTUE));
//	   System.out.println(createCampaignTUEResponse.toString(4));
	   
	   //2. MobilePush by ID
	   
//	   CampaignPayload campaignPayload = new CampaignPayload();
//	   To sendMessageTo = new To();
//	   List<String> email = new ArrayList<String>();
//	   email.add("dharmendra.shesma@gmail.com");
//	   sendMessageTo.setEmail(email);
//	   campaignPayload.setSendMessageTo(sendMessageTo);
//	   
//	   campaignPayload.setTagGroup("Target group for Mobile Push 1");
//	   campaignPayload.setRespectFrequencyCaps(false);
//	   Content content = new Content();
//	   content.setTitle("Yup its working!");
//	   content.setBody("Mobile push is created.");
//	   
//	   PlatformSpecificContent platformSpecific = new PlatformSpecificContent();
//	   
//	   PlatformTypeAndroid android = new PlatformTypeAndroid();
//	   android.setBackgroundImageURL("https://image.shutterstock.com/image-photo/beautiful-sky-after-sunset-on-260nw-1715214265.jpg");
//	   android.setDefaultSound(true);
//	   android.setLargeIconURL("https://image.flaticon.com/icons/png/128/4863/4863961.png");
//	   android.setTimeToLive(10);
//	   
//	   platformSpecific.setPlatformTypeAndroid(android);
//	   
//	   content.setPlatformSpecificContent(platformSpecific);
//	   
//	   campaignPayload.setContent(content);
//	   campaignPayload.setCampaignSendTime("20210624 08:00");
//	   
//	   Response resCreateCampaignTUE = instance.getCampaignInstance().createCampaignTargetId(CampaignMethod.MOBILEPUSH, campaignPayload);
//	   JSONObject createCampaignTUEResponse= new JSONObject(jsonMapper.writeValueAsString(resCreateCampaignTUE));
//	   System.out.println(createCampaignTUEResponse.toString(4));
	   
	   
	   //3. SMS by ID
	   
//	   CampaignPayload campaignPayload = new CampaignPayload();
//	   To sendMessageTo = new To();
//	   List<String> email = new ArrayList<String>();
//	   email.add("dharmendra.shesma@gmail.com");
//	   sendMessageTo.setEmail(email);
//	   campaignPayload.setSendMessageTo(sendMessageTo);
//	   
//	   campaignPayload.setTagGroup("Target group for SMS by ID");
//	   campaignPayload.setRespectFrequencyCaps(false);
//	   Content content = new Content();
//	   content.setBody("Message sent from clevertap to check sms api for id");
//	   
//	   campaignPayload.setContent(content);
//	   campaignPayload.setCampaignSendTime("20210619 19:03");
//	   
//	   Response resCreateCampaignTUE = instance.getCampaignInstance().createCampaignTargetId(CampaignMethod.SMS, campaignPayload);
//	   JSONObject createCampaignTUEResponse= new JSONObject(jsonMapper.writeValueAsString(resCreateCampaignTUE));
//	   System.out.println(createCampaignTUEResponse.toString(4));
	   
	   
	   
	   /////create campaign by user event////
	   
	   //1.App Inbox
	   
//	   CampaignPayload campaignPayloadUE = new CampaignPayload();
//	   campaignPayloadUE.setCampaignName("Added to cart test - message-icon");
//	   campaignPayloadUE.setCampaignSendTime("20210618 12:31");
//	   
//	   Content content = new Content();	
//	   List<Content> contentList = new ArrayList<Content>();
//	   
//	   CampaignContentTitle title = new CampaignContentTitle();
//	   title.setText("Notification message-icon from pc, final");
//	   content.setTitle(title);
//	   
//	   CampaignContentMessage message = new CampaignContentMessage();
//	   message.setText("Last check");
//	   content.setMessage(message);
//	   
//	   CampaignContentIcon icon  = new CampaignContentIcon();
//	   icon.setContentType("image/jpg");
//	   icon.setMediaUrl("https://image.flaticon.com/icons/png/128/4863/4863961.png");
//	   content.setIcon(icon);
//	   
//	   CampaignContentMedia media = new CampaignContentMedia();
//	   media.setContentType("image/jpg");
//	   media.setMediaUrl("https://image.shutterstock.com/image-photo/beautiful-sky-after-sunset-on-260nw-1715214265.jpg");
//	   content.setMedia(media);
//	   
//	   contentList.add(content);
//	   campaignPayloadUE.setContent(contentList);
//	   
//	   Where campaignSendTo = new Where();
//	   campaignSendTo.setEventName("Added To Cart");
//	   campaignSendTo.setFromDate(20210606);
//	   campaignSendTo.setToDate(20210618);
//	   campaignPayloadUE.setCampaignSendTo(campaignSendTo);
//	   
//	   campaignPayloadUE.setEstimateOnly(false);
//	   campaignPayloadUE.setTargetMode(CampaignMethod.APPINBOX);
//	   campaignPayloadUE.setRespectFrequencyCaps(false);
//	   campaignPayloadUE.setSendToAllDevices(true);
////	   campaignPayloadUE.setTemplateType("simple");
////	   campaignPayloadUE.setTemplateType("carousel");
////	   campaignPayloadUE.setTemplateType("carousel-image");
//	   campaignPayloadUE.setTemplateType("message-icon");
//	   campaignPayloadUE.setOrientation("p");
//	   
//	   List<String> devices = new  ArrayList<String>();
//	   devices.add("android");
//	   devices.add("ios");
//	   campaignPayloadUE.setDevices(devices);
//	   campaignPayloadUE.setTimeToLiveForAppInbox(50);
//	   
//	   Response resCreateCampaignTUE = instance.getCampaignInstance().createCampaignTargetUserEvents(campaignPayloadUE);
//	   JSONObject createCampaignTUEResponse= new JSONObject(jsonMapper.writeValueAsString(resCreateCampaignTUE));
//	   System.out.println(createCampaignTUEResponse.toString(4));
	   
	   //2.SMS
	   
//	   CampaignPayload campaignPayloadUE = new CampaignPayload();
//	   campaignPayloadUE.setCampaignName("SMS Campaign 1");
//	   campaignPayloadUE.setCampaignSendTime("now");
//	   
//	   Where campaignSendTo = new Where();
//	   campaignSendTo.setEventName("Purchase Made");
//	   campaignSendTo.setFromDate(20210606);
//	   campaignSendTo.setToDate(20210618);
//	   campaignPayloadUE.setCampaignSendTo(campaignSendTo);
//	   
//	   campaignPayloadUE.setEstimateOnly(false);
//	   campaignPayloadUE.setTargetMode(CampaignMethod.SMS);
//	   campaignPayloadUE.setRespectFrequencyCaps(false);
//	   
//	   Content content = new Content();
//	   content.setBody("SMS is also working!");
//	   campaignPayloadUE.setContent(content);
//	   
//	   Response resCreateCampaignTUE = instance.getCampaignInstance().createCampaignTargetUserEvents(campaignPayloadUE);
//	   JSONObject createCampaignTUEResponse= new JSONObject(jsonMapper.writeValueAsString(resCreateCampaignTUE));
//	   System.out.println(createCampaignTUEResponse.toString(4));
	   
	   
//	   //3.WebPush
//	   
//	   CampaignPayload campaignPayloadUE = new CampaignPayload();
//	   campaignPayloadUE.setCampaignName("WebPush Campaign 1");
//	   campaignPayloadUE.setCampaignSendTime("now");
//	   
//	   Where campaignSendTo = new Where();
//	   campaignSendTo.setEventName("Product viewed");
//	   campaignSendTo.setFromDate(20210606);
//	   campaignSendTo.setToDate(20210618);
//	   campaignPayloadUE.setCampaignSendTo(campaignSendTo);
//	   
//	   campaignPayloadUE.setEstimateOnly(false);
//	   campaignPayloadUE.setTargetMode(CampaignMethod.WEBPUSH);
//	   campaignPayloadUE.setRespectFrequencyCaps(false);
//	   
//	   Content content = new Content();
//	   content.setBody("Webpush is also working!");
//	   content.setTitle("Webpush!");
//	   HashMap<String, Object> platformSpecific = new HashMap<String, Object>();
//	   HashMap<String, Object> chrome = new HashMap<String, Object>();
//	   chrome.put("ttl", 50);
//	   chrome.put("require_interaction", true);
//	   chrome.put("cta_title1", "title");
//	   platformSpecific.put("chrome", chrome);
//	   
//	   HashMap<String, Object> firefox = new HashMap<String, Object>();
//	   firefox.put("ttl", 50);
//	   platformSpecific.put("firefox", firefox);
//	   content.setPlatformSpecific(platformSpecific);
//	   campaignPayloadUE.setContent(content);
//	   
//	   Response resCreateCampaignTUE = instance.getCampaignInstance().createCampaignTargetUserEvents(campaignPayloadUE);
//	   JSONObject createCampaignTUEResponse= new JSONObject(jsonMapper.writeValueAsString(resCreateCampaignTUE));
//	   System.out.println(createCampaignTUEResponse.toString(4));
	   
	   
      //4.MobilePush
	   
//	   CampaignPayload campaignPayloadUE = new CampaignPayload();
//	   campaignPayloadUE.setCampaignName("Mobile Push Campaign 2");
//	   campaignPayloadUE.setCampaignSendTime("now");
//	   
//	   Where campaignSendTo = new Where();
//	   campaignSendTo.setEventName("Added To Cart");
//	   campaignSendTo.setFromDate(20210606);
//	   campaignSendTo.setToDate(20210624);
//	   campaignPayloadUE.setCampaignSendTo(campaignSendTo);
//	   
//	   campaignPayloadUE.setEstimateOnly(false);
//	   campaignPayloadUE.setTargetMode(CampaignMethod.MOBILEPUSH);
//	   campaignPayloadUE.setRespectFrequencyCaps(false);
//	   
//	   Content content = new Content();
//	   content.setBody("Mobilepush is also working!");
//	   content.setTitle("Mobilepush!");
//	   PlatformSpecificContent platformSpecific = new PlatformSpecificContent();
//	   
//	   PlatformTypeAndroid android = new PlatformTypeAndroid();
//	   android.setBackgroundImageURL("https://image.shutterstock.com/image-photo/beautiful-sky-after-sunset-on-260nw-1715214265.jpg");
//	   android.setDefaultSound(true);
//	   android.setLargeIconURL("https://image.flaticon.com/icons/png/128/4863/4863961.png");
//	   android.setTimeToLive(10);
//	   
//	   platformSpecific.setPlatformTypeAndroid(android);
//	   
//	   content.setPlatformSpecificContent(platformSpecific);
//	   
//	   campaignPayloadUE.setContent(content);
//	   
//	   List<String> devices = new  ArrayList<String>();
//	   devices.add("android");
//	   campaignPayloadUE.setDevices(devices);
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
	   
//	   DateRangePayload campaignPayloadgetC = new DateRangePayload();
//	   campaignPayloadgetC.setFromDate(20210629);
//	   campaignPayloadgetC.setToDate(20210629);
//	   Response resCampaignPayloadgetC = instance.getCampaignInstance().getCampaigns(campaignPayloadgetC);
//	   JSONObject campaignPayloadgetCResponse = new JSONObject(jsonMapper.writeValueAsString(resCampaignPayloadgetC));
//	   System.out.println(campaignPayloadgetCResponse.toString(4));
	   
	   
	   //get campaign report//
	   
//	   CampaignPayload campaignPayloadgetReport = new CampaignPayload();
//	   campaignPayloadgetReport.setCampaignId(1000000020);
//	   Response resCampaignPayloadgetReport = instance.getCampaignInstance().getCampaignReport(campaignPayloadgetReport);
//	   JSONObject campaignPayloadgetReportResponse = new JSONObject(jsonMapper.writeValueAsString(resCampaignPayloadgetReport));
//	   System.out.println(campaignPayloadgetReportResponse.toString(4));
	}
}
