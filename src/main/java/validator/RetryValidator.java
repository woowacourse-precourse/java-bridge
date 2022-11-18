package validator;

public class RetryValidator {
	public static void validateRetryCommand(String retryCommand) {
		if (!(retryCommand.equals("R") || retryCommand.equals("Q"))) {
			throw new IllegalArgumentException("[ERROR] 재시도/종료 선택을 위해 'R'(재시작) 또는 'Q'(종료)를 입력해야 합니다.");
		}
	}
}
