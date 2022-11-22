package bridge;

import java.util.regex.Pattern;

public class Exception {

	public void notNatural(String bridgeSizeInput) throws IllegalArgumentException {
		if (!Pattern.matches("^[0-9]*$", bridgeSizeInput)) {
			throw new IllegalArgumentException(Constants.ERROR_NUMBER_PATTERN);
		}
	}

	public void checkBridgeSize(String bridgeSizeInput) throws IllegalArgumentException {
		if (Integer.parseInt(bridgeSizeInput) < Constants.NUMBER_THREE
			|| Integer.parseInt(bridgeSizeInput) > Constants.NUMBER_TWENTY) {
			throw new IllegalArgumentException(Constants.ERROR_NUMBER_RANGE);
		}
	}

	public void checkAlphabet(String moving) throws IllegalArgumentException {
		if (!Pattern.matches("^[A-Z]*$", moving)) {
			throw new IllegalArgumentException(Constants.ERROR_ALPHABET_INPUT);
		}
	}

	public void checkMoveInput(String moving) throws IllegalArgumentException {
		if (!moving.equals(Constants.ALPHABET_U) && !moving.equals(Constants.ALPHABET_D)) {
			throw new IllegalArgumentException(Constants.ERROR_U_D_INPUT);
		}
	}

}
