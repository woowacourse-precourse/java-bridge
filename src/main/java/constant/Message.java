package constant;

/*
 ** Enum으로 수정해볼 것
 */
public class Message {

    public static final String UP = "U";
    public static final String DOWN = "D";
    public static final String REGAME = "R";
    public static final String QUIT = "Q";

    public static final String BRIDGE_BEGIN = "[ ";
    public static final String BRIDGE_END = " ]";
    public static final String BRIDGE_DIVIDING_LINE = " | ";

    public static final String CORRECT = "O";
    public static final String WRONG = "X";
    public static final String EMPTY = " ";

    public static final String NEWLINE = "\n";
    public static final String SUCCESS = "성공";
    public static final String FAILURE = "실패";

    public static final String PRINT_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    public static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    public static final String SELECT_UP_AND_DOWN = "이동할 칸을 선택해주세요. (위: %s, 아래: %s)";
    public static final String SELECT_REGAME_OR_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)";
    public static final String PRINT_GAME_RESULT = "최종 게임 결과";
    public static final String PRINT_WHETHER_SUCCESS_OR_NOT = "게임 성공 여부: %s";
    public static final String TOTAL_NUMBERS_OF_ATTEMPTS = "총 시도한 횟수: %d";

}
