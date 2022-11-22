package bridge;

public enum ErrorMessage {
    bridgeSizeError("[ERROR] 3이상 20이하로 입력해 주세요."),
    strError("[ERROR] 입력이 잘못되었습니다.");

    private final String message;

    ErrorMessage(String message){ this.message = message; }
    public String getErrorMessage(){ return message; }
}
