package bridge.domain;

import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
	private int bridgeLength = 0;
	private String restartOrQuit = "";
	private String upOrDown = "";

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public int readBridgeSize() {
		do {
			System.out.println("\n다리의 길이를 입력해주세요.");
			String bridgeLengthStr = Console.readLine();
			try {
				bridgeSizeExceptionCheck(bridgeLengthStr);
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 다리의 길이는 3이상 20이하의 정수입니다.");
			}
		} while (bridgeLength == 0);
		return this.bridgeLength;
	}

	public void bridgeSizeExceptionCheck(String bridgeLengthStr) {
		String pattern = "^[0-9]+$";
		int bridgeLength = 0;
		if (Pattern.matches(pattern, bridgeLengthStr)) {
			bridgeLength = Integer.parseInt(bridgeLengthStr);
			if (bridgeLength >= 3 && bridgeLength <= 20) {
				this.bridgeLength = bridgeLength;
				return;
			}
		}
		throw new IllegalArgumentException("[ERROR] 다리의 길이는 3이상 20이하의 정수입니다.");
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		do {
			System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
			String tempUpOrDown = Console.readLine();
			try {
				readMovingExceptionCheck(tempUpOrDown);
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] U와 D만 선택하세요.");
			}
		} while (!upOrDown.equals("U") && !upOrDown.equals("D"));
		return upOrDown;
	}

	public void readMovingExceptionCheck(String tempUpOrDown) {
		if (tempUpOrDown.equals("U") || tempUpOrDown.equals("D")) {
			this.upOrDown = tempUpOrDown;
			return;
		}
		this.upOrDown = "";
		throw new IllegalArgumentException("[ERROR] U와 D만 선택하세요.");
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		do {
			System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q");
			String tempRestartOrQuit = Console.readLine();
			try {
				readGameCommandExceptionCheck(tempRestartOrQuit);
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] R와 Q만 선택하세요.");
			}
		} while (!restartOrQuit.equals("R") && !restartOrQuit.equals("Q"));
		return restartOrQuit;
	}

	public void readGameCommandExceptionCheck(String tempRestartOrQuit) {
		if (tempRestartOrQuit.equals("R") || tempRestartOrQuit.equals("Q")) {
			this.restartOrQuit = tempRestartOrQuit;
			return;
		}
		this.restartOrQuit = "";
		throw new IllegalArgumentException("[ERROR] R와 Q만 선택하세요.");
	}

	public String getRestartOrQuit() {
		this.restartOrQuit = "";
		readGameCommand();
		return this.restartOrQuit;
	}
}
