package bridge.view;

import static bridge.controller.Constant.*;
import static bridge.view.Validator.*;

import java.util.NoSuchElementException;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public int readBridgeSize() {
		System.out.println(SIZE_INPUT);
		int size;
		try {
			size = Integer.parseInt(Console.readLine());
			isSizeValidate(size);
		} catch (NoSuchElementException exception) {
			throw new IllegalArgumentException(INVALID_INPUT);
		}
		return size;
	}

	public String readMoving() {
		System.out.println(MOVE_INPUT);
		String input = Console.readLine();
		isMoveValidate(input);
		return input;
	}

	public String readGameCommand() {
		System.out.println(COMMAND_INPUT);
		String command = Console.readLine();
		isCommandValidate(command);
		return command;
	}
}
