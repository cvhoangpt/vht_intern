/*
* Copyright 2020 VHT, Viettel. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.viettel.internship.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.viettel.internship.model.Alarm;

/**
 * This interface can make some services of Alarm requesting
 * @author hoangcv
 * @version 1.0
 * @since 1.0
 */
public interface AlarmService {
	List<Alarm> findAllAlarm();
	void deleteRow(int alarmid, String keygen);
	
	Optional<Alarm> findById(int id);
	
	void saveEvent(int alarmid, String keygen, String message);
	
	int checkExist(int alarmid, String keygen) throws SQLException;
	
	void updateEvent(String message, int alarmid, String keygen);
	
	void save(Alarm alarm);
	
	String printTime(int alarmid, String keygen);
	
	int printCount(int alarmid, String keygen);
	//void remove(Alarm alarm);
	/*
	List<Alarm> findByAlarmId(int alarmid);
	List<Alarm> findByKeygen(String keygen);
	*/
}
