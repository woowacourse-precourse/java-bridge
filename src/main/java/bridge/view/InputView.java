package bridge.view;

import bridge.handler.check.CheckHandler;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

	public int readBridgeSize() {
		Message.printMessage(Message.INPUT_BRIDGE_LENGTH);
		return Integer.parseInt(CheckHandler.isBridgeLengthInput(Console.readLine()));
	}

	public String readMoving() {
		Message.printMessage(Message.INPUT_MOVE_COMMAND);
		return CheckHandler.isMoveInput(Console.readLine());
	}

	public String readGameCommand() {
		Message.printMessage(Message.INPUT_GAME_COMMAND);
		return CheckHandler.isGameCommandInput(Console.readLine());
	}

}
