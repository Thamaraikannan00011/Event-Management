package jsp.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jsp.springproject.entity.Organizer;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, Integer>{

}
