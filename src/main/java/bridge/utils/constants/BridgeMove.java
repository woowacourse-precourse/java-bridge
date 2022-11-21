package bridge.utils.constants;

public class BridgeMove {
    public static final int START_INDEX = -1;
    public static final int GO_STEP = 1;
    public static final int BACK_STEP = -1;
    public static final String READ_BRIDGE_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String ERROR_BRIDGE_MOVE_MESSAGE = "[ERROR] 이동할 수 있는 칸은 U 또는 D의 문자입니다.";
    public static final String BRIDGE_MOVE_REGEX = "^U{1}$|^D{1}$";
}
