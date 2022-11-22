package bridge.view;

public enum Error {
	INPUT_ONLY_NUMBERS("다리 길이는 숫자만 들어올 수 있습니다."),
	INPUT_VALID_LENGTH("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
	INPUT_ONLY_U_OR_D("위로 이동하려면 U, 아래로 이동하려면 D를 입력해주세요."),
	INPUT_ONLY_R_OR_Q("다시 시작하려면 R, 게임을 종료하려면 Q를 입력해주세요."),
	;
	private static final String PREFIX = "[ERROR] ";
	private String message;

	Error(String message) {
		this.message = PREFIX + message;
	}

	public String getMessage() {
		return message;
	}
}
