package bridge;

import static bridge.Constants.ERROR_WRONG_BRIDGE_VALUE;
import static bridge.Constants.ERROR_WRONG_SIZE;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * 패키지 변경 ㅇ
 * 함수 인자, 이름, 리턴 변경 ㅇ
 * 필요한 메서드 추가 ㅇ
 */
public class InputView {

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public int readBridgeSize() {
		BridgeSize bridgeSize;
		
		while (true) {
			try {
				bridgeSize = new BridgeSize(readLine());
			} catch (IllegalArgumentException illegalArgumentException) {
				System.out.println(ERROR_WRONG_SIZE);
				continue;
			}
			return bridgeSize.getSize();
		}
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		while (true) {
			String input;
			try {
				input = readLine();
				checkInput(input);
			} catch (IllegalArgumentException illegalArgumentException) {
				System.out.println(ERROR_WRONG_BRIDGE_VALUE);
				continue;
			}
			return input;
		}
	}

	private void checkInput(String input) {
		if (!input.equals("U") && !input.equals("D")){
			throw new IllegalArgumentException();
		}
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		return null;
	}
}
