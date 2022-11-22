package bridge;

public class Constants {
    public static final String ERROR_PREFIX = "[ERROR]";
    public static final String BRIDGE_ERROR = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String MOVE_ERROR = "이동할 칸은 U(위)혹은 D(아래)여야 합니다.";
    public static final String COMMAND_ERROR = "재시작 혹은 종료를 하려면 R(재시작)혹은 Q(종료)여야 합니다.";
    public static final String RANDOM_ERROR = "다리 정보는 U(위) 혹은 D(아래)여야 합니다.";

    public static final int UP = 1;
    public static final int DOWN = 0;
    public static final int SMALLEST_BRIDGE = 3;
    public static final int BIGGEST_BRIDGE = 20;
    public static final String RETRY = "R";
    public static final String QUIT = "Q";
    public static final String CAN_CROSS = "O";
    public static final String CANNOT_CROSS = "X";
    public static final String FAIL = "실패";
    public static final String SUCCESS = "성공";
}
