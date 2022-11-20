package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class InputView {

	public int readBridgeSize() {
		return validateBridgeSize(Console.readLine());
	}

	public int validateBridgeSize(String userInput) {
		if (!Pattern.matches("^[3-9]|1[0-9]|20$", userInput)) {
			throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
		}

		return Integer.parseInt(userInput);
	}

	public String readMoving() {
		return validateMove(Console.readLine());
	}

	public String validateMove(String userInput) {
		if (!Pattern.matches("^U|D$", userInput)) {
			throw new IllegalArgumentException("위:U, 아래: D");
		}

		if (userInput.equals("U")) {
			return "U";
		}

		return "D";
	}

	public String readGameCommand() {
		return validateRetry(Console.readLine());
	}

	public String validateRetry(String userInput) {
		if (userInput.equals("R")) {
			return "R";
		}

		if (userInput.equals("Q")) {
			return "Q";
		}

		throw new IllegalArgumentException("재시도: R, 종료: Q");
	}
}
