package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public int readBridgeSize() {
		return Integer.parseInt(Console.readLine());
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		String moveInput = Console.readLine();

		if (moveInput.equals("U") || moveInput.equals("D")) {
			return moveInput;
		}
		throw new IllegalArgumentException("U or D를 입력하세요");
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		String retryInput = Console.readLine();

		if (retryInput.equals("R") || retryInput.equals("Q")) {
			return retryInput;
		}
		throw new IllegalArgumentException("R or Q를 입력하세요");
	}
}
