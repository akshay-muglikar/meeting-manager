package com.manager.calendar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.manager.calendar.entity.MeetingDetails;
import com.manager.calendar.service.ManagerService;

@Controller
@RestController
public class HomeController {

	
	@Autowired
	ManagerService managerService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "getSchedule")
	@ResponseBody
	public List<MeetingDetails> getSchedule() {
		return managerService.getSchedule();
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "getAllSchedule")
	@ResponseBody
	public List<MeetingDetails> getSAllchedule() {
		return managerService.getAllSchedule();
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value ="addSchedule")
	@ResponseBody
	public void addSchedule(@RequestBody MeetingDetails meetingDetails) {
		managerService.addSchedule(meetingDetails);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="updateSchedule")
	@ResponseBody
	public void updateSchedule(@RequestBody MeetingDetails meetingDetails) {
		managerService.updateSchedule(meetingDetails);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="delete/{id}")
	@ResponseBody
	public void deleteSchedule(@PathVariable String id) {
		managerService.deleteSchedule(id);
	}
	
	
}
