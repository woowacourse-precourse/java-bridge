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
		int bridgeSize = convertBridgeSize(stringBridgeSize);
		checkBridgeSizeRange(bridgeSize);
		return bridgeSize;
	}

	private int convertBridgeSize(String stringBridgeSize) {
		int convertSize;
		try {
			convertSize = Integer.parseInt(stringBridgeSize);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 숫자 외에 입력해선 안됩니다.");
		}
		return convertSize;
	}

	private void checkBridgeSizeRange(int bridgeSize) {
		if (bridgeSize < 3 || bridgeSize > 20) {
			throw new IllegalArgumentException("[ERROR] 다리의 길이는 3이상 20이하의 수만 입력해주세요.");
		}
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		return null;
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		return null;
	}
}
