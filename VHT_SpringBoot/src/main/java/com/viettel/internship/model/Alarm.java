/*
* Copyright 2020 VHT, Viettel. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.viettel.internship.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * This method show you the description of Alarm.
 * The @Entity and @Table are represent to table named "alarm_current" in database
 * @author hoangcv
 * @version 1.2
 * @since 1.1
 */
@Entity
@Table(name = "alarm_current")
public class Alarm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "alarmid")
	@JsonProperty("keyrecog")
	@NotNull
	private int alarmid;
	
	@Column(name = "keygen")
	@JsonProperty("keygen")
	@NotNull
	private String keygen;
	
	@Column(name = "message")
	@JsonProperty("msg")
	private String message;
	
	@NotNull
	@CreationTimestamp
	private Date createTime;
	
	@NotNull
	private int repeatCount = 0;
	
	public Alarm() {
		createTime = new Date();
	}
	
	public Alarm(int alarmid, String keygen, String message) {
		this.alarmid = alarmid;
		this.keygen = keygen;
		this.message = message;
		createTime = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAlarmid() {
		return alarmid;
	}

	public void setAlarmid(int alarmid) {
		this.alarmid = alarmid;
	}

	public String getKeygen() {
		return keygen;
	}

	public void setKeygen(String keygen) {
		this.keygen = keygen;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreateTime() {
		createTime = new Date();
		return createTime;
	}
	
	public int getRepeatCount() {
		return repeatCount;
	}

	public void setRepeatCount(int repeatCount) {
		this.repeatCount = repeatCount;
	}
}
