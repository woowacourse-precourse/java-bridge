package bridge.constant;

public enum ErrorStatus {
    BridgeLength("3 이상 20 이하의 숫자를 입력 해주세요."),
    MoveCmd(" U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력 해주세요."),
    ReGame("R(재시작)과 Q(종료) 중 하나의 문자를 입력 해주세요.");

    private final String des;

    ErrorStatus(String des){
        this.des = des;
    }

    public String getDes() {
        return "[ERROR]"+des;
    }
}
