package com.manager.calendar.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import com.manager.calendar.entity.MeetingDetails;
import com.manager.calendar.repository.ManagerRepository;

@Component
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	ManagerRepository managerRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public List<MeetingDetails> getSchedule() {

		List<MeetingDetails> allSchedule = getAllSchedule();

		List<MeetingDetails> result = new ArrayList<>();

		LocalDateTime today = LocalDateTime.now();
		for (MeetingDetails meetingDetails : allSchedule) {

			switch (meetingDetails.getFrequency()) {
			case "none":
				LocalDateTime meetingDate = meetingDetails.getMeetingDate();
				if (meetingDate.getDayOfMonth() == today.getDayOfMonth() && meetingDate.getMonth() == today.getMonth()
						&& meetingDate.getYear() == today.getYear()) {
					result.add(meetingDetails);
				}
				break;

			case "daily":
				result.add(meetingDetails);
				break;

			case "yearly":
				LocalDateTime yearDate = meetingDetails.getMeetingDate();
				if (yearDate.getDayOfMonth() == today.getDayOfMonth() && yearDate.getMonth() == today.getMonth()) {
					result.add(meetingDetails);
				}
				break;
			case "monthly":
				LocalDateTime monthDate = meetingDetails.getMeetingDate();
				if (monthDate.getDayOfMonth() == today.getDayOfMonth()) {
					result.add(meetingDetails);
				}
				break;
			case "weekly":
				LocalDateTime weekDate = meetingDetails.getMeetingDate();
				if (weekDate.getDayOfWeek() == today.getDayOfWeek()) {
					result.add(meetingDetails);
				}
				break;

			}

		}

		return result;
	}

	@Override
	public void addSchedule(MeetingDetails meetingDetails) {
		managerRepository.insert(meetingDetails);
	}

	@Override
	public void updateSchedule(MeetingDetails meetingDetails) {
		Query query = new Query(Criteria.where("id").is(meetingDetails.get_id()));

		Update update = new Update();
		update.set("title", meetingDetails.getTitle());
		update.set("startTime", meetingDetails.getStartTime());
		update.set("endTime", meetingDetails.getEndTime());

		mongoTemplate.updateFirst(query, update, MeetingDetails.class);

	}

	@Override
	public List<MeetingDetails> getAllSchedule() {
		return managerRepository.findAll();
	}

	@Override
	public void deleteSchedule(String id) {
		managerRepository.deleteById(id);
		
	}

}
