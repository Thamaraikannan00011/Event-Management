package jsp.springproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.springproject.dao.VenueDAO;
import jsp.springproject.dto.ResponseStructure;
import jsp.springproject.entity.Venue;
import jsp.springproject.exception.*;

@Service
public class VenueService {
	
	@Autowired
	private VenueDAO dao;
	
	public ResponseEntity<ResponseStructure<Venue>> createVenue(Venue venue){
		if(venue.getName() != null && venue.getLocation() != null && venue.getCapacity() != 0) {
			ResponseStructure<Venue> res = new ResponseStructure<Venue>();
			res.setStatus(HttpStatus.CREATED.value());
			res.setMessage("Added venue.");
			res.setData(venue);
			return new ResponseEntity<ResponseStructure<Venue>>(res, HttpStatus.CREATED);
		}
		else {
			throw new NoObjectPassedException("Missing argument.");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Venue>>> getAllVenue(){
		List<Venue> li = dao.getAllVenue();
		if(!li.isEmpty()) {
			ResponseStructure<List<Venue>> res = new ResponseStructure<List<Venue>>();
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Fetched all venue.");
			res.setData(li);
			return new ResponseEntity<ResponseStructure<List<Venue>>>(res, HttpStatus.OK);
		}
		else {
			throw new ListIsEmptyException("No record found in database.");
		}
	}
	
	public ResponseEntity<ResponseStructure<Venue>> getVenueById(int id){
		Optional<Venue> opt = dao.getVenueById(id);
		if(opt.isPresent()) {
			ResponseStructure<Venue> res = new ResponseStructure<Venue>();
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Fetched venue by id.");
			res.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Venue>>(res, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("No record found by given id.");
		}
	}
	
	public ResponseEntity<ResponseStructure<Venue>> updateVenue(Venue venue){
		Optional<Venue> opt = dao.getVenueById(venue.getId());
		if(opt.isPresent()) {
			ResponseStructure<Venue> res = new ResponseStructure<Venue>();
			res.setStatus(HttpStatus.CREATED.value());
			res.setMessage("Venue updated.");
			res.setData(venue);
			return new ResponseEntity<ResponseStructure<Venue>>(res, HttpStatus.CREATED);
		}
		else {
			throw new UpdateNotValidException("Venue can't be updated.");
		}
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteVenue(int id){
		Optional<Venue> opt = dao.getVenueById(id);
		if(opt.isPresent()) {
			dao.deleteVenue(id);
			ResponseStructure<String> res = new ResponseStructure<String>();
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Record deleted.");
			res.setData("Success.");
			return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("No record found to delete.");
		}
	}
	
	public ResponseEntity<ResponseStructure<Page<Venue>>> getVenueByPaginationAndSorting(int pageNumber, int pageSize, String field){
		Page<Venue> p = dao.getVenueByPaginationAndSorting(pageNumber, pageSize, field);
		if(!p.isEmpty()) {
			ResponseStructure<Page<Venue>> res = new ResponseStructure<Page<Venue>>();
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Record fetched by pagination.");
			res.setData(p);
			return new ResponseEntity<ResponseStructure<Page<Venue>>>(res, HttpStatus.OK);
		}
		else {
			throw new ListIsEmptyException("No page found.");
		}
	}

}
