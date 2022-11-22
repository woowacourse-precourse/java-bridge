package bridge;

import java.util.regex.Pattern;

public class Exception {

	public void notNatural(String bridgeSizeInput) throws IllegalArgumentException {
		if (!Pattern.matches("^[0-9]*$", bridgeSizeInput)) {
			throw new IllegalArgumentException(Constants.ERROR_NUMBER_PATTERN);
		}
	}

}
