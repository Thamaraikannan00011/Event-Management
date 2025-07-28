package jsp.springproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import jsp.springproject.entity.Attendee;
import jsp.springproject.entity.Registeration;
import jsp.springproject.repository.AttendeeRepository;

@Repository
public class AttendeeDAO {
	@Autowired
	private AttendeeRepository repository;
	
	public Attendee registerAttende(Attendee attendee) {
		return repository.save(attendee);
	}
	
	public List<Attendee> getAllAttendee(){
		return repository.findAll();
	}
	
	public Optional<Attendee> getAttendeeById(int id) {
		return repository.findById(id);
	}
	
	public Attendee updateAttendee(Attendee attendee) {
		return repository.save(attendee);
	}
	
	public void deleteAttendee(int id) {
		repository.deleteById(id);
	}
	
	public List<Registeration> getRegistrationByAttendeeId(int id) {
		return repository.findRegistrationById(id);
	}
	
	public Attendee getAttendeeByContact(long phone) {
		return repository.findAttendeeByContact(phone);
	}
	
	public Page<Attendee> getAttendeeByPaginationAndSorting(Integer pageNumber, Integer pageSize, String field){
		return repository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(field).ascending()));
	}

}
