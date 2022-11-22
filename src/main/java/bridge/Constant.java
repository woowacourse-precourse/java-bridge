package bridge;

public class Constant {
	public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
	public static final String NUMBER_INPUT_MESSAGE_QUESTION = "다리의 길이를 입력해주세요.";
	public static final String MOVE_INPUT_MESSAGE_QUESTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	public static final String COMMAND_INPUT_MESSAGE_QUESTION = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
	public static final String TOTAL_COUNT = "총 시도한 횟수: ";
	public static final String SUCCESS_MESSAGE = "게임 성공 여부: 성공";
	public static final String FAIL_MESSAGE = "게임 성공 여부: 실패";
	public static final String TOTAL_RESULT = "최종 게임 결과";
	public static final String SPELLING_U = "U";
	public static final String SPELLING_D = "D";
	public static final String SPELLING_R = "R";
	public static final String SPELLING_Q = "Q";
	public static final String CIRCLE = " O ";
	public static final String CROSS = " X ";
	public static final String BLANK = "   ";
	public static final String LINE_BLANK = "\n";
	public static final String FIRST_BRACE = "[";
	public static final String END_BRACE = "]";
	public static final String BOARD = "|";

	public static final int NUMBER_RANGE_THREE = 3;
	public static final int NUMBER_RANGE_TWENTY = 20;
	public static final int INDEX_RESET_NUMBER = -1;

	public static final String NUMBER_OVERLAP_ERROR = "[ERROR] 숫자의 범위는 3~20입니다.";
	public static final String NUMBER_MISSMATCH_ERROR = "[ERROR]자연수를 입력해야 합니다.";
	public static final String SPELLING_MISSMATCH_ERROR = "[ERROR] 영어 대문자를 입력해야 합니다.";
	public static final String SPELLING_U_OR_D_MISSMATCH_ERROR = "[ERROR] U,D 둘 중 하나만 입력해야 합니다.";
	public static final String SPELLING_R_OR_Q_MISSMATCH_ERROR = "[ERROR] R,Q 둘 중 하나만 입력해야 합니다.";

}
