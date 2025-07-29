package jsp.springproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jsp.springproject.dao.OrganizerDAO;
import jsp.springproject.dto.ResponseStructure;
import jsp.springproject.entity.Organizer;
import jsp.springproject.exception.*;

@Service
public class OrganizerService {
	
	@Autowired
	private OrganizerDAO dao;
	
	public ResponseEntity<ResponseStructure<Organizer>> createOrganizer(Organizer organizer){
		if(organizer.getName() != null && organizer.getEmail() != null) {
			Organizer o = dao.createOrganizer(organizer);
			ResponseStructure<Organizer> res = new ResponseStructure<Organizer>();
			res.setStatus(HttpStatus.CREATED.value());
			res.setMessage("Added Orgainzer.");
			res.setData(o);
			return new ResponseEntity<ResponseStructure<Organizer>>(res, HttpStatus.CREATED);
		}
		else {
			throw new NoObjectPassedException("No object found to save.");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Organizer>>> getAllOrganizer(){
		List<Organizer> li = dao.getAllOrganizer();
		if(!li.isEmpty()) {
			ResponseStructure<List<Organizer>> res = new ResponseStructure<List<Organizer>>();
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Fetched all organizer.");
			res.setData(li);
			return new ResponseEntity<ResponseStructure<List<Organizer>>>(res, HttpStatus.OK);
		}
		else {
			throw new ListIsEmptyException("No record found.");
		}
	}
	
	public ResponseEntity<ResponseStructure<Organizer>> getOrganizerById(int id){
		Optional<Organizer> opt = dao.getOrganizerById(id);
		if(opt.isPresent()) {
			ResponseStructure<Organizer> res = new ResponseStructure<Organizer>();
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Fetched organizer by id.");
			res.setData(opt.get());
			return new ResponseEntity<ResponseStructure<Organizer>>(res, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("No record found by given id.");
		}
	}
	
	public ResponseEntity<ResponseStructure<Organizer>> updateOrganizer(Organizer organizer){
		Optional<Organizer> opt = dao.getOrganizerById(organizer.getId());
		if(opt.isPresent()) {
			dao.updateOrganizer(organizer);
			ResponseStructure<Organizer> res = new ResponseStructure<Organizer>();
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Organizer updated success.");
			res.setData(organizer);
			return new ResponseEntity<ResponseStructure<Organizer>>(res, HttpStatus.OK);
		}
		else {
			throw new UpdateNotValidException("Record not found to update.");
		}
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteOrganizerById(int id){
		Optional<Organizer> opt = dao.getOrganizerById(id);
		if(opt.isPresent()) {
			dao.deleteOrganizer(id);
			ResponseStructure<String> res = new ResponseStructure<String>();
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Success.");
			res.setData("Deleted Organizer.");
			return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("No, Id found to delete.");
		}
	}

	public ResponseEntity<ResponseStructure<Page<Organizer>>> getOrganizerByPaginationAndSorting(int pageNumber, int pageSize, String field){
		Page<Organizer> p = dao.getOrganizerByPaginationAndSorting(pageNumber, pageSize, field);
		if(!p.isEmpty()) {
			ResponseStructure<Page<Organizer>> res = new ResponseStructure<Page<Organizer>>();
			res.setStatus(HttpStatus.OK.value());
			res.setMessage("Record fetched and seperated by page request");
			res.setData(p);
			return new ResponseEntity<ResponseStructure<Page<Organizer>>>(res, HttpStatus.OK);
		}
		else {
			throw new ListIsEmptyException("No page found");
		}
	}
	
}
