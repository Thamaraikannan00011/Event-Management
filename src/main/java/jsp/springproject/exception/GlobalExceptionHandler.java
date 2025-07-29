package jsp.springproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jsp.springproject.dto.ResponseStructure;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoObjectPassedException.class)
	public ResponseEntity<ResponseStructure<String>> handleNoObjectPassed(NoObjectPassedException ex){
		ResponseStructure<String> res = new ResponseStructure<String>();
		res.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		res.setMessage("missing argument");
		res.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleIdNotFound(IdNotFoundException ex){
		ResponseStructure<String> res = new ResponseStructure<String>();
		res.setStatus(HttpStatus.NOT_FOUND.value());
		res.setMessage("failure");
		res.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ListIsEmptyException.class)
	public ResponseEntity<ResponseStructure<String>> handleListIsEmpty(ListIsEmptyException ex){
		ResponseStructure<String> res = new ResponseStructure<String>();
		res.setStatus(HttpStatus.NOT_FOUND.value());
		res.setMessage("failure");
		res.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UpdateNotValid.class)
	public ResponseEntity<ResponseStructure<String>> handleUpdateValidation(UpdateNotValid ex){
		ResponseStructure<String> res = new ResponseStructure<String>();
		res.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		res.setMessage("failure");
		res.setData(ex.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.NOT_ACCEPTABLE);
	}

}
