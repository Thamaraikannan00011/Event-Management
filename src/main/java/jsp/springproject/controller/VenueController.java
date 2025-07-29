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
import jsp.springproject.entity.Venue;
import jsp.springproject.service.VenueService;

@RestController
@RequestMapping("/venue")
public class VenueController {
	
	@Autowired
	private VenueService ser;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Venue>> createVenue(@RequestBody Venue venue){
		return ser.createVenue(venue);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Venue>>> getAllVenue(){
		return ser.getAllVenue();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Venue>> getVenueById(@PathVariable int id){
		return ser.getVenueById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Venue>> updateVenue(@RequestBody Venue venue){
		return ser.updateVenue(venue);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteVenue(@PathVariable int id){
		return ser.deleteVenue(id);
	}
	
	@GetMapping("/page/{pageNumber}/{pageSize}/{field}")
	public ResponseEntity<ResponseStructure<Page<Venue>>> getVenueByPaginationAndSorting(@PathVariable int pageNumber, @PathVariable int pageSize, @PathVariable String field){
		return ser.getVenueByPaginationAndSorting(pageNumber, pageSize, field);
	}

}
