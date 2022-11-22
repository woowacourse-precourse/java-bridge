package bridge;

public class Constant {
    static final String ERROR_MESSAGE_LENGTH_STRING = "[ERROR] 다리 길이는 숫자여야 합니다.";
    static final String ERROR_MESSAGE_LENGTH_RANGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    static final String ERROR_MESSAGE_MOVE_STRING = "[ERROR] U 또는 D를 입력해주세요.";
    static final String ERROR_MESSAGE_GAME_COMMAND_STRING = "[ERROR] R 또는 Q를 입력해주세요.";

    static final String MESSAGE_GAME_START = "다리 건너기 게임을 시작합니다.\n";
    static final String MESSAGE_ENTER_LENGTH = "다리의 길이를 입력해주세요.";
    static final String MESSAGE_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    static final String MESSAGE_RESTART = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    static final String MESSAGE_RESULT = "최종 게임 결과";
    static final String MESSAGE_IS_SUCCESS = "게임 성공 여부: ";
    static final String MESSAGE_SUCCESS = "성공";
    static final String MESSAGE_FAILURE = "실패";
    static final String MESSAGE_TOTAL_TRIAL = "총 시도한 횟수: ";

    static final String MESSAGE_VALID_BLOCK = " O ";
    static final String MESSAGE_INVALID_BLOCK = " X ";
    static final String MESSAGE_BLANK_BLOCK = "   ";
    static final String MESSAGE_SEPARATOR = "|";
    static final String MESSAGE_LEFT_BRACKET = "[";
    static final String MESSAGE_RIGHT_BRACKET = "]";

    static final String MOVE_UP = "U";
    static final String MOVE_DOWN = "D";
    static final String RETRY_USER_YES = "R";

    static final int MOVERESULT_FLAG_VALID = 1;
    static final int MOVERESULT_FLAG_INVALID = 0;
    static final int MOVERESULT_FLAG_FULL = 2;
    static final int RETRY_FLAG_YES = 1;
    static final int RETRY_FLAG_NO = 0;

}
