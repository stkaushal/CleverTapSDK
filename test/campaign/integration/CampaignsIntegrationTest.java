package campaign.integration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import campaign.Campaigns;
import helper.ClevertapInstance;
import helper.enums.CampaignMethod;
import helper.enums.Region;
import payload.campaign.CampaignPayload;
import payload.campaign.DateRangePayload;
import payload.campaign.To;
import payload.campaign.Where;
import payload.campaign.campaigncontent.Content;
import response.Response;

public class CampaignsIntegrationTest {

	String clevertapID = "4R8-K98-8Z6Z";
	String clevertapPassword = "AOE-RUW-CHUL";
	ClevertapInstance instance  = new ClevertapInstance(clevertapID, clevertapPassword, Region.DEFAULT);
	Campaigns campaignInstance = instance.getCampaignInstance();

	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("Before campaign integration test call");
	}

	@Test
	public void testCreateCampaignTargetUserEvents() throws IOException, InterruptedException {
		CampaignPayload campaignPayloadUE = new CampaignPayload();
		campaignPayloadUE.setCampaignName("SMS Campaign Integration testing");
		campaignPayloadUE.setCampaignSendTime("now");

		Where campaignSendTo = new Where();
		campaignSendTo.setEventName("Product Sold");
		campaignSendTo.setFromDate(20210606);
		campaignSendTo.setToDate(20210625);
		campaignPayloadUE.setCampaignSendTo(campaignSendTo);

		campaignPayloadUE.setEstimateOnly(false);
		campaignPayloadUE.setTargetMode(CampaignMethod.SMS);
		campaignPayloadUE.setRespectFrequencyCaps(false);

		Content content = new Content();
		content.setBody("Integration test API call success");
		campaignPayloadUE.setContent(content);

		Response resCreateCampaignTUE = campaignInstance.createCampaignTargetUserEvents(campaignPayloadUE);

		Assertions.assertNotNull(resCreateCampaignTUE);
		Assertions.assertEquals("success", resCreateCampaignTUE.getStatus());
	}

	@Test
	public void testCreateCampaignTargetId() throws IOException, InterruptedException {
		CampaignPayload campaignPayload = new CampaignPayload();
		To sendMessageTo = new To();
		List<String> emailId = new ArrayList<String>();
		emailId.add("dharmender.sheshma@clevertap.com");
		sendMessageTo.setEmail(emailId);
		campaignPayload.setSendMessageTo(sendMessageTo);
		campaignPayload.setTagGroup("Target group for Integration testing");
		campaignPayload.setRespectFrequencyCaps(false);
		Content content = new Content();
		content.setTitle("Hello");
		content.setBody("Integration test success");
		content.setSubject("Email API call under integration tets");
		content.setSenderName("Tester");
		campaignPayload.setContent(content);
		campaignPayload.setCampaignSendTime("now");

		Response resCreateCampaignTID = campaignInstance.createCampaignTargetId(CampaignMethod.EMAIL, campaignPayload);

		Assertions.assertNotNull(resCreateCampaignTID);
		Assertions.assertEquals("success", resCreateCampaignTID.getStatus());
	}

	@Test
	public void testStopScheduledCampaign() throws IOException, InterruptedException {
		CampaignPayload campaignPayloadStopC = new CampaignPayload();
		campaignPayloadStopC.setCampaignId(1624588490);
		Response resCampaignPayloadStopC = campaignInstance.stopScheduledCampaign(campaignPayloadStopC);

		Assertions.assertNotNull(resCampaignPayloadStopC);
		Assertions.assertEquals("success", resCampaignPayloadStopC.getStatus());
	}

	@Test
	public void testGetCampaignReport() throws IOException, InterruptedException {
		CampaignPayload campaignPayloadgetReport = new CampaignPayload();
		campaignPayloadgetReport.setCampaignId(1624588490);
		Response resCampaignPayloadgetReport = campaignInstance.getCampaignReport(campaignPayloadgetReport);

		Assertions.assertNotNull(resCampaignPayloadgetReport);
		Assertions.assertEquals("success", resCampaignPayloadgetReport.getStatus());
	}

	@Test
	public void testGetCampaigns() throws IOException, InterruptedException {
		DateRangePayload campaignPayloadgetC = new DateRangePayload();
		campaignPayloadgetC.setFromDate(20210606);
		campaignPayloadgetC.setToDate(20210625);
		Response resCampaignPayloadgetC = campaignInstance.getCampaigns(campaignPayloadgetC);

		Assertions.assertNotNull(resCampaignPayloadgetC);
		Assertions.assertEquals("success", resCampaignPayloadgetC.getStatus());
	}

}
