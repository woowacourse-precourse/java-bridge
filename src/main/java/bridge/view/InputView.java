package bridge.view;

import static bridge.view.Validator.*;

import java.util.NoSuchElementException;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public int readBridgeSize() {
		int size;
		try {
			size = Integer.parseInt(Console.readLine());
			isSizeValidate(size);
		} catch (NoSuchElementException exception) {
			System.out.println(INVALID_INPUT);
			throw new IllegalArgumentException();
		}
		return size;
	}

	public String readMoving() {
		String input = Console.readLine();
		isMoveValidate(input);
		return input;
	}

	public String readGameCommand() {
		String command = Console.readLine();
		isCommandValidate(command);
		return command;
	}
}
