package bridge.view;

import static bridge.view.Error.*;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
	private static final String INPUT_SIZE = "다리의 길이를 입력해주세요.";
	private static final String INPUT_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	private static final String INPUT_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
	private static final int MIN_LENGTH = 3;
	private static final int MAX_LENGTH = 20;

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public int readBridgeSize() {
		try {
			System.out.println(INPUT_SIZE);
			String size = Console.readLine();
			sizeValidate(size);
			return Integer.valueOf(size);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return readBridgeSize();
		}
	}

	private void sizeValidate(String size) {
		if (!size.matches("^[0-9]+$")) {
			throw new IllegalArgumentException(INPUT_ONLY_NUMBERS.getMessage());
		}
		if (Integer.valueOf(size) < MIN_LENGTH || Integer.valueOf(size) > MAX_LENGTH) {
			throw new IllegalArgumentException(INPUT_VALID_LENGTH.getMessage());
		}
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		try {
			System.out.println(INPUT_MOVE);
			String move = Console.readLine();
			moveValidate(move);
			return move;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return readMoving();
		}
	}

	private void moveValidate(String move) {
		if (!move.matches("[UD]")) {
			throw new IllegalArgumentException(INPUT_ONLY_U_OR_D.getMessage());
		}
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		try {
			System.out.println(INPUT_RETRY);
			String gameCommand = Console.readLine();
			gameCommandValidate(gameCommand);
			return gameCommand;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return readGameCommand();
		}
	}

	private void gameCommandValidate(String gameCommand) {
		if (!gameCommand.matches("[RQ]")) {
			throw new IllegalArgumentException(INPUT_ONLY_R_OR_Q.getMessage());
		}
	}
}
