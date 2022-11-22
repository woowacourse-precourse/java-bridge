package bridge;

public final class Constants {
	public static final int SIZE_MIN = 3;
	public static final int SIZE_MAX = 20;
	public static final String UP = "U";
	public static final String DOWN = "D";
	public static final String RETRY = "R";
	public static final String QUIT = "Q";

	public static final String O = "O";
	public static final String X = "X";
	public static final String SPACE = " ";
	public static final String START = "[ ";
	public static final String MIDDLE = " | ";
	public static final String END = " ]";

	public static final String SUCCESS = "성공";
	public static final String FAIL = "실패";

	public static final String MESSAGE_START = "다리 건너기 게임을 시작합니다.";
	public static final String MESSAGE_BRIDGE_SIZE = "\n다리의 길이를 입력해주세요.";
	public static final String MESSAGE_WANNA_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	public static final String MESSAGE_WANNA_RESTART = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
	public static final String MESSAGE_RESULT_TITLE = "최종 게임 결과";
	public static final String MESSAGE_RESULT = "게임 성공 여부: ";
	public static final String MESSAGE_TRY = "총 시도한 횟수: ";

	public static final String ERROR_WRONG_SIZE = "\n[ERROR] 3이상 20이하의 정수를 입력하시오.";
	public static final String ERROR_WRONG_BRIDGE_VALUE = "\n[ERROR] U 또는 D를 입력하시오.";
	public static final String ERROR_WRONG_RETRY = "\n[ERROR] R 또는 Q를 입력하시오.";
}
