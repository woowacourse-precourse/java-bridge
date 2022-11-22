package bridge;

public class Constants {
    public static int BRIDGE_SIZE_LOWER_RANGE = 3;
    public static int BRIDGE_SIZE_UPPER_RANGE = 20;

    // 이동 입력 기호
    public static final String UP = "U";
    public static final String DOWN = "D";

    // 맵 표현 기호
    public static final String CORRECT = "O";
    public static final String WRONG  = "X";
    public static final String BRIDGE_START = "[";
    public static final String BRIDGE_END = "]";
    public static final String BRIDGE_DIVIDING_LINE = "|";

    // 재시작 여부 입력 기호
    public static final String RESTART = "R";
    public static final String QUIT = "Q";

    // 게임 안내 메시지
    public static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    public static final String BRIDGE_SIZE_REQUEST_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String MOVING_REQUEST_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String RESTART_REQUEST_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    // 에러 메시지
    public static final String BRIDGE_SIZE_NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 다리 길이는 숫자여야 합니다.";
    public static final String BRIDGE_SIZE_RANGE_ERROR_MESSAGE = String.format("[ERROR] 다리 길이는 %s부터 %s 사이의 숫자여야 합니다.", BRIDGE_SIZE_LOWER_RANGE, BRIDGE_SIZE_UPPER_RANGE);
    public static final String MOVING_SYMBOL_ERROR_MESSAGE = String.format("[ERROR] 이동할 칸은 %s 또는 %s여야 합니다.", UP, DOWN);
    public static final String RESTART_SYMBOL_ERROR_MESSAGE = String.format("[ERROR] 재시도 여부는 %s 또는 %s여야 합니다.", RESTART, QUIT);
}
