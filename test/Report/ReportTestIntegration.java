package Report;

import java.io.IOException;
import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Helper.ClevertapInstance;
import Helper.Region;
import Payload.Group;
import Payload.ReportPayload;
import Response.Response;

public class ReportTestIntegration {

	String Cid = "4R8-K98-8Z6Z";
	String CPswd = "AOE-RUW-CHUL";
	ClevertapInstance instance = new ClevertapInstance(Cid, CPswd, Region.NONE);
	Report reportInstance = instance.getReportInstance();

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before report integration test call");
	}

	@Test
	void testGetRealTimeCounts() throws IOException, InterruptedException {
		ReportPayload realtimeCount = new ReportPayload();
		realtimeCount.setUserType(true);
		Response resRealTimeCount = reportInstance.getRealTimeCounts(realtimeCount);

		Assertions.assertNotNull(resRealTimeCount);
		Assertions.assertEquals("success", resRealTimeCount.getStatus());
	}

	@Test
	void testGetMessageReports() throws IOException, InterruptedException {
		ReportPayload messageReport = new ReportPayload();
		messageReport.setFromDate(20210624);
		messageReport.setToDate(20210625);

		Response resMessageReport = reportInstance.getMessageReports(messageReport);

		Assertions.assertNotNull(resMessageReport);
	}

	@Test
	void testGetTopPropertyCount() throws IOException, InterruptedException {
		ReportPayload topPropCount = new ReportPayload();
		topPropCount.setFromDate(20210606);
		topPropCount.setToDate(20210609);
		topPropCount.setEventName("Product Sold");

		HashMap<String, Group> groups = new HashMap<String, Group>();
		Group group = new Group();
		group.setPropertyType("event_properties");
		group.setPropertyName("Amount");
		groups.put("eventGroup", group);
		topPropCount.setGroups(groups);

		Response restopPropCount = reportInstance.getTopPropertyCount(topPropCount);

		Assertions.assertNotNull(restopPropCount);

		if(restopPropCount.getStatus().equals("partial"))
		{
			Response restopPropCountReqId = reportInstance.getTopPropertyCountByReqId(restopPropCount.getReqId());

			Assertions.assertNotNull(restopPropCountReqId);
			Assertions.assertEquals("success", restopPropCountReqId.getStatus());
		}
	}

	@Test
	void testGetTrends() throws IOException, InterruptedException {
		ReportPayload trends = new ReportPayload();
		trends.setFromDate(20210606);
		trends.setToDate(20210625);
		trends.setEventName("Product Sold");
		trends.setUnique(false);

		HashMap<String, Group> groups = new HashMap<String, Group>();
		Group group = new Group();
		group.setTrendType("daily");
		groups.put("TrendGroup", group);
		trends.setGroups(groups);

		Response resTrends = reportInstance.getTrends(trends);

		Assertions.assertNotNull(resTrends);

		if(resTrends.getStatus().equals("partial"))
		{
			Response resTrendsReqId = reportInstance.getTrendsByReqId(resTrends.getReqId());

			Assertions.assertNotNull(resTrendsReqId);
			Assertions.assertEquals("success", resTrendsReqId.getStatus());
		}
	}

}
