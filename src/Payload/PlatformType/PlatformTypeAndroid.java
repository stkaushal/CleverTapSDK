package Payload.PlatformType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class PlatformTypeAndroid {
	
	@JsonProperty(value="mutable-content")
	boolean mutableContent;
	
	@JsonProperty(value="deep_link")
	String deepLink;
	
	@JsonProperty(value="sound_file")
	String soundFile;
	
	String category;
	
	@JsonProperty(value="badge_count")
	int badgeCount;
	
	@JsonProperty(value="background_image")
	String backgroundImageURL;
	
	@JsonProperty(value="default_sound")
	boolean defaultSound;
	
	@JsonProperty(value="large_icon")
	String largeIconURL;
	
	@JsonProperty(value="ttl")
	int timeToLive;

	public boolean isMutableContent() {
		return mutableContent;
	}

	public void setMutableContent(boolean mutableContent) {
		this.mutableContent = mutableContent;
	}

	public String getDeepLink() {
		return deepLink;
	}

	public void setDeepLink(String deepLink) {
		this.deepLink = deepLink;
	}

	public String getSoundFile() {
		return soundFile;
	}

	public void setSoundFile(String soundFile) {
		this.soundFile = soundFile;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getBadgeCount() {
		return badgeCount;
	}

	public void setBadgeCount(int badgeCount) {
		this.badgeCount = badgeCount;
	}

	public String getBackgroundImageURL() {
		return backgroundImageURL;
	}

	public void setBackgroundImageURL(String backgroundImageURL) {
		this.backgroundImageURL = backgroundImageURL;
	}

	public boolean isDefaultSound() {
		return defaultSound;
	}

	public void setDefaultSound(boolean defaultSound) {
		this.defaultSound = defaultSound;
	}

	public String getLargeIconURL() {
		return largeIconURL;
	}

	public void setLargeIconURL(String largeIconURL) {
		this.largeIconURL = largeIconURL;
	}

	public int getTimeToLive() {
		return timeToLive;
	}

	public void setTimeToLive(int timeToLive) {
		this.timeToLive = timeToLive;
	}
	
	
}
