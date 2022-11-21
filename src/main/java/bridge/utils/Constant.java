package bridge.utils;

public class Constant {

    public final static String ERROR = "[ERROR]";
    public final static String SPACE = "\t";
    public final static String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public final static String ASK_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    public final static String ASK_MOVE_POSITION_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public final static String ASK_RESTART_GAME_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public final static String WRONG_BRIDGE_SIZE_MESSAGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public final static String FINAL_SCORE_MESSAGE = "최종 게임 결과";
    public final static String CLEAR_OR_NOT_MESSAGE = "게임 성공 여부: ";
    public final static String RETRY_TOTAL_COUNT_MESSAGE = "총 시도한 횟수: ";
    public final static String POOR_CONSTRUCTION = "Broken Bridge";
    public final static String POOR_CONSTRUCTION_MESSAGE = "양쪽다 건널 수 없는 다리입니다.";
    public final static String WRONG_INSERT_POSITION_MESSAGE = "U, D 이외에 값은 이동할 수 없습니다.";
    public final static String WRONG_INSERT_RE_GAME_MESSAGE = "R, Q 이외에 값은 동작 하지않습니다.";
    public static final String SPACE_MARK = "   |";
    public static final String CORRECT_MARK = " O |";
    public static final String WRONG_MARK = " X |";
    public final static int BRIDGE_MIN_SIZE = 3;
    public final static int BRIDGE_MAX_SIZE = 20;
}
