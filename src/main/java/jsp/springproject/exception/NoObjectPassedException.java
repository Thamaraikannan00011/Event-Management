package jsp.springproject.exception;

public class NoObjectPassedException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NoObjectPassedException(String message) {
		super(message);
	}
	
}
