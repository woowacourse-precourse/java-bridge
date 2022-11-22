package bridge.config;

public enum ExceptionMessage {
    WRONG_BRIDGE_SQUARE("다리의 요소는 반드시 U, D이어야 합니다."),
    WRONG_SIZE_FORMAT("다리의 길이는 오직 숫자만 입력받아야 합니다."),
    NUMBER_OUT_OF_RANGE("다리의 길이는 3 ~ 20이어야 합니다."),
    NOT_ALL_UPPERCASE("오직 대문자만 입력 받을 수 있습니다."),
    WRONG_OPTION_LENGTH("1글자만 입력해야 합니다."),
    WRONG_GAME_OPTION("R(게임 재시작)과 Q(게임 종료)만 입력할 수 있습니다."),
    WRONG_MOVE_OPTION("오직 U(위 칸)과 D(아래 칸)을 입력할 수 있습니다."),
    EMPTY_ANSWER_BRIDGE("아직 정답 다리가 비어있습니다."),
    ALREADY_EXIT_ANSWER_BRIDGE("다리는 1번만 생성할 수 있습니다.");

    private final String message;

    public static final String ERROR = "[ERROR] ";

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR + message;
    }
}
