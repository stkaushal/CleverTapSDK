package Helper;

import Campaign.Campaigns;
import Event.Event;
import Profile.Profiles;
import Report.Report;

public class ClevertapInstance {
	private static String id;
	private static String password;
	private Profiles profileInstance;
	private Event eventInstance;
	private Report reportInstance;
	private Campaigns campaignInstance;

	public ClevertapInstance(String id, String password)
	{
		ClevertapInstance.id = id;
		ClevertapInstance.password = password;
	}
	
	public static String getId() {
		return id;
	}
	
	public static String getPassword() {
		return password;
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
