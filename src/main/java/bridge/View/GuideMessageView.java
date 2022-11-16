package bridge.View;

public enum GuideMessageView {

	StartBridgeGameGuideMessage("다리 건너기 게임을 시작합니다.");

	private String message;
	GuideMessageView(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
