package service;

import camp.nextstep.edu.missionutils.Console;
import domain.Validate;

public class InputView {
	Validate validate = new Validate();
	
    public int readBridgeSize() {
    	int bridgeSize = Integer.parseInt(Console.readLine());
    	validate.validateSize(bridgeSize);
    	return bridgeSize;
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
