package view;

public class InputViewConstants {
	public static final String MESSAGE_READ_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
	public static final String MESSAGE_READ_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	public static final String MESSAGE_READ_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

	public static final String ERROR_MESSAGE_NON_NUMERIC = "[ERROR] 다리 길이는 숫자만 입력해야 합니다.";
	public static final String ERROR_MESSAGE_OUT_OF_RANGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
	public static final String ERROR_MESSAGE_WRONG_MOVING_INPUT = "[ERROR] 이동할 칸 입력은 U, D만 가능합니다.";
	public static final String ERROR_MESSAGE_WRONG_GAME_COMMAND_INPUT = "[ERROR] 재시작 여부 입력은 R, Q만 가능합니다.";

	public static final int MIN_BRIDGE_SIZE = 3;
	public static final int MAX_BRIDGE_SIZE = 20;

	public static final String MOVING_UP = "U";
	public static final String MOVING_DOWN = "D";

	public static final String GAME_COMMAND_RESTART = "R";
	public static final String GAME_COMMAND_QUIT = "Q";

	private InputViewConstants() {
	}
}
