package bridge.Enum;

public enum ErrorMessage {
    NUMERIC_ERROR("[ERROR] 숫자를 입력해주세요."),
    BRIDGE_SIZE_ERROR("[ERROR] "+ BridgeInfo.MIN_SIZE.getInfo() +"~"+ BridgeInfo.MAX_SIZE.getInfo() +" 사이의 숫자를 입력해주세요."),
    UPDWON_INPUT_ERROR("[ERROR] "+BridgeGameInfo.UP.getWord()+"와 "+BridgeGameInfo.DOWN.getWord()+" 중 하나를 입력해주세요."),
    RESTART_INPUT_ERROR("[ERROR] "+BridgeGameInfo.RESTART.getWord()+"와 "+BridgeGameInfo.QUIT.getWord()+" 중 하나를 입력해주세요.");
    final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
