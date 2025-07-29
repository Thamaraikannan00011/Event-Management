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
import jsp.springproject.entity.Attendee;
import jsp.springproject.entity.Registeration;
import jsp.springproject.service.AttendeeService;

@RestController
@RequestMapping("/attendee")
public class AttendeeController {
	
	@Autowired
	private AttendeeService ser;

	@PostMapping
	public ResponseEntity<ResponseStructure<Attendee>> createAttendee(@RequestBody Attendee attendee){
		return ser.createAttendee(attendee);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Attendee>>> getAllAttendee(){
		return ser.getAllAttendee();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Attendee>> getAttendeeById(@PathVariable int id){
		return ser.getAttendeeById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Attendee>> updateAttendee(@RequestBody Attendee attendee){
		return ser.updateAttendee(attendee);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteAttendee(@PathVariable int id){
		return ser.deleteAttendee(id);
	}
	
	@GetMapping("/register/{id}")
	public ResponseEntity<ResponseStructure<List<Registeration>>> getRegistrationByAttendeeId(@PathVariable int id){
		return ser.getRegistrationByAttendeeId(id);
	}
	
	@GetMapping("/contact/{contact}")
	public ResponseEntity<ResponseStructure<Attendee>> getAttendeeByContact(@PathVariable long contact){
		return ser.getAttendeeByContact(contact);
	}
	
	@GetMapping("/page/{pageNumber}/{pageSize}/{field}")
	public ResponseEntity<ResponseStructure<Page<Attendee>>> getAttendeeByPaginationAndSorting(@PathVariable int pageNumber, @PathVariable int pageSize, @PathVariable String field){
		return ser.getAttendeeByPaginationAndSorting(pageNumber, pageSize, field);
	}
	
}
