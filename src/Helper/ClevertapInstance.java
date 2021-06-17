package Helper;

import Campaign.Campaigns;
import Event.Event;
import Profile.Profiles;
import Report.Report;

public class ClevertapInstance {
	
	private static String id;
	private static String password;
	private static Region region;
	
	private Profiles profileInstance;
	private Event eventInstance;
	private Report reportInstance;
	private Campaigns campaignInstance;

	public ClevertapInstance(String id, String password, Region region)
	{
		ClevertapInstance.id = id;
		ClevertapInstance.password = password;
		ClevertapInstance.region = region;
	}
	
	public static String getId() {
		return id;
	}
	
	public static String getPassword() {
		return password;
	}
	
	public static String getRegion() {
		if(ClevertapInstance.region==Region.INDIA){
			return "in1.";
		} 
		else if(ClevertapInstance.region==Region.SINGAPORE){
			return "sg1.";
		}
		else if(ClevertapInstance.region==Region.USA){
			return "us1.";
		}
		return "";
	}
	
	public Profiles getProfileInstance() {
		this.profileInstance = new Profiles();
		return profileInstance;
	}
	
	public Event getEventInstance() {
		this.eventInstance = new Event();
		return eventInstance;
	}

	public Report getReportInstance() {
		this.reportInstance = new Report();
		return reportInstance;
	}
	
	public Campaigns getCampaignInstance() {
		this.campaignInstance = new Campaigns();
		return campaignInstance;
	}
}
