package jsp.springproject.exception;

public class UpdateNotValidException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public UpdateNotValidException(String message) {
		super(message);
	}
}
