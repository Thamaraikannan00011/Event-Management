package jsp.springproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jsp.springproject.entity.Attendee;
import jsp.springproject.entity.Registeration;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Integer>{
	@Query(value = "SELECT a.registerations FROM Attendee a WHERE a.id = ?1")
	public List<Registeration> findRegistrationById(int id);
	
	@Query(value = "SELECT a FROM Attendee a WHERE a.contact = ?1")
	public Attendee findAttendeeByContact(long phone);
}
