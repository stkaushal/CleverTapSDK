package payload.campaign;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class CommonProfileProperties.
 */
public class CommonProfileProperties {
	
	/** The profile fields. */
	@JsonProperty(value="profile_fields")
	private List<ProfileFields> profileFields;

	/**
	 * Gets the profile fields.
	 *
	 * @return the profile fields
	 */
	public List<ProfileFields> getProfileFields() {
		return profileFields;
	}

	/**
	 * Sets the profile fields.
	 *
	 * @param profileFields the new profile fields
	 */
	public void setProfileFields(List<ProfileFields> profileFields) {
		this.profileFields = profileFields;
	}
	
	
}
