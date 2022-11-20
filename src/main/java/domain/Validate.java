package domain;

public class Validate {
	private String errorMessage;
	
	public void validateSize(int size) {
		if(size < 3 || 20 < size) {
			errorMessage = ErrorMessage.WRONG_SIZE.getErrorMessage();
			throw new IllegalArgumentException(errorMessage);
		}
	}
}
