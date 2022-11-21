package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
	private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다";
	private static final String INPUT_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
	private static final String INPUT_MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	private final static int MIN_RANGE = 3;
	private final static int MAX_RANGE = 20;
	private int size;

	public void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return this.size;
	}

	public void viewGameStartMessage() {
		System.out.println(GAME_START_MESSAGE);
	}

	private String readBridgeSize() {
		System.out.println("\n" + INPUT_SIZE_MESSAGE);
		return Console.readLine().replace(" ", "");
	}

	public void checkBridgeValidate() {
		try {
			bridgeNumericValidate();
			bridgeSizeValidate();
		} catch (NumberFormatException exception) {
			System.out.println(ExceptionMessage.NOT_NUMBER.getExceptionMessage());
			checkBridgeValidate();
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
			checkBridgeValidate();
		} 
	}

	private void bridgeNumericValidate() throws NumberFormatException{
		size = convertStringToInt();
		setSize(size);
	}

	private void bridgeSizeValidate() {
		int size = Integer.parseInt(readBridgeSize());
		if (!(size >= MIN_RANGE && size <= MAX_RANGE)) {
			throw new IllegalArgumentException(ExceptionMessage.NOT_SIZE_RANGE.getExceptionMessage());
		}
	}

	private int convertStringToInt() {
		int input = Integer.parseInt(readBridgeSize());
		return input;
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		System.out.println("\n" +INPUT_MOVE_MESSAGE);
		return Console.readLine().replace(" ", "");
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		return null;
	}
}
