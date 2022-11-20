package service;

import camp.nextstep.edu.missionutils.Console;
import domain.Validate;

public class InputView {
	Validate validate = new Validate();

	public int readBridgeSize() {
		String bridgeSize = Console.readLine();
		validate.validateSize(bridgeSize);
		return Integer.parseInt(bridgeSize);
	}

	public String readMoving() {
		String move = Console.readLine();
		validate.validateMove(move);
		return move;
	}

	public String readGameCommand() {
		String gameCommand = Console.readLine();
		validate.validateGameCommand(gameCommand);
		return gameCommand;
	}
}
