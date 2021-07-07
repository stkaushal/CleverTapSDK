package payload.campaign.campaigncontent.platformtype;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


// TODO: Auto-generated Javadoc
/**
 * The Class PlatformTypeIos.
 */
@JsonInclude(Include.NON_DEFAULT)
public class PlatformTypeIos {

	/** The mutable content. */
	@JsonProperty(value="mutable-content")
	boolean mutableContent;
	
	/** The deep link. */
	@JsonProperty(value="deep_link")
	String deepLink;
	
	/** The sound file. */
	@JsonProperty(value="sound_file")
	String soundFile;
	
	/** The category. */
	String category;
	
	/** The badge count. */
	@JsonProperty(value="badge_count")
	int badgeCount;
	
	/** The background image URL. */
	@JsonProperty(value="background_image")
	String backgroundImageURL;
	
	/** The default sound. */
	@JsonProperty(value="default_sound")
	boolean defaultSound;
	
	/** The large icon URL. */
	@JsonProperty(value="large_icon")
	String largeIconURL;
	
	/** The time to live. */
	@JsonProperty(value="ttl")
	int timeToLive;

	/**
	 * Checks if is mutable content.
	 *
	 * @return true, if is mutable content
	 */
	public boolean isMutableContent() {
		return mutableContent;
	}

	/**
	 * Sets the mutable content.
	 *
	 * @param mutableContent the new mutable content
	 */
	public void setMutableContent(boolean mutableContent) {
		this.mutableContent = mutableContent;
	}

	/**
	 * Gets the deep link.
	 *
	 * @return the deep link
	 */
	public String getDeepLink() {
		return deepLink;
	}

	/**
	 * Sets the deep link.
	 *
	 * @param deepLink the new deep link
	 */
	public void setDeepLink(String deepLink) {
		this.deepLink = deepLink;
	}

	/**
	 * Gets the sound file.
	 *
	 * @return the sound file
	 */
	public String getSoundFile() {
		return soundFile;
	}

	/**
	 * Sets the sound file.
	 *
	 * @param soundFile the new sound file
	 */
	public void setSoundFile(String soundFile) {
		this.soundFile = soundFile;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Gets the badge count.
	 *
	 * @return the badge count
	 */
	public int getBadgeCount() {
		return badgeCount;
	}

	/**
	 * Sets the badge count.
	 *
	 * @param badgeCount the new badge count
	 */
	public void setBadgeCount(int badgeCount) {
		this.badgeCount = badgeCount;
	}

	/**
	 * Gets the background image URL.
	 *
	 * @return the background image URL
	 */
	public String getBackgroundImageURL() {
		return backgroundImageURL;
	}

	/**
	 * Sets the background image URL.
	 *
	 * @param backgroundImageURL the new background image URL
	 */
	public void setBackgroundImageURL(String backgroundImageURL) {
		this.backgroundImageURL = backgroundImageURL;
	}

	/**
	 * Checks if is default sound.
	 *
	 * @return true, if is default sound
	 */
	public boolean isDefaultSound() {
		return defaultSound;
	}

	/**
	 * Sets the default sound.
	 *
	 * @param defaultSound the new default sound
	 */
	public void setDefaultSound(boolean defaultSound) {
		this.defaultSound = defaultSound;
	}

	/**
	 * Gets the large icon URL.
	 *
	 * @return the large icon URL
	 */
	public String getLargeIconURL() {
		return largeIconURL;
	}

	/**
	 * Sets the large icon URL.
	 *
	 * @param largeIconURL the new large icon URL
	 */
	public void setLargeIconURL(String largeIconURL) {
		this.largeIconURL = largeIconURL;
	}

	/**
	 * Gets the time to live.
	 *
	 * @return the time to live
	 */
	public int getTimeToLive() {
		return timeToLive;
	}

	/**
	 * Sets the time to live.
	 *
	 * @param timeToLive the new time to live
	 */
	public void setTimeToLive(int timeToLive) {
		this.timeToLive = timeToLive;
	}
	
	
}
