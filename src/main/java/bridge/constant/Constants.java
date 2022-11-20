package bridge.constant;

public class Constants {

    //Command 관련 상수
    public static final String UP_COMMAND = "U";
    public static final String DOWN_COMMAND = "D";
    public static final String RESTART_COMMAND = "R";
    public static final String QUIT_COMMAND = "Q";

    //map 생성할 때 필요한 상수
    public static final String START_BRACKET = "[";
    public static final String END_BRACKET = "]";
    public static final String STICK = "|";
    public static final String O_SIGN = " O ";
    public static final String X_SIGN = " X ";
    public static final String THREE_SPACES = "   ";

    //게임 메시지
    public static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public static final String REQUEST_FOR_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String SELECT_UP_OR_DOWN_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String SELECT_RESTART_OR_QUIT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String FINAL_RESULT_MESSAGE = "최종 게임 결과";
    public static final String SUCCESS_OR_NOT_MESSAGE = "게임 성공 여부: ";
    public static final String TOTAL_NUMBER_OF_ATTEMPTS_MESSAGE = "총 시도한 횟수: ";

    //에러 메시지
    public static final String SELECT_U_OR_D_MESSAGE = " U 또는 D를 입력해주세요.";
    public static final String SELECT_R_OR_Q_MESSAGE = " R 또는 Q를 입력해주세요.";
    public static final String ERROR_MESSAGE = "[ERROR]";
    public static final String OUT_OF_RANGE_ERROR_MESSAGE = " 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String INVALID_INPUT_ERROR_MESSAGE = " 올바르지 않은 입력입니다.";
}
