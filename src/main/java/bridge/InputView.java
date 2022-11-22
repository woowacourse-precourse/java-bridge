package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public int readBridgeSize() {
		try {
			return Integer.parseInt(Console.readLine());
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자만 입력해 주세요.");
		}
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public SideTypes readMoving() {
		final String movement = Console.readLine();
		try {
			return SideTypes.valueOf(movement);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("U 또는 D 문자만 입력해 주세요.");
		}
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public CommandTypes readGameCommand() {
		final String command = Console.readLine();
		try {
			return CommandTypes.valueOf(command);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("R 또는 Q 문자만 입력해 주세요.");
		}
	}

}
