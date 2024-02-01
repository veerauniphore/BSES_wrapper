package com.uniphore.dto;


public class AgentTransferDto {

	private String instance_id;
	
	private String mobile_number;
	
	private String reason;
	
	private String cal_id;
	
	private String call_date_time;
	
	private String cisco_agent_transfer;
	
	

	public String getCisco_agent_transfer() {
		return cisco_agent_transfer;
	}

	public void setCisco_agent_transfer(String cisco_agent_transfer) {
		this.cisco_agent_transfer = cisco_agent_transfer;
	}

	public String getInstance_id() {
		return instance_id;
	}

	public void setInstance_id(String instance_id) {
		this.instance_id = instance_id;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getCal_id() {
		return cal_id;
	}

	public void setCal_id(String cal_id) {
		this.cal_id = cal_id;
	}

	public String getCall_date_time() {
		return call_date_time;
	}

	public void setCall_date_time(String call_date_time) {
		this.call_date_time = call_date_time;
	}
	
	
	
}
