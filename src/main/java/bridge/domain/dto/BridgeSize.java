package bridge.domain.dto;

public class BridgeSize {
	private final String INVALID_LETTER = "[ERROR] 숫자만 입력 가능합니다.";
	private final String INVALID_FIRST_DIGIT = "[ERROR] 두자리 숫자의 첫번째 자리에는 1이상이어야 합니다.";
	protected final String INVALID_NUMBER_BOUNDARY = "[ERROR] 3~20사이의 숫자만 입력 가능합니다.";
	private final String NUMBER_FORMAT = "^\\d{1,2}$";
	private final char FIRST_DIGIT_ZERO = '0';
	private final int DOUBLE_DIGIT = 2;
	protected final int MIN_NUMBER_BOUNDARY = 3;
	protected final int MAX_NUMBER_BOUNDARY = 20;
	private int size;

	public BridgeSize(String inputSize) {
		validateNumber(inputSize);
		validateFirstDigitZero(inputSize);
		validateSizeBoundary(inputSize);
		this.size = Integer.parseInt(inputSize);
	}

	private void validateNumber(String size) {
		if (!size.matches(NUMBER_FORMAT)) {
			throw new IllegalArgumentException(INVALID_LETTER);
		}
	}

	private void validateFirstDigitZero(String size) {
		if (size.length() == DOUBLE_DIGIT && size.charAt(0) == FIRST_DIGIT_ZERO) {
			throw new IllegalArgumentException(INVALID_FIRST_DIGIT);
		}
	}

	private void validateSizeBoundary(String size) {
		int convertedSize = Integer.parseInt(size);
		if (convertedSize < MIN_NUMBER_BOUNDARY || convertedSize > MAX_NUMBER_BOUNDARY) {
			throw new IllegalArgumentException(INVALID_NUMBER_BOUNDARY);
		}
	}

	public int getSize() {
		return this.size;
	}
}
