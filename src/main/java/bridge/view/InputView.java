package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public String readBridgeSize() {
		System.out.println("다리의 길이를 입력해 주세요.");
		return Console.readLine();
	}

	public BridgeSize inputBridgeSize() {
		while (true) {
			try {
				String inputSize = readBridgeSize();
				return new BridgeSize(inputSize);
			} catch (IllegalArgumentException error) {
				System.out.println(error);
			}
		}
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
		return Console.readLine();
	}

	public Moving inputMoving() {
		while (true) {
			try {
				String inputMoving = readMoving();
				return new Moving(inputMoving);
			} catch (IllegalArgumentException error) {
				System.out.println(error);
			}
		}
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		return null;
	}
}
