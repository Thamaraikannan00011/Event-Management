package jsp.springproject.repository;

import jsp.springproject.entity.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer>{
	
//	@Query(value = "SELECT e. FROM Event e WHERE e.id = ?1")
//	public List<Attendee> getAttendeeByEventId(int id);
	
}
