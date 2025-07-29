package jsp.springproject.exception;

public class ListIsEmptyException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ListIsEmptyException(String message) {
		super(message);
	}
}
