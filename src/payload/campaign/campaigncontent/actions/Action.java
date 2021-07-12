package payload.campaign.campaigncontent.actions;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class Action.
 */
@JsonInclude(Include.NON_DEFAULT)
public class Action {
	
	/** The action url. */
	@JsonProperty(value="url")
	private ActionUrl actionUrl;
	
	/** The actionlinks. */
	@JsonProperty(value="links")
	private List<ActionLinks> actionlinks;

	/**
	 * Gets the action url.
	 *
	 * @return the action url
	 */
	public ActionUrl getActionUrl() {
		return actionUrl;
	}

	/**
	 * Sets the action url.
	 *
	 * @param actionUrl the new action url
	 */
	public void setActionUrl(ActionUrl actionUrl) {
		this.actionUrl = actionUrl;
	}

	/**
	 * Gets the actionlinks.
	 *
	 * @return the actionlinks
	 */
	public List<ActionLinks> getActionlinks() {
		return actionlinks;
	}

	/**
	 * Sets the actionlinks.
	 *
	 * @param actionlinks the new actionlinks
	 */
	public void setActionlinks(List<ActionLinks> actionlinks) {
		this.actionlinks = actionlinks;
	}
	
	
}
