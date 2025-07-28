package jsp.springproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import jsp.springproject.entity.Organizer;
import jsp.springproject.repository.OrganizerRepository;

@Repository
public class OrganizerDAO {
	@Autowired
	private OrganizerRepository repository;
	
	public Organizer createOrganizer(Organizer organizer) {
		return repository.save(organizer);
	}
	
	public List<Organizer> getAllOrganizer(){
		return repository.findAll();
	}
	
	public Optional<Organizer> getOrganizerById(int id) {
		return repository.findById(id);
	}
	
	public Organizer updateOrganizer(Organizer organizer) {
		return repository.save(organizer);
	}
	
	public void deleteOrganizer(int id) {
		repository.deleteById(id);
	}
	
	public Page<Organizer> getOrganizerByPaginationAndSorting(int pageNumber, int pageSize, String field){
		return repository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(field).ascending()));
	}
	
}
