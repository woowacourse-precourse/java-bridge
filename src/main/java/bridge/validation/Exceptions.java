package bridge.validation;

public enum Exceptions {
	NUMBER_ONLY_EXCEPTION(new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.")),
	U_OR_D_EXCEPTION(new IllegalArgumentException("[ERROR] U 혹은 D를 입력해 주세요.")),
	LENGTH_EXCEPTION(new IllegalArgumentException("[ERROR] 올바른 길이로 입력해 주세요.")),
	RANGE_EXCEPTION(new IllegalArgumentException("[ERROR] 3이상 20이하의 수를 입력해 주세요.")),
	R_OR_Q_EXCEPTION(new IllegalArgumentException("[ERROR] R 혹은 Q를 입력해 주세요."));

	private IllegalArgumentException exception;

	Exceptions(IllegalArgumentException exception) {
		this.exception = exception;
	}

	public IllegalArgumentException getException() {
		return exception;
	}
}
