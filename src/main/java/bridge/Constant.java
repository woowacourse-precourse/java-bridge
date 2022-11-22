package bridge;

public class Constant {
    public static final String ERROR = "[ERROR] ";

    public static final Integer MIN_BRIDGE_SIZE = 3;
    public static final Integer MAX_BRIDGE_SIZE = 20;

    public static final String UP = "U";
    public static final String DOWN = "D";

    public static final String RETRY = "R";
    public static final String QUIT = "Q";

    public static final String BRIDGE_START = "[ ";
    public static final String BRIDGE_END = " ]";
    public static final String BRIDGE_DELIMITER = " | ";

    public static final String BRIDGE_RIGHT = "O";
    public static final String BRIDGE_WRONG = "X";
    public static final String BRIDGE_BLANK = " ";

    public static final String SUCCESS = "성공";
    public static final String FAILURE = "실패";

    public static final String READ_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String READ_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String READ_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String PRINT_RESULT = "최종 게임 결과";
    public static final String GAME_RESULT = "게임 성공 여부: ";
    public static final String ATTEMPT = "총 시도한 횟수: ";

    public static final String BRIDGE_SIZE_ERROR = ERROR + "다리 길이는 " +
            MIN_BRIDGE_SIZE + "부터 " + MAX_BRIDGE_SIZE + " 사이의 숫자여야 합니다.";
    public static final String MOVING_ERROR = ERROR + "이동할 칸을 U 또는 D로 입력해주세요. (위: U, 아래: D)";
    public static final String GAME_COMMAND_ERROR = ERROR + "게임을 다시 시도할지 여부를 R 또는 Q로 입력해주세요. (재시도: R, 종료: Q)";

}
