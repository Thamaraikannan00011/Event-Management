package jsp.springproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import jsp.springproject.entity.Attendee;
import jsp.springproject.entity.Event;
import jsp.springproject.repository.EventRepository;

@Repository
public class EventDAO {
	@Autowired
	private EventRepository repository;
	
	public Event createEvent(Event event) {
		return repository.save(event);
	}
	
	public List<Event> getAllEvent(){
		return repository.findAll();
	}
	
	public Optional<Event> getEventById(int id){
		return repository.findById(id);
	}
	
	public Event updateEvent(Event event) {
		return repository.save(event);
	}
	
	public void deleteEvent(int id) {
		repository.deleteById(id);
	}
	
	public List<Attendee> getAttendeeByEvenetId(int id){
		return repository.getAttendeeByEvenetId(id);
	}
	
	public  List<Event> getEventByOrganizerId(Integer id){
		return repository.getEventByOrganizerId(id);
	}
	
	public Page<Event> getEventPaginationAndSorting(int PageNumber, int PageSize, String field){
        return repository.findAll(PageRequest.of(PageNumber, PageSize, Sort.by(field).ascending()));	
	}
}
