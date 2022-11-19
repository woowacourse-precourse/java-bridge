package bridge.validator;

import static bridge.validator.ErrorMessage.*;

import java.util.regex.Pattern;

public class BridgeSizeValidator {
	private static final Pattern pattern = Pattern.compile("[0-9]+");

	public int runBridgeSizeValidator(String inputSize) throws IllegalArgumentException {
		if (isNotNumber(inputSize)) {
			throw new IllegalArgumentException(ONLY_NUMBER.getMessage());
		}
		int size = Integer.parseInt(inputSize);
		if (isOutboundRange(size)) {
			throw new IllegalArgumentException(NUMBER_RANGE.getMessage());
		}
		return size;
	}

	private boolean isNotNumber(String inputSize) {
		return !pattern.matcher(inputSize).matches();
	}

	private boolean isOutboundRange(int inputSize) {
		return inputSize < 3 || inputSize > 20;
	}
}
