package com.uniphore.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "interact_data")
public class ReportEntity {
	
	@Id
//	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "instance_id", nullable = false)
	 private String instance_id;
	
	  @Column(name = "s_no", nullable = true)
	    private int s_no;
	  
	  @Column(name = "mobile_number", nullable = false)
	    private String mobile_number;
	  
	  @Column(name = "call_id", nullable = false)
	    private String call_id;
	  
	  @Column(name = "disconnect_bot", nullable = true)
	    private String disconnect_bot;
	  
	  @Column(name = "agent_transferlevel", nullable = false)
	    private String agent_transferlevel;
	  
	  @Column(name = "last_intent", nullable = true)
	    private String last_intent;
	  
	  @Column(name = "complaintregisteredin_bot", nullable = true)
	    private String complaintregisteredin_bot;
	  
	  @Column(name = "bses_or_rajdhani", nullable = true)
	    private String bses_or_rajdhani;
	  
	  @Column(name = "bses_call_status", nullable = true)
	    private String bses_call_status;
	  
	  @Column(name = "call_date", nullable = true)
	    private Date call_date;
	  
	  @Column(name = "complaint_id", nullable = true)
	    private String complaint_id;

	public String getInstance_id() {
		return instance_id;
	}

	public void setInstance_id(String instance_id) {
		this.instance_id = instance_id;
	}

	public int getS_no() {
		return s_no;
	}

	public void setS_no(int s_no) {
		this.s_no = s_no;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getCall_id() {
		return call_id;
	}

	public void setCall_id(String call_id) {
		this.call_id = call_id;
	}

	public String getDisconnect_bot() {
		return disconnect_bot;
	}

	public void setDisconnect_bot(String disconnect_bot) {
		this.disconnect_bot = disconnect_bot;
	}

	public String getAgent_transferlevel() {
		return agent_transferlevel;
	}

	public void setAgent_transferlevel(String agent_transferlevel) {
		this.agent_transferlevel = agent_transferlevel;
	}

	public String getLast_intent() {
		return last_intent;
	}

	public void setLast_intent(String last_intent) {
		this.last_intent = last_intent;
	}

	public String getComplaintregisteredin_bot() {
		return complaintregisteredin_bot;
	}

	public void setComplaintregisteredin_bot(String complaintregisteredin_bot) {
		this.complaintregisteredin_bot = complaintregisteredin_bot;
	}

	public String getBses_or_rajdhani() {
		return bses_or_rajdhani;
	}

	public void setBses_or_rajdhani(String bses_or_rajdhani) {
		this.bses_or_rajdhani = bses_or_rajdhani;
	}

	public String getBses_call_status() {
		return bses_call_status;
	}

	public void setBses_call_status(String bses_call_status) {
		this.bses_call_status = bses_call_status;
	}

	public Date getCall_date() {
		return call_date;
	}

	public void setCall_date(Date call_date) {
		this.call_date = call_date;
	}

	public String getComplaint_id() {
		return complaint_id;
	}

	public void setComplaint_id(String complaint_id) {
		this.complaint_id = complaint_id;
	}
	  

}
