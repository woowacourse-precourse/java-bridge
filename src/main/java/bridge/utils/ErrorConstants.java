package bridge.utils;

public class ErrorConstants {
	private static final String ERROR = "[ERROR] ";

	public static final String ERROR_NOT_NUMBER = ERROR + "다리 길이는 숫자만 입력 가능합니다.";
	public static final String ERROR_OUT_OF_BRIDGE_RANGE = ERROR + "다리 길이는 3 이상 20 이하의 숫자여야 합니다.";
	public static final String ERROR_NOT_U_OR_D = ERROR + "이동할 칸은 'U'(위 칸) 또는 'D'(아래 칸)를 입력해야 합니다.";
	public static final String ERROR_NOT_R_OR_Q = ERROR + "재시도/종료 선택을 위해 'R'(재시작) 또는 'Q'(종료)를 입력해야 합니다.";
}
