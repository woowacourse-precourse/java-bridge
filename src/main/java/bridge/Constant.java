package bridge;

public class Constant {
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final String EMPTY = " ";
    public static final String EMPTY_BLOCK = "[  ]";
    public static final String NEXT = "\n";
    public static final String CONTOUR = " | ";


    public static final String REGEX = "[+-]?\\d*(\\.\\d+)?";
    public static final int MIN = 3;
    public static final int MAX = 20;


    public static final String RETRY = "R";
    public static final String QUIT = "Q";

    public static final String UP = "U";
    public static final String DOWN = "D";

    public static final String SUCCESS = "성공";
    public static final String FAIL = "실패";
    public static final String WRONG = "X";
    public static final String RIGHT = "O";


    public static final String ERROR = "[ERROR] ";
    public static final String INPUT_BRIDGE_SIZE_STRING = "숫자를 입력해주세요.";
    public static final String INPUT_BRIDGE_SIZE_WRONG_RANGE = "3~20사이의 값을 입력해주세요.";
    public static final String INPUT_WRONG_RETRY_SELECT = "R 또는 Q를 입력해주세요.";
    public static final String INPUT_WRONG_UP_DOWN_SELECT = "U 또는 D를 입력해주세요";


    public static final String INITIAL_MESSAGE = "다리 건너기 게임을 시작합니다.\n\n" + "다리의 길이를 입력해주세요.";
    public static final String SELECT_UP_DOWN_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String SELECT_RETRY_QUIT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public static final String FINAL_RESULT_MESSAGE = "최종 게임 결과";
    public static final String GAME_WIN_MESSAGE = "게임 성공 여부: ";
    public static final String OVERALL_TRY_NUMBER = "총 시도한 횟수: ";




}
