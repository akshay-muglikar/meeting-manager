package com.manager.calendar.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.manager.calendar.entity.MeetingDetails;

public interface ManagerRepository extends MongoRepository<MeetingDetails, String> {

}
