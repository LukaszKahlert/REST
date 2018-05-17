package com.company.enroller.persistence;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.company.enroller.model.Meeting;

@Component("meetingService")
public class MeetingService {

	DatabaseConnector connector;

	public MeetingService() {
		connector = DatabaseConnector.getInstance();
	}

	public Collection<Meeting> getAll() {
//		String hql = "FROM Meeting";
//		Query query = connector.getSession().createQuery(hql);
//		return query.list();
		return connector.getSession().createCriteria(Meeting.class).list();
	}
	
	public Meeting findById(long l) {
		return (Meeting) connector.getSession().get(Meeting.class, l);

	}

	public void addMeeting(Meeting meeting) {
		Transaction transaction = connector.getSession().beginTransaction();
		connector.getSession().save(meeting);
		transaction.commit();
	}

}
