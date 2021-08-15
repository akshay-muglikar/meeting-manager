package com.manager.calendar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.manager.calendar.entity.MeetingDetails;

@Service
public interface ManagerService {

	public List<MeetingDetails> getSchedule();

	public void addSchedule(MeetingDetails meetingDetails);

	public void updateSchedule(MeetingDetails meetingDetails);

	public List<MeetingDetails> getAllSchedule();

	public void deleteSchedule(String id);

}
