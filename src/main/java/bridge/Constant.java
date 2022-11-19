package bridge;

public class Constant {
    public static final String ERROR = "[ERROR] ";

    public static final Integer MIN_BRIDGE_SIZE = 3;
    public static final Integer MAX_BRIDGE_SIZE = 20;
    public static final String UP = "U";
    public static final String DOWN = "D";

    public static final String READ_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String READ_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    public static final String BRIDGE_SIZE_ERROR = ERROR + "다리 길이는 " +
            MIN_BRIDGE_SIZE + "부터 " + MAX_BRIDGE_SIZE + " 사이의 숫자여야 합니다.";
    public static final String MOVING_ERROR = ERROR + "이동할 칸을 U 또는 D로 입력해주세요.";

}
