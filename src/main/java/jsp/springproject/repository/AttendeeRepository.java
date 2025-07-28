package jsp.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jsp.springproject.entity.Attendee;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Integer>{

}
