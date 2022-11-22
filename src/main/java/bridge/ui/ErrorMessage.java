package bridge.ui;

public enum ErrorMessage {
    BridgeSizeERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    BridgeFormERROR("[ERROR] 다리 길이의 형식이 잘못되었습니다."),
    MoveFormERROR("[ERROR] 이동 방향은 U와 D로만 입력해야합니다."),
    RestartFormERROR("[ERROR] 재시작 여부는 R과 Q로만 입력해야 합니다.");

    private String Message;

    ErrorMessage(String Message) {
        this.Message = Message;
    }

    public String getMessage() {
        return this.Message;
    }
}
