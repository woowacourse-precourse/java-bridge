package bridge.validator;

public enum ErrorMessage {
	ONLY_NUMBER("다리 길이는 숫자로만 이루어져야 합니다."),
	NUMBER_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
	MOVE_INPUT("이동할 칸은 U(위), D(아래) 알파벳으로 입력해야 합니다."),
	DECISION_INPUT("게임 지속여부는 R(재시도), Q(종료) 알파벳으로 입력해야 합니다.");

	private final String message;

	ErrorMessage(String message) {
		String prefix = "[ERROR] ";
		this.message = prefix + message;
	}

	public String getMessage() {
		return message;
	}
}
