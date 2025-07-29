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
import jsp.springproject.entity.Organizer;
import jsp.springproject.service.OrganizerService;

@RestController
@RequestMapping("/organizer")
public class OrganizerController {
	
	@Autowired
	private OrganizerService ser;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Organizer>> createOrganizer(@RequestBody Organizer organizer){
		return ser.createOrganizer(organizer);
	}

	@GetMapping
	public ResponseEntity<ResponseStructure<List<Organizer>>> getAllOrganizer(){
		return ser.getAllOrganizer();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Organizer>> getOrganizerById(@PathVariable int id){
		return ser.getOrganizerById(id);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Organizer>> updateOrganizer(@RequestBody Organizer organizer){
		return ser.updateOrganizer(organizer);
	}
	
	@DeleteMapping("/{id}")		
	public ResponseEntity<ResponseStructure<String>> deleteOrganizerById(@PathVariable int id){
		return ser.deleteOrganizerById(id);
	}
	
	@GetMapping("/page/{pageNumber}/{pageSize}/{field}")
	public ResponseEntity<ResponseStructure<Page<Organizer>>> getOrganizerByPaginationAndSorting(@PathVariable int pageNumber, @PathVariable int pageSize, @PathVariable String field){
		return ser.getOrganizerByPaginationAndSorting(pageNumber, pageSize, field);
	}
	
}

