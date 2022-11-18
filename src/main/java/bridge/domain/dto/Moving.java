package bridge.domain.dto;

public class Moving {
	private final String INVALID_INPUT_MOVING = "[ERROR] D와 U 중에서만 입력해 주시기 바립니다.";
	private final String LOWER_INCLUSIVE = "D";
	private final String UPPER_INCLUSIVE = "U";

	private String moving;

	public Moving(String inputMoving) {
		validateInputMoving(inputMoving);
		this.moving = inputMoving;
	}

	private void validateInputMoving(String inputMoving) {
		if (!inputMoving.equals(LOWER_INCLUSIVE) && !inputMoving.equals(UPPER_INCLUSIVE)) {
			throw new IllegalArgumentException(INVALID_INPUT_MOVING);
		}
	}

	public String getMoving() {
		return this.moving;
	}
}
