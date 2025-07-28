package jsp.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jsp.springproject.entity.Registeration;

@Repository
public interface RegisterationRepository extends JpaRepository<Registeration, Integer>{

}
