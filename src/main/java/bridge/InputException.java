package bridge;

public class InputException extends IllegalArgumentException {

	public static final String EMPTY = "[ERROR] 입력 값이 없습니다.";
	public static final String NOT_A_NUMBER = "[ERROR] 자연수만 입력해주세요.";
	public static final String NOT_IN_BETWEEN_PROPER_RANGE = "[ERROR] 숫자는 %d 이상 %d 이하의 자연수 값이어야 합니다.";

	public InputException(String message) {
		super(message);
		OutputView.printException(message);
	}
}
