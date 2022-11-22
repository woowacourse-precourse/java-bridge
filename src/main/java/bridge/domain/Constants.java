package bridge.domain;

public final class Constants {

    public static final String INPUT_BRIDGE_LENGTH_GUIDE_MESSAGE = "\n다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVE_COMMAND_GUIDE_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_GAME_COMMAND_GUIDE_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public static final String WRONG_INPUT_BRIDGE_LENGTH_MESSAGE = "\n[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String WRONG_INPUT_MOVE_COMMAND_MESSAGE = "\n[ERROR] 이동 가능한 칸은 U 또는 D 입니다.";
    public static final String WRONG_INPUT_GAME_COMMAND_MESSAGE = "\n[ERROR] 입력 가능한 명령어는 R 또는 Q 입니다.";

    public static final String UP_COMMAND = "U";
    public static final String DOWN_COMMAND = "D";
    public static final String RETRY_COMMAND = "R";
    public static final String QUITE_COMMAND = "Q";

    public static final String START_MAP = "[";
    public static final String END_MAP = "]";
    public static final String SUCCESSFUL_CASE_MAP = " O ";
    public static final String FAILED_CASE_MAP = " X ";
    public static final String NON_ANSWER_CASE_MAP = "   ";
    public static final String SEPARATOR = "|";

    public static final String ONLY_NUMBERS_REGEX = "^[0-9]*$";
    public static final int MAX_BRIDGE_SIZE = 20;
    public static final int MIN_BRIDGE_SIZE = 3;
    public static final int REPEAT_START = 0;
}
