package jsp.springproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jsp.springproject.entity.Event;
import jsp.springproject.entity.Venue;

@Repository
public interface VenueRepository extends JpaRepository<Venue, Integer>{
//	@Query("SELECT v.event FROM Venue v WHERE e.id = ?1")
//	List<Event> findEventByVenueId(int id);
//	
//	@Query("SELECT v FROM Venue v WHERE v.location = ?1")
//	List<Venue> findVenueByLocation(String location);
}
