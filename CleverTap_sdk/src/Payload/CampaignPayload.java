package Payload;

public class CampaignPayload {
	String name;
	String when;
	Content content;
	String provider_nick_name;
	String provider_group_nickname;
	Where where;
	boolean respect_frequency_caps;
	boolean estimate_only;
	boolean async_estimate;
	int ttl;
	String wzrk_cid;
	String wzrk_bc;
	String wzrk_bi;
	boolean system_control_group_include;
	ControlGroup control_group;
	String wzrk_acts;
	boolean respect_throttle;
	boolean skip_estimate;
	boolean send_to_all_devices;
	int segment;
	To to;
	String tag_group;
	int badge_id;
	String badge_icon;
	boolean mutable_content;
	int id;
	int from;
	int toDate;
	
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getToDate() {
		return toDate;
	}
	public void setToDate(int toDate) {
		this.toDate = toDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWhen() {
		return when;
	}
	public void setWhen(String when) {
		this.when = when;
	}
	public Content getContent() {
		return content;
	}
	public void setContent(Content content) {
		this.content = content;
	}
	public boolean isRespect_frequency_caps() {
		return respect_frequency_caps;
	}
	public void setRespect_frequency_caps(boolean respect_frequency_caps) {
		this.respect_frequency_caps = respect_frequency_caps;
	}
	public boolean isEstimate_only() {
		return estimate_only;
	}
	public void setEstimate_only(boolean estimate_only) {
		this.estimate_only = estimate_only;
	}
	public boolean isAsync_estimate() {
		return async_estimate;
	}
	public void setAsync_estimate(boolean async_estimate) {
		this.async_estimate = async_estimate;
	}
	public int getTtl() {
		return ttl;
	}
	public void setTtl(int ttl) {
		this.ttl = ttl;
	}
	public int getSegment() {
		return segment;
	}
	public void setSegment(int segment) {
		this.segment = segment;
	}
	public boolean isSend_to_all_devices() {
		return send_to_all_devices;
	}
	public void setSend_to_all_devices(boolean send_to_all_devices) {
		this.send_to_all_devices = send_to_all_devices;
	}
	public boolean isSkip_estimate() {
		return skip_estimate;
	}
	public void setSkip_estimate(boolean skip_estimate) {
		this.skip_estimate = skip_estimate;
	}
	public boolean isRespect_throttle() {
		return respect_throttle;
	}
	public void setRespect_throttle(boolean respect_throttle) {
		this.respect_throttle = respect_throttle;
	}
	public String getWzrk_cid() {
		return wzrk_cid;
	}
	public void setWzrk_cid(String wzrk_cid) {
		this.wzrk_cid = wzrk_cid;
	}
	public String getWzrk_bc() {
		return wzrk_bc;
	}
	public void setWzrk_bc(String wzrk_bc) {
		this.wzrk_bc = wzrk_bc;
	}
	public String getWzrk_bi() {
		return wzrk_bi;
	}
	public void setWzrk_bi(String wzrk_bi) {
		this.wzrk_bi = wzrk_bi;
	}
	public String getWzrk_acts() {
		return wzrk_acts;
	}
	public void setWzrk_acts(String wzrk_acts) {
		this.wzrk_acts = wzrk_acts;
	}
	public Where getWhere() {
		return where;
	}
	public void setWhere(Where where) {
		this.where = where;
	}
	public String getBadge_icon() {
		return badge_icon;
	}
	public void setBadge_icon(String badge_icon) {
		this.badge_icon = badge_icon;
	}
	public int getBadge_id() {
		return badge_id;
	}
	public void setBadge_id(int badge_id) {
		this.badge_id = badge_id;
	}
	public boolean isMutable_content() {
		return mutable_content;
	}
	public void setMutable_content(boolean mutable_content) {
		this.mutable_content = mutable_content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getProvider_nick_name() {
		return provider_nick_name;
	}
	public void setProvider_nick_name(String provider_nick_name) {
		this.provider_nick_name = provider_nick_name;
	}
	public String getProvider_group_nickname() {
		return provider_group_nickname;
	}
	public void setProvider_group_nickname(String provider_group_nickname) {
		this.provider_group_nickname = provider_group_nickname;
	}
	public boolean isSystem_control_group_include() {
		return system_control_group_include;
	}
	public void setSystem_control_group_include(boolean system_control_group_include) {
		this.system_control_group_include = system_control_group_include;
	}
	public ControlGroup getControl_group() {
		return control_group;
	}
	public void setControl_group(ControlGroup control_group) {
		this.control_group = control_group;
	}
	public To getTo() {
		return to;
	}
	public void setTo(To to) {
		this.to = to;
	}
	public String getTag_group() {
		return tag_group;
	}
	public void setTag_group(String tag_group) {
		this.tag_group = tag_group;
	}
	
}
