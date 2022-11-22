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
		int bridgeSize = 0;
		Print.startBridgeGame();
		while (bridgeSize == 0) {
			try {
				bridgeSize = repeatReadBridgeSize();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return bridgeSize;
	}

	private int repeatReadBridgeSize() {
		Print.inputBridgeSize();
		String stringBridgeSize = Console.readLine();
		int bridgeSize = Validation.validationConvertBridgeSize(stringBridgeSize);
		Validation.validationCheckBridgeSizeRange(bridgeSize);
		return bridgeSize;
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		Print.selectBlock();
		String upDown = "";
		while (!upDown.equals("U") && !upDown.equals("D")) {
			try {
				upDown = Console.readLine();
				Validation.validationUpOrDown(upDown);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return upDown;
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		Print.restartOrQuit();
		String restartOrQuit = "";
		while (!restartOrQuit.equals("Q") && !restartOrQuit.equals("R")) {
			try {
				restartOrQuit = Console.readLine();
				Validation.validationRestartOrQuit(restartOrQuit);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		return restartOrQuit;
	}
}
