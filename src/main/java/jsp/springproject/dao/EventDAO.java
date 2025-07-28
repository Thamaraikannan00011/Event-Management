package jsp.springproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
}
