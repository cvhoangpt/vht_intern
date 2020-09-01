/*
* Copyright 2020 VHT, Viettel. All rights reserved.
* VIETTEL PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
*/

package com.viettel.internship.repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.viettel.internship.model.Alarm;

/**
 * This interface can generate automation query or manual query to process database
 * @author hoangcv
 * @version 1.0
 * @since 1.0
 */
@Repository
public interface AlarmRepository extends JpaRepository<Alarm, Integer> {
	
	/*
	@Query(value = "select alarmid, keygen from alarm", nativeQuery = true)
	List<Alarm> findByAlarmId();
	*/
	/*
	@Transactional
	@Query(value = "insert into alarm_current ")
	*/
	@Modifying
	@Transactional
	@Query(value = "insert into alarm_current (alarmid, keygen, message, repeat_count) values (:alarmid, :keygen, :message, 0)", nativeQuery = true)
	void saveEvent(@Param("alarmid") int alarmid, @Param("keygen") String keygen, @Param("message") String message);
	
	@Modifying
	@Transactional
	@Query(value = "update alarm_current set message = :message, repeat_count = repeat_count + 1 where alarmid = :alarmid and keygen = :keygen", nativeQuery = true)
	void updateEvent(@Param("message") String message, @Param("alarmid") int alarmid, @Param("keygen") String keygen);
	
	@Modifying
	@Transactional
	@Query(value = "delete from alarm_current where alarmid = :alarmid and keygen = :keygen", nativeQuery = true)
	void deleteRow(@Param("alarmid") int alarmid, @Param("keygen") String keygen);
	
	@Transactional
	@Query(value = "select count(*) from alarm_current where alarmid = :alarmid and keygen = :keygen", nativeQuery = true)
	int checkExist(@Param("alarmid") int alarmid, @Param("keygen") String keygen);
	
	@Transactional
	@Query(value = "select create_time from alarm_current where alarmid = :alarmid and keygen = :keygen", nativeQuery = true)
	String printTime(@Param("alarmid") int alarmid, @Param("keygen") String keygen);
	
	@Transactional
	@Query(value = "select repeat_count from alarm_current where alarmid = :alarmid and keygen = :keygen", nativeQuery = true)
	int printCount(@Param("alarmid") int alarmid, @Param("keygen") String keygen);
}
