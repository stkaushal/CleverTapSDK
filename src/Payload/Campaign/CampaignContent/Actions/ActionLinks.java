package Payload.Campaign.CampaignContent.Actions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class ActionLinks {
	String type;
	String text;
	String color;
	String bg;
	
	@JsonProperty(value="url")
	ActionUrl actionUrl;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBg() {
		return bg;
	}

	public void setBg(String bg) {
		this.bg = bg;
	}

	public ActionUrl getActionUrl() {
		return actionUrl;
	}

	public void setActionUrl(ActionUrl actionUrl) {
		this.actionUrl = actionUrl;
	}
	
	
}
