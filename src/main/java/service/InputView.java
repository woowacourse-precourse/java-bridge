package service;

import camp.nextstep.edu.missionutils.Console;
import domain.Validate;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
	Validate validate = new Validate();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
    	String bridgeSize = Console.readLine();
		validate.validateSize(bridgeSize);
		return Integer.parseInt(bridgeSize);
	}

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
    	String move = Console.readLine();
		validate.validateMove(move);
		return move;
	}


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
    	String gameCommand = Console.readLine();
		validate.validateGameCommand(gameCommand);
		return gameCommand;
	}
}