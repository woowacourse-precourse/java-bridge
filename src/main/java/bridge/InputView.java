package bridge;

import static bridge.Constants.*;

import bridge.validator.BridgeLengthValidate;
import bridge.validator.CommandValidate;
import camp.nextstep.edu.missionutils.Console;

/**
 * 제공된 InputView 클래스를 활용해 구현해야 한다.
 * InputView의 패키지는 변경할 수 있다.
 * InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public int readBridgeSize() {
		System.out.println(INPUT_BRIDGE_LENGTH);
		String userInput = Console.readLine();
		checkBridgeSize(userInput);
		return Integer.parseInt(userInput);
	}

	private static void checkBridgeSize(String userInput) {
		BridgeLengthValidate.validateNumber(userInput);
		BridgeLengthValidate.validateRange(userInput);
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		System.out.println(INPUT_DIRECTION);
		String userInput = Console.readLine();
		checkMoving(userInput);
		return userInput;
	}

	private static void checkMoving(String userInput) {
		CommandValidate.validateCharacter(userInput);
		CommandValidate.validateEnglish(userInput);
		CommandValidate.validateUpperCase(userInput);
		CommandValidate.validateExactCharacterUD(userInput);
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		System.out.println(INPUT_RESTART_OR_QUIT);
		String userInput = Console.readLine();
		checkGameCommand(userInput);
		return userInput;
	}

	private static void checkGameCommand(String userInput) {
		CommandValidate.validateCharacter(userInput);
		CommandValidate.validateEnglish(userInput);
		CommandValidate.validateUpperCase(userInput);
		CommandValidate.validateExactCharacterRQ(userInput);
	}
}
