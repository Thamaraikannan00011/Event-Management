package jsp.springproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import jsp.springproject.entity.Event;
import jsp.springproject.entity.Venue;
import jsp.springproject.repository.VenueRepository;

@Repository
public class VenueDAO {
	
	@Autowired
	private VenueRepository repository;
	
	public Venue addVenue(Venue venue) {
		return repository.save(venue);
	}
	
	public List<Venue> getAllVenue(){
		return repository.findAll();
	}
	
	public Optional<Venue> getVenueById(int id){
		return repository.findById(id);
	}
	
	public Venue updateVenue(Venue venue) {
		return repository.save(venue);
	}
	
	public void deleteVenue(int id) {
		repository.deleteById(id);
	}
	
//	public List<Event> getEventsByVenueId(int id){
//		return repository.findEventByVenueId(id);
//	}
//	
//	public List<Venue> getVenueByLocation(String location){
//		return repository.findVenueByLocation(location);
//	}
	
	public Page<Venue> getVenueByPaginationAndSorting(int pageNumber, int pageSize, String field){
		return repository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(field).ascending()));
	}

}
