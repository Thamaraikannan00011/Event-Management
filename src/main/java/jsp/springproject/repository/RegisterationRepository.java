package jsp.springproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jsp.springproject.entity.Registeration;

@Repository
public interface RegisterationRepository extends JpaRepository<Registeration, Integer>{
	
	@Query(value = "SELECT r FROM Registeration r WHERE r.event.id = ?1")
	public List<Registeration> findRegisterationByEventId(int id);

	@Query(value = "SELECT r FROM Registeration r WHERE r.attendee.id = ?1")
	public List<Registeration> findRegisterationByAttendeeId(int id);
}
