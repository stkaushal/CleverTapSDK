package Payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonProfileProperties {
	@JsonProperty(value="profile_fields")
	List<ProfileFields> profileFields;

	public List<ProfileFields> getProfileFields() {
		return profileFields;
	}

	public void setProfileFields(List<ProfileFields> profileFields) {
		this.profileFields = profileFields;
	}
	
	
}
