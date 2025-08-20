package jsp.springproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.springproject.dto.ResponseStructure;
import jsp.springproject.entity.Event;
import jsp.springproject.service.EventService;

@RequestMapping("/event")
@RestController
public class EventController {
	@Autowired
	private EventService ser;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Event>> createEvent(@RequestBody Event event){
		return ser.createEvent(event);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Event>>> getAllEvent(){
		return ser.getAllEvent();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Event>> getEventById(@PathVariable int id){
		return ser.getEventById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Event>> updateEvent(@RequestBody Event event) {
		return ser.updateEvent(event);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteEvent(@PathVariable int id) {
		return ser.deleteEvent(id);
	}
	
	@GetMapping("/page/{PageNumber}/{PageSize}/{field}")
	public ResponseEntity<ResponseStructure<Page<Event>>> getEventPaginationAndSorting(@PathVariable int PageNumber, @PathVariable int PageSize, @PathVariable String field){
		return ser.getEventPaginationAndSorting(PageNumber, PageSize, field);
	}
}
