package bridge.domain;

public enum ResultStatus {
	SUCCESS("성공"),
	RETRY("재시도"),
	FAILURE("실패");

	private final String resultStatusMessage;

	ResultStatus(String resultStatusMessage) {
		this.resultStatusMessage = resultStatusMessage;
	}

	public static ResultStatus makeResultStatus(String bridgeCommand, String command) {
		if (bridgeCommand != null && bridgeCommand.equals(command)) {
			return SUCCESS;
		}
		return FAILURE;
	}

	public String getResultStatusMessage() {
		return this.resultStatusMessage;
	}
}
