package bridge.enums;

public enum ErrorMsg {
	BRIDGE_LENGTH_OUT_OF_RANGE("[ERROR] 로또 번호의 개수가 6개여야 합니다.");

	private String message;

	ErrorMsg(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}
