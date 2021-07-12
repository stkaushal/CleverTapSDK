package payload.campaign.campaigncontent.actions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class ActionLinks.
 */
@JsonInclude(Include.NON_DEFAULT)
public class ActionLinks {
	
	/** The type. */
	private String type;
	
	/** The text. */
	private String text;
	
	/** The color. */
	private String color;
	
	/** The bg. */
	private String bg;
	
	/** The action url. */
	@JsonProperty(value="url")
	private ActionUrl actionUrl;

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Sets the color.
	 *
	 * @param color the new color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Gets the bg.
	 *
	 * @return the bg
	 */
	public String getBg() {
		return bg;
	}

	/**
	 * Sets the bg.
	 *
	 * @param bg the new bg
	 */
	public void setBg(String bg) {
		this.bg = bg;
	}

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
	
	
}
