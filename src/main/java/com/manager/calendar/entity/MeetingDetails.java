package com.manager.calendar.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "meetingCollection")
public class MeetingDetails {

	@Id
	private String _id;

	private String title;
	private String startTime;
	private String endTime;

	private String frequency;

	private LocalDateTime meetingDate;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public LocalDateTime getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(LocalDateTime meetingDate) {
		this.meetingDate = meetingDate;
	}

}
