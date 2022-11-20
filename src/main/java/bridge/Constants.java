package bridge;

public final class Constants {
	public static final String UP = "U";
	public static final String DOWN = "D";

	public static final String O = "O";
	public static final String X = "X";
	public static final String SPACE = " ";

	public static final String START = "[ ";
	public static final String MIDDLE = " | ";
	public static final String END = " ]";

	public static final String MESSAGE_START = "다리 건너기 게임을 시작합니다.";
	public static final String MESSAGE_BRIDGE_SIZE = "\n다리의 길이를 입력해주세요.";
	public static final String MESSAGE_WANNA_MOVE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
	public static final String MESSAGE_WANNA_RESTART = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

	public static final String ERROR_WRONG_SIZE = "\n[ERROR] 3이상 20이하의 정수를 입력하시오.";
	public static final String ERROR_WRONG_BRIDGE_VALUE = "\n[ERROR] U 또는 D를 입력하시오.";
}
