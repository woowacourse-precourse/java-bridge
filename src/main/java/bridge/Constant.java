package bridge;

public class Constant {
    static String UP = "U";
    static String DOWN = "D";
    static String RETRY = "R";
    static String QUIT = "Q";
    static String SELECT_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    static String SELECT_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    static String START_GAME_MESSAGE = "다리 건너기 게임을 시작합니다. \n";
    static String OPEN_BRACKET = "[";
    static String CLOSE_BRACKET = "]";
    static String WRONG_WAY = " X ";
    static String EMPTY_WAY = "   ";
    static String RIGHT_WAY = " O ";
    static String CONNECT_WAY = "|";
    static String REQUEST_BRIDGE_SIZE = "다리 길이를 입력해주세요.";
    static String GAME_IS_SUCCESS_MESSAGE = "게임 성공 여부: ";
    static String TOTAL_TRY_COUNT = "총 시도한 횟수: ";
    static String SUCCESS = "성공";
    static String FAIL = "실패";
    static String FINAL_GAME_RESULT = "최종 게임 결과";
    static String ERROR="[ERROR]";
    static String ERROR_MESSAGE_LENGTH="다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    static String ERROR_MESSAGE_UP_DOWN="U 또는 D 문자를 입력해주세요.";
    static String ERROR_MESSAGE_RETRY_QUIT="R 또는 Q 문자를 입력해주세요.";
    static String ERROR_IS_NOT_NUMBER="다리 길이는 숫자입니다.";

}
