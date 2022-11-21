package bridge.utils;

public enum ErrorMessage {

    INVALID_BRIDGE_SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_MOVING("[ERROR] 이동할 칸은 U(위 칸)와 D(아래 칸) 중 하나여야 합니다."),
    INVALID_RETRY("[ERROR] 재시도 여부는 R(재시작)과 Q(종료) 중 하나여야 합니다.");

    public final String message;

    ErrorMessage(String message){
        this.message = message;
    }
}
