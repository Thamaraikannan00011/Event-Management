package jsp.springproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jsp.springproject.entity.Registeration;
import jsp.springproject.repository.RegisterationRepository;

@Repository
public class RegisterationDAO {
	
	@Autowired
	private RegisterationRepository repository;
	
	public Registeration createRegister(Registeration registeration) {
		return repository.save(registeration);
	}
	
	public List<Registeration> getAllRegisteration(){
		return repository.findAll();
	}
	
	public Optional<Registeration> getRegisterationById(int id){
		return repository.findById(id);
	}
	
	public void cancelRegisteration(int id) {
		repository.deleteById(id);
	}

	public List<Registeration> getRegisterationByEventId(int id){
		return repository.findRegisterationByEventId(id);
	}
	
	public List<Registeration> getRegisterationByAttendeeId(int id){
		return repository.findRegisterationByAttendeeId(id);
	}
}
