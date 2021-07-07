package helper;

import campaign.Campaigns;
import event.Event;
import helper.enums.Region;
import profile.Profiles;
import report.Report;

// TODO: Auto-generated Javadoc
/**
 * The Class ClevertapInstance.
 */
public class ClevertapInstance {
	
	/** The id. */
	private static String id;
	
	/** The password. */
	private static String password;
	
	/** The region. */
	private static Region region;
	
	/** The profile instance. */
	private Profiles profileInstance;
	
	/** The event instance. */
	private Event eventInstance;
	
	/** The report instance. */
	private Report reportInstance;
	
	/** The campaign instance. */
	private Campaigns campaignInstance;

	/**
	 * Instantiates a new clevertap instance.
	 *
	 * @param id the id
	 * @param password the password
	 * @param region the region
	 */
	public ClevertapInstance(String id, String password, Region region)
	{
		ClevertapInstance.id = id;
		ClevertapInstance.password = password;
		ClevertapInstance.region = region;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public static String getId() {
		return id;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public static String getPassword() {
		return password;
	}
	
	/**
	 * Gets the region.
	 *
	 * @return the region
	 */
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
		else if(ClevertapInstance.region==Region.DEVELOPMENT){
			return "sk1.";
		}
		return "";
	}
	
	/**
	 * Gets the profile instance.
	 *
	 * @return the profile instance
	 */
	public Profiles getProfileInstance() {
		this.profileInstance = new Profiles();
		return profileInstance;
	}
	
	/**
	 * Gets the event instance.
	 *
	 * @return the event instance
	 */
	public Event getEventInstance() {
		this.eventInstance = new Event();
		return eventInstance;
	}

	/**
	 * Gets the report instance.
	 *
	 * @return the report instance
	 */
	public Report getReportInstance() {
		this.reportInstance = new Report();
		return reportInstance;
	}
	
	/**
	 * Gets the campaign instance.
	 *
	 * @return the campaign instance
	 */
	public Campaigns getCampaignInstance() {
		this.campaignInstance = new Campaigns();
		return campaignInstance;
	}
}
