package jsp.springproject.exception;

public class UpdateNotValid extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public UpdateNotValid(String message) {
		super(message);
	}
}
