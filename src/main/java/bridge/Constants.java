package bridge;

public final class Constants {

    public static final String START_BRIDGE_GAME = "다리 건너기 게임을 시작합니다.\n";
    public static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVING_SPACE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_RETRY_CHOICE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String BRIDGE_SIZE_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String USER_MOVE_SPACE_ERROR_MESSAGE = "[ERROR] 사용자가 이동할 칸은 U(위 칸)과 D(아래 칸) 중 하나의 문자여야 합니다.";
    public static final String USER_RESTART_ERROR_MESSAGE = "[ERROR] 사용자가 입력할 값은 R(재시작)과 Q(종료) 중 하나의 문자여야 합니다.";
    public static final String CHECK_IS_NUMBER = "^[0-9]+$";
    public static final String UPSIDE = "U";
    public static final String DOWNSIDE = "D";
    public static final String RESTART = "R";
    public static final String QUIT = "Q";
    public static final String ERROR = "ERROR";
    public static final String BLANK = " ";
    public static final String MOVE_SUCCESS = "O";
    public static final String MOVE_FAILURE = "X";

    public static final String GAME_RESULT = "최종 게임 결과";
    public static final String SUCCESS_OR_NOT = "게임 성공 여부: ";
    public static final String TOTAL_ATTEMPT_COUNT = "총 시도한 횟수: ";
    public static final String SUCCESS = "성공";
    public static final String FAILURE = "실패";
    public static final String HEAD_FORM = "[";
    public static final String BODY_FORM = "|";
    public static final String TAIL_FORM = "]";
}


