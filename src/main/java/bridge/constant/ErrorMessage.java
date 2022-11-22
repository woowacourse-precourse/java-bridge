package bridge.constant;

public class ErrorMessage {
	private static final String PREV = "[ERROR] ";
    public static final String BRIDGE_SIZE_IS_NOT_IN_RANGE = PREV + "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String BRIDGE_SIZE_IS_NOT_NUMBER = PREV + "다리 길이는 숫자여야합니다.";
    public static final String BRIDGE_MARK_TO_MOVE_IS_NOT_IN_RANGE = PREV + "이동할 칸은 U나 D여야합니다.";
	public static final String RETRY_COMMAND_IS_NOT_IN_RANGE = PREV + "재시작 여부는 R이나 D여야합니다.";
}
