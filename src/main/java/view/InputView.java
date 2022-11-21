package view;

import camp.nextstep.edu.missionutils.Console;
import util.Validator;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

	/**
	 * 다리의 길이를 입력받는다.
	 */
	public int readBridgeSize() {
		System.out.println(ViewConstant.ASKING_INPUT_BRIDGE_SIZE_MESSAGE);
		String size = Console.readLine();
		Validator.validateSizeIsNaturalNumber(size);
		System.out.println();
		return Integer.parseInt(size);
	}

	/**
	 * 사용자가 이동할 칸을 입력받는다.
	 */
	public String readMoving() {
		System.out.println(ViewConstant.ASKING_CHOOSE_MOVING_MESSAGE);
		String moving = Console.readLine();
		Validator.validateCapitalLetter(moving);
		return moving;
	}

	/**
	 * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
	 */
	public String readGameCommand() {
		System.out.println(ViewConstant.ASKING_INPUT_RESTART_OR_NOT_MESSAGE);
		String gameCommand = Console.readLine();
		Validator.validateCapitalLetter(gameCommand);
		return gameCommand;
	}
}
