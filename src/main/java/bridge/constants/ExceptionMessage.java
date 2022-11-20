package bridge.constants;

public class ExceptionMessage {
    private ExceptionMessage() {
    }

    public static final String NOT_INPUT = "[ERROR] 입력값을 입력하지 않았습니다.";
    public static final String NUMBERS_BETWEEN = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String NOT_NUMBER_CHARACTERS = "[ERROR] 숫자가 아닌 문자를 입력 하였습니다.";
    public static final String NOT_UP_DOWN_CHARACTERS = "[ERROR] U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력할 수 있습니다.";
    public static final String NOT_RESTART_QEND_CHARACTERS = "[ERROR] R(재시작)과 Q(종료) 중 하나의 문자를 입력할 수 있습니다.";

}
