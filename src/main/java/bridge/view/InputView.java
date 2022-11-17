package bridge.view;

import bridge.exception.InputExceptionHandler;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public static int readBridgeSize() {
		while (true) {
			OutputView.printBridgeLength();
			try {
				return InputExceptionHandler.checkBridgeSizeForm(Console.readLine());
			} catch (IllegalArgumentException errorMessage) {
				System.out.println(errorMessage.getMessage());
			}
		}
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public static String readMoving() {
		while (true) {
			OutputView.printMoving();
			try {
				return InputExceptionHandler.checkMovingCommand(Console.readLine());
			} catch (IllegalArgumentException errorMessage) {
				System.out.println(errorMessage.getMessage());
			}
		}
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public static String readGameCommand() {
		while (true) {
			OutputView.printRetryMessage();
			try {
				return InputExceptionHandler.checkRetryCommand(Console.readLine());
			} catch (IllegalArgumentException errorMessage) {
				System.out.println(errorMessage.getMessage());
			}
		}
	}
}
