package helper;

import campaign.Campaigns;
import event.Event;
import helper.enums.Region;
import profile.Profiles;
import report.Report;

// TODO: Auto-generated Javadoc
/**
 * The ClevertapInstanceClass.
 */
final public class ClevertapInstance {
	
	/** The Clevertap account id. */
	private static String id;
	
	/** The Clevertap account password. */
	private static String password;
	
	/** The region for API endpoints. */
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
	 * @param id the Clevertap account id
	 * @param password the Clevertap account password
	 * @param region the region for API endpoints
	 */
	public ClevertapInstance(String id, String password, Region region)   // dont make its static
	{
		ClevertapInstance.id = id;
		ClevertapInstance.password = password;
		ClevertapInstance.region = region;
	}
	
	/**
	 * Gets the Clevertap account id.
	 *
	 * @return the id
	 */
	public static String getId() {
		return id;
	}
	
	/**
	 * Gets the Clevertap account password.
	 *
	 * @return the password
	 */
	public static String getPassword() {
		return password;
	}
	
	/**
	 * Gets the API endpoint region.
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
		this.profileInstance = Profiles.getProfilesInstance();
		return profileInstance;
	}
	
	/**
	 * Gets the event instance.
	 *
	 * @return the event instance
	 */
	public Event getEventInstance() {
		this.eventInstance = Event.getEventsInstance();
		return eventInstance;
	}

	/**
	 * Gets the report instance.
	 *
	 * @return the report instance
	 */
	public Report getReportInstance() {
		this.reportInstance = Report.getReportsInstance();
		return reportInstance;
	}
	
	/**
	 * Gets the campaign instance.
	 *
	 * @return the campaign instance
	 */
	public Campaigns getCampaignInstance() {
		this.campaignInstance = Campaigns.getCampaignsInstance();
		return campaignInstance;
	}
}
