package jsp.springproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.springproject.dao.EventDAO;
import jsp.springproject.dto.ResponseStructure;
import jsp.springproject.entity.Event;
import jsp.springproject.exception.IdNotFoundException;
import jsp.springproject.exception.ListIsEmptyException;

@Service
public class EventService {
	
	@Autowired
	private EventDAO dao;
	
	public ResponseEntity<ResponseStructure<Event>> createEvent(Event event){
        ResponseStructure<Event> structure=new ResponseStructure<Event>();
        structure.setStatus(HttpStatus.CREATED.value());
        structure.setMessage("Addded event");
        structure.setData(dao.createEvent(event));
        return new ResponseEntity<ResponseStructure<Event>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Event>>> getAllEvent(){
        ResponseStructure<List<Event>> structure=new ResponseStructure<List<Event>>();
        List<Event> li = dao.getAllEvent();
        if(!li.isEmpty()) {
        	structure.setStatus(HttpStatus.OK.value());
        	structure.setMessage("fetched");
        	structure.setData(li);
        	return new ResponseEntity<ResponseStructure<List<Event>>>(structure, HttpStatus.OK);
        }
        else {
        	throw new ListIsEmptyException("No record found in database");
        }
	}
	
	public ResponseEntity<ResponseStructure<Event>> getEventById(int id){
		ResponseStructure<Event> res = new ResponseStructure<Event>();
		Optional<Event> opt = dao.getEventById(id);
		if(opt.isPresent()) {
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("record fetched");
			res.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Event>>(res, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("No record found by given id");
		}
	}

	public ResponseEntity<ResponseStructure<Event>> updateEvent(Event event) {
		ResponseStructure<Event> res = new ResponseStructure<Event>();
		Optional<Event> opt = dao.getEventById(event.getId());
		if(opt.isPresent()) {
			res.setStatus(HttpStatus.CREATED.value());
			res.setMessage("record updated");
			res.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Event>>(res, HttpStatus.CREATED);
		}
		else {
			throw new IdNotFoundException("No record matches to update");
		}
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteEvent(int id) {
		ResponseStructure<String> res = new ResponseStructure<String>();
		if(dao.getEventById(id).isPresent()) {
			dao.deleteEvent(id);
			res.setStatus(HttpStatus.ACCEPTED.value());
			res.setMessage("record deleted");
			res.setData("success");
			return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.ACCEPTED);
		}
		else {
			throw new IdNotFoundException("No record found to delete");
		}
	}

	public ResponseEntity<ResponseStructure<Page<Event>>> getEventPaginationAndSorting(int PageNumber, int PageSize, String field){
		ResponseStructure<Page<Event>> res = new ResponseStructure<Page<Event>>();
		Page<Event> p = dao.getEventPaginationAndSorting(PageNumber, PageSize, field);
		if(!p.isEmpty()) {
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("fetched all records by ascending sort and pagination");
			res.setData(p);
			return new ResponseEntity<ResponseStructure<Page<Event>>>(res, HttpStatus.OK);
		}
		else {
			throw new ListIsEmptyException("No page found");
		}
	}
	
}
