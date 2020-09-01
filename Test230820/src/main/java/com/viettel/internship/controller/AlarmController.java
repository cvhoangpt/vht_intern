/*
* Copyright 2020 VHT, Viettel. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.viettel.internship.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.viettel.internship.model.Alarm;
import com.viettel.internship.repository.AlarmRepository;
import com.viettel.internship.service.AlarmService;
import com.viettel.internship.service.implement.AlarmServiceImplement;

/**
 * This class provides the REST Controller and includes some APIs
 * @author hoangcv
 * @version 1.1
 * @since 1.0
 */
@RestController
public class AlarmController   {
	
	private Logger logger = LoggerFactory.getLogger(AlarmController.class);
	
	//Alarm alarm;
	private AlarmService alarmService;
	
	@Autowired // This means to get the bean called alarmService
	public AlarmController(AlarmService alarmService) {
		this.alarmService = alarmService;
	}
	
	
	@RequestMapping(value = "/alarm", method = RequestMethod.GET)
	public ResponseEntity<List<Alarm>> findAllAlarm() {
		List<Alarm> alarm = alarmService.findAllAlarm();
        if (alarm.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(alarm, HttpStatus.OK);
	}
	
	//ResponseEntity<?>
	//return new ResponseEntity<>(RestModel, HttpStatus.OK);
	@RequestMapping(value = "/alarm", method = RequestMethod.POST)
	public ResponseEntity<?> createAlarm(@RequestBody Map<String, String> getJson, 
			HttpServletResponse response) 
			throws Exception {
		
		String type;
		int alarmid;
		String keygen;
		String message;
		String time;
		int repeatCount;
		
		type = getJson.get("type");
		alarmid = Integer.parseInt(getJson.get("keyrecog"));
		keygen = getJson.get("keygen");
		message = getJson.get("msg");
		
		
		if (type.equals("1")) {
			System.out.println("1");
			
			if (alarmService.checkExist(alarmid, keygen) == 1) {
				
				try {
					alarmService.updateEvent(message, alarmid, keygen);
					time = alarmService.printTime(alarmid, keygen);
					repeatCount = alarmService.printCount(alarmid, keygen);
					return ResponseEntity.status(HttpStatus.OK).
							body("Update message successful.\nTime stamp: " + time 
									+ "\nRepeat count: " + repeatCount);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			} else {
				//Construction complete!
				try {
					alarmService.saveEvent(alarmid, keygen, message);
					time = alarmService.printTime(alarmid, keygen);
					repeatCount = alarmService.printCount(alarmid, keygen);
					return ResponseEntity.status(HttpStatus.OK).body("New message is comming ...\nTime stamp: " + time
							+ "\nRepeat count: " + repeatCount);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} else if (type.equals("0")) {
			System.out.println("0");
			try {
				alarmService.deleteRow(alarmid, keygen);
				return ResponseEntity.status(HttpStatus.OK).body("Delete alarmid=" + alarmid + ", keygen=" + keygen + " successful.");
			} catch (NumberFormatException e) {
				e.printStackTrace();
				logger.error(e.getMessage());
			}	
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something wrong.");
		//System.out.println(payload);
		
		//System.out.println(payload.get("type"));
		//ResponseEntity<?>
		//return new ResponseEntity<>(RestModel, HttpStatus.OK);
	}
	
	/*
	@RequestMapping(value = "/alarm/{id}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Alarm> getAlarmById(
			@PathVariable("id") int id) {
		Optional<Alarm> alarm = alarmService.findById(id);
		
		if (!alarm.isPresent()) {
			return new ResponseEntity<>(alarm.get(),
					HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(alarm.get(), HttpStatus.OK);
	}
	*/
	
	/*
	@RequestMapping(
			value = "/alarm", 
			method = RequestMethod.POST)
	public ResponseEntity<Alarm> createAlarm(
			@RequestBody Map<Alarm, Alarm> alarm,
			UriComponentsBuilder builder) throws Exception {
		
			alarmService.save(alarm);
			System.out.println(alarm);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(builder.path("/products/{id}")
	                .buildAndExpand(((Alarm) alarm).getId()).toUri());
	        return new ResponseEntity<>(alarm, HttpStatus.CREATED)
	}
	*/
	
	/*
	@RequestMapping(value = "/alarm/{alarmid}/{keygen}", method = RequestMethod.POST)
	public 
	*/
	
	/*
	@RequestMapping(value = "/alarm/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Alarm> updateAlarm(
			@PathVariable("id") int id,
			@RequestBody Alarm alarm) {
		
		Optional<Alarm> currentAlarm = alarmService.findById(id);
		
		if (!currentAlarm.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		currentAlarm.get().setAlarmid(alarm.getAlarmid());
		currentAlarm.get().setKeygen(alarm.getKeygen());
		currentAlarm.get().setMessage(alarm.getMessage());
		currentAlarm.get().setCreateTime(alarm.getCreateTime());
		currentAlarm.get().setRepeatCount(alarm.getRepeatCount());
		
		//alarmService.save(currentAlarm.get());	
		return new ResponseEntity<> (currentAlarm.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/alarm/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Alarm> deleteAlarm(
            @PathVariable("id") Integer id) {
        Optional<Alarm> alarm = alarmService.findById(id);
        
        if (!alarm.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        alarmService.remove(alarm.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	*/
}
