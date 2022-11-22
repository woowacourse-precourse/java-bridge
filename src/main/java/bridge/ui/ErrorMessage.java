package bridge.ui;

public enum ErrorMessage {
	BRIDGE_SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
	MOVING("[ERROR] 이동은 U 또는 D 로만 입력해주셔야 합니다."),
	GAME_COMMAND("[ERROR] 종료 여부는 R 또는 Q 로만 입력해주셔야 합니다.");

	private String msg;

	private ErrorMessage(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return this.msg;
	}
}
