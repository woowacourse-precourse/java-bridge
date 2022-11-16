package view;

public class InputViewConstants {
	public static final String REGEX_ALL_NUMERIC = "[+-]?\\d*(\\.\\d+)?";

	public static final String ERROR_MESSAGE_NON_NUMERIC = "[ERROR] 다리 길이는 숫자만 입력해야 합니다.";
	public static final String ERROR_MEESAGE_OUT_OF_RANGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

	public static final int MIN_BRIDGE_SIZE = 3;
	public static final int MAX_BRIDGE_SIZE = 20;

	private InputViewConstants() {

	}
}
