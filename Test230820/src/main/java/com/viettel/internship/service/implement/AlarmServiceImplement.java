/*
* Copyright 2020 VHT, Viettel. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.viettel.internship.service.implement;

import com.viettel.internship.model.Alarm;
import com.viettel.internship.repository.AlarmRepository;
import com.viettel.internship.service.AlarmService;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlarmServiceImplement implements AlarmService {
	private AlarmRepository alarmRepository;
	
	private Logger logger = LoggerFactory.getLogger(AlarmServiceImplement.class);

	@Autowired
	public AlarmServiceImplement(AlarmRepository alarmRepository) {
		this.alarmRepository = alarmRepository;
	}

	@Override
	public List<Alarm> findAllAlarm() {
		return (List<Alarm>) alarmRepository.findAll();
	}

	@Override
	public Optional<Alarm> findById(int id) {
		return alarmRepository.findById(id);
	}

	//@Override
	public void save(Alarm alarm) {
		try {
			alarmRepository.save(alarm);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}	
	}

	/*
	@Override
	public void remove(Alarm alarm) {
		try {
			alarmRepository.delete(alarm);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}		
	}
	*/
	/*
	@Override
	public List<Alarm> findByAlarmId(int alarmid) {
		List<Alarm> alarm = null;
		try {
			alarm = alarmRepository.findByAlarmId(alarmid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alarm;
	}

	
	@Override
	public List<Alarm> findByKeygen(String keygen) {
		List<Alarm> alarm = null;
		try {
			alarm = alarmRepository.findByKeygen(keygen);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	*/

	@Override
	public void deleteRow(int alarmid, String keygen) {
		try {
			alarmRepository.deleteRow(alarmid, keygen);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}

	@Override
	public int checkExist(int alarmid, String keygen) throws SQLException {
		return alarmRepository.checkExist(alarmid, keygen);
	}

	@Override
	public void updateEvent(String message, int alarmid, String keygen) {
		try {
			alarmRepository.updateEvent(message, alarmid, keygen);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
	}

	@Override
	public void saveEvent(int alarmid, String keygen, String message) {
		
		Alarm alarm = new Alarm(alarmid, keygen, message);
		
		try {
			alarmRepository.saveEvent(alarmid, keygen, message);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		
	}

	@Override
	public String printTime(int alarmid, String keygen) {
		return alarmRepository.printTime(alarmid, keygen);		
	}

	@Override
	public int printCount(int alarmid, String keygen) {
		return alarmRepository.printCount(alarmid, keygen);
	}

	
}
