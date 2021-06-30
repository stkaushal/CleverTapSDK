package Payload.Campaign.CampaignContent.Actions;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class Action {
	
	@JsonProperty(value="url")
	ActionUrl actionUrl;
	
	@JsonProperty(value="links")
	List<ActionLinks> actionlinks;

	public ActionUrl getActionUrl() {
		return actionUrl;
	}

	public void setActionUrl(ActionUrl actionUrl) {
		this.actionUrl = actionUrl;
	}

	public List<ActionLinks> getActionlinks() {
		return actionlinks;
	}

	public void setActionlinks(List<ActionLinks> actionlinks) {
		this.actionlinks = actionlinks;
	}
	
	
}
