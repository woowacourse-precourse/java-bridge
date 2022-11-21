package bridge;

public class Constant {
    static final String ERROR_MESSAGE_LENGTH_STRING = "[ERROR] 다리 길이는 숫자여야 합니다.";
    static final String ERROR_MESSAGE_LENGTH_RANGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    static final String ERROR_MESSAGE_MOVE_STRING = "[ERROR] U 또는 D를 입력해주세요.";
    static final String ERROR_MESSAGE_GAME_COMMAND_STRING = "[ERROR] R 또는 Q를 입력해주세요.";

    static final String MOVE_UP = "U";
    static final String MOVE_DOWN = "D";
    static final String RESTART_YES = "R";
    static final String RESTART_NO = "Q";
    static final String PRINT_BLOCK_VALID = "O";
    static final String PRINT_BLOCK_INVALID = "X";

    static final int MOVERESULT_FLAG_VALID = 1;
    static final int MOVERESULT_FLAG_INVALID = 0;

}
