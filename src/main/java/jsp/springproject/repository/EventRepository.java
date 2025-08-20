package jsp.springproject.repository;

import jsp.springproject.entity.Attendee;
import jsp.springproject.entity.Event;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer>{
	
//	@Query(value = "SELECT e. FROM Event e WHERE e.id = ?1")
//	public List<Attendee> getAttendeeByEventId(int id);
	
	@Query("select r.attendee from Registration r where r.event.id=?1")
    List<Attendee> getAttendeeByEvenetId(Integer id);

    @Query("select e from Event e where e.organizer.id=?1")
    List<Event> getEventByOrganizerId(Integer id);


	
}
