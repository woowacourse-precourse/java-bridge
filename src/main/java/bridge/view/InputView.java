package bridge.view;

import bridge.BridgeSize;

import static bridge.Constants.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

	public static int readBridgeSize() {
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

	public static String readMoving() {
		String input;
		while (true) {
			try {
					input = checkWayInput(readLine());
			} catch (IllegalArgumentException illegalArgumentException) {
					System.out.println(ERROR_WRONG_BRIDGE_VALUE);
					continue;
			}
			return input;
		}
	}

	private static String checkWayInput(String input) {
		if (!input.equals(UP) && !input.equals(DOWN)) {
			throw new IllegalArgumentException();
		}
		return input;
	}

	public static String readGameCommand() {
		String input;
		while (true) {
			try {
					input = checkRetryInput(readLine());
			} catch (IllegalArgumentException illegalArgumentException) {
					System.out.println(ERROR_WRONG_RETRY);
					continue;
			}
			return input;
		}
	}

	private static String checkRetryInput(String input) {
		if (!input.equals(RETRY) && !input.equals(QUIT)) {
			throw new IllegalArgumentException();
		}
		return input;
	}
}
