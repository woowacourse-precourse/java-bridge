package bridge;

public class Constants {
    public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public static final String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String RESULT_MESSAGE = "최종 게임 결과";
    public static final String TRY_COUNT_MESSAGE = "총 시도한 횟수: ";
    public static final String SUCCESS_MESSAGE = "게임 성공 여부: 성공";
    public static final String FAILURE_MESSAGE = "게임 성공 여부: 실패";

    public static final String LEFT = "[ ";
    public static final String MIDDLE = " | ";
    public static final String RIGHT = " ]\n";

    public static final String UP = "U";
    public static final String DOWN = "D";
    public static final String RESTART = "R";
    public static final String QUIT = "Q";

    public static final String CORRECT = "O";
    public static final String WRONG = "X";
    public static final String SPACE = " ";

    public static final int MIN_BRIDGE_SIZE = 3;
    public static final int MAX_BRIDGE_SIZE = 20;
}
