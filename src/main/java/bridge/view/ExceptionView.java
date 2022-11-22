package bridge.view;

public class ExceptionView {

    public static String message;

    public static void bridgeRangeError() {
        message = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    }

    public static void commandUpperOrLowerError() {
        message = "[ERROR] U(위 칸)과 D(아래 칸) 중 하나를 선택하여야 합니다.";
    }

    public static void commandRestartOrNotError() {
        message = "[ERROR] R(재시작)과 Q(종료) 중 하나를 선택하여야 합니다.";
    }


}
