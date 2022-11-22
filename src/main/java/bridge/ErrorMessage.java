package bridge;

public enum ErrorMessage {
    BRIDGELENGTHERROREXCEPTION("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    WRONGMOVEINPUTEXCEPTION("이동할 칸은 U 혹은 D만 입력할 수 있습니다."),
    WRONGGAMEENDINPUTEXCEPTION("재시도 R키 종료 Q키 이외의 키는 입력할 수 없습니다."),
    PASS("PASS");

    private String errorMessage;

    private ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
