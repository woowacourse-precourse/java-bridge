package bridge.enums;

public enum Error {
	HEAD("[ERROR] "),
	BRIDGE_SIZE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
	MOVE("위:U, 아래: D"),
	RETRY("재시도: R, 종료: Q");

	private final String value;

	Error(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
