package jsp.springproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jsp.springproject.entity.Attendee;
import jsp.springproject.entity.Registeration;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Integer>{
	
	@Query("SELECT a FROM Attendee a WHERE a.email = ?1")
	public Optional<Attendee> updateValidation(String email);
	
	@Query("SELECT a.registerations FROM Attendee a WHERE a.id = ?1")
	public List<Registeration> findRegistrationById(int id);
	
	@Query("SELECT a FROM Attendee a WHERE a.contact = ?1")
	public Attendee findAttendeeByContact(long phone);
}
