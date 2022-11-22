package bridge.domain;

public enum BridgeGameStatus {
	GAME_PROCESSING("진행중"),
	GAME_SUCCESS("성공"),
	GAME_FAILED("실패");

	private String status;

	BridgeGameStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
