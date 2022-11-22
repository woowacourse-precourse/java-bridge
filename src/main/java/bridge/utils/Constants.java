package bridge.utils;

public class Constants {
    public static final int DOWN_NUMBER = 0;
    public static final int UP_NUMBER = 1;
    public static final String DOWN_BLOCK = "D";
    public static final String UP_BLOCK = "U";
    public static final String PLAYER_RETRY = "R";
    public static final String PLAYER_QUIT = "Q";
    public static final int MIN_BRIDGE_SIZE = 3;
    public static final int MAX_BRIDGE_SIZE = 20;

    public static final boolean IS_UP_BLOCK = true;
    public static final boolean IS_DOWN_BLOCK = true;
    public static final boolean IS_FAILURE = true;
    public static final boolean IS_NOT_FAILURE = false;
    public static final String BLOCK_SUCCESS = " O ";
    public static final String BLOCK_FAILURE = " X ";
    public static final String BLOCK_BLANK = " O ";
    public static final String BLOCK_SPLIT = "|";
    public static final String LINE_START = "[";
    public static final String LINE_END = "]";

    public static final String ERROR_BRIDGE_SIZE_NOT_INTEGER = "[ERROR] 다리 길이는 숫자여야 합니다";
    public static final String ERROR_BRIDGE_SIZE_NOT_IN_RANGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String ERROR_BRIDGE_SIZE_IS_ZERO = "[ERROR] 다리 길이는 0이 아닌 숫자여야 합니다.";
    public static final String ERROR_PLAYER_MOVE_IS_NOT_U_OR_D = "[ERROR] 이동할 칸은 U 혹은 D여야 합니다.";
    public static final String ERROR_PLAYER_RESTART_IS_NOT_R_OR_Q = "[ERROR] 게임 재시작 값은 R 혹은 Q여야 합니다.";

    public static final String MESSAGE_GAME_START = "다리 건너기 게임을 시작합니다.\n";
    public static final String MESSAGE_INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String MESSAGE_INPUT_PLAYER_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String MESSAGE_INPUT_PLAYER_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String MESSAGE_RESULT_IS_SUCCESS = "\n게임 성공 여부: 성공";
    public static final String MESSAGE_RESULT_IS_FAILURE = "\n게임 성공 여부: 실패";
    public static final String MESSAGE_RESULT_HOW_MANY_ATTEMPT = "총 시도한 횟수: ";
}
