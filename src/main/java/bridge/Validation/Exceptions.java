package bridge.Validation;

public enum Exceptions {
	NUMBER_ONLY_EXCEPTION(new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.")),
	U_OR_D_ONLY_EXCEPTION(new IllegalArgumentException("[ERROR] U 혹은 D를 입력해주세요.")),
	LENGTH_EXCEPTION(new IllegalArgumentException("[ERROR] 올바른 길이로 입력해주세요.")),
	RANGE_EXCEPTION(new IllegalArgumentException("[ERROR] 3~20의 수를 입력해주세요."));

	private IllegalArgumentException exception;

	Exceptions(IllegalArgumentException exception){
		this.exception = exception;
	}

	public IllegalArgumentException getException() {
		return exception;
	}


}
