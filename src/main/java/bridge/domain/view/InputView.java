package bridge.domain.view;

import bridge.domain.BridgeSize;

import static bridge.Constants.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * 패키지 변경 ㅇ
 * 함수 인자, 이름, 리턴 변경 ㅇ
 * 필요한 메서드 추가 ㅇ
 */
public class InputView {

	static public int readBridgeSize() {
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

	static public String readMoving() {
		while (true) {
			String input;
			try {
				input = readLine();
				checkWayInput(input);
			} catch (IllegalArgumentException illegalArgumentException) {
				System.out.println(ERROR_WRONG_BRIDGE_VALUE);
				continue;
			}
			return input;
		}
	}

	static private void checkWayInput(String input) {
		if (!input.equals(UP) && !input.equals(DOWN)){
			throw new IllegalArgumentException();
		}
	}

	static public String readGameCommand() {
		while (true) {
			String input;
			try {
				input = readLine();
				checkRetryInput(input);
			} catch (IllegalArgumentException illegalArgumentException) {
				System.out.println(ERROR_WRONG_RETRY);
				continue;
			}
			return input;
		}
	}

	static private void checkRetryInput(String input) {
		if (!input.equals(RETRY) && !input.equals(QUIT)){
			throw new IllegalArgumentException();
		}
	}
}
