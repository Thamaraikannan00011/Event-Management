package jsp.springproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.springproject.dao.AttendeeDAO;
import jsp.springproject.dto.ResponseStructure;
import jsp.springproject.entity.Attendee;
import jsp.springproject.entity.Registeration;
import jsp.springproject.exception.*;

@Service
public class AttendeeService {
	
	@Autowired
	private AttendeeDAO dao;
	
	public ResponseEntity<ResponseStructure<Attendee>> createAttendee(Attendee attendee){
		if(attendee != null) {
			Attendee a = dao.registerAttende(attendee);
			ResponseStructure<Attendee> res = new ResponseStructure<Attendee>();
			res.setStatus(HttpStatus.CREATED.value());
			res.setMessage("Created Attendee Account");
			res.setData(a);
			return new ResponseEntity<ResponseStructure<Attendee>>(res, HttpStatus.CREATED);
		}
		else {
			throw new NoObjectPassedException("Missing Argument.");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Attendee>>> getAllAttendee(){
		List<Attendee> li = dao.getAllAttendee();
		if(!li.isEmpty()) {
			ResponseStructure<List<Attendee>> res = new ResponseStructure<List<Attendee>>();
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Fetched all attendee");
			res.setData(li);
			return new ResponseEntity<ResponseStructure<List<Attendee>>>(res, HttpStatus.OK);
		}
		else {
			throw new ListIsEmptyException("No record found.");
		}
	}
	
	public ResponseEntity<ResponseStructure<Attendee>> getAttendeeById(int id){
		Optional<Attendee> opt = dao.getAttendeeById(id);
		if(opt.isPresent()) {
			ResponseStructure<Attendee> res = new ResponseStructure<Attendee>();
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Fetched by Attendee id");
			res.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Attendee>>(res, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("No, id found in database.");
		}
	}
	
	public ResponseEntity<ResponseStructure<Attendee>> updateAttendee(Attendee attendee){
		Optional<Attendee> opt = dao.updateValidation(attendee.getEmail());
		if(opt.isPresent()) {
			dao.updateAttendee(attendee);
			ResponseStructure<Attendee> res = new ResponseStructure<Attendee>();
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Updated attendee record");
			res.setData(attendee);
			return new ResponseEntity<ResponseStructure<Attendee>>(res, HttpStatus.OK);
		}
		else {
			throw new UpdateNotValid("No record match to update");
		}
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteAttendee(int id){
		Optional<Attendee> opt = dao.getAttendeeById(id);
		if(opt.isPresent()) {
			dao.deleteAttendee(id);
			ResponseStructure<String> res = new ResponseStructure<String>();
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Record deleted successfully");
			res.setData("success");
			return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("Delete cannot be performed");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Registeration>>> getRegistrationByAttendeeId(int id){
		List<Registeration> li = dao.getRegistrationByAttendeeId(id);
		if(!li.isEmpty()) {
			ResponseStructure<List<Registeration>> res = new ResponseStructure<List<Registeration>>();
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Fetched registeration by Attendee id");
			res.setData(li);
			return new ResponseEntity<ResponseStructure<List<Registeration>>>(res, HttpStatus.OK);
		}
		else {
			throw new ListIsEmptyException("No record found in database");
		}
	}
	
	public ResponseEntity<ResponseStructure<Attendee>> getAttendeeByContact(long contact){
		Attendee a = dao.getAttendeeByContact(contact);
		if(a != null) {
			ResponseStructure<Attendee> res = new ResponseStructure<Attendee>();
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Fetched attendee by contact");
			res.setData(a);
			return new ResponseEntity<ResponseStructure<Attendee>>(res, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("No record found with the given contact");
		}
	}
	
	public ResponseEntity<ResponseStructure<Page<Attendee>>> getAttendeeByPaginationAndSorting(int pageNumber, int pageSize, String field){
		Page<Attendee> p = dao.getAttendeeByPaginationAndSorting(pageNumber, pageSize, field);
		if(!p.isEmpty()) {
			ResponseStructure<Page<Attendee>> res = new ResponseStructure<Page<Attendee>>();
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Record seperated according to page request");
			res.setData(p);
			return new ResponseEntity<ResponseStructure<Page<Attendee>>>(res, HttpStatus.OK);
		}
		else {
			throw new ListIsEmptyException("No page available");
		}
	}

}
