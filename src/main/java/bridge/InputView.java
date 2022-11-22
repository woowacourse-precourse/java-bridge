package bridge;

import bridge.domain.BridgeValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
	private static final String INPUT_MAKE_BRIDGE_NUMBER = "다리의 길이를 입력해주세요.";
	private static final String INPUT_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	private static final String INPUT_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
	
	
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
    	System.out.println(INPUT_MAKE_BRIDGE_NUMBER);
    	String bridgeNumber = Console.readLine();
    	try {
    		BridgeValidator.validateInput(bridgeNumber);
    	} catch(IllegalArgumentException e) {
    		System.out.println(e);
    		return readBridgeSize();
    	}
        return Integer.parseInt(bridgeNumber);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
    	System.out.println(INPUT_MOVING_MESSAGE);
    	String moving = Console.readLine();
    	try {
    		BridgeValidator.validateMovingString(moving);
    	} catch(IllegalArgumentException e) {
    		System.out.println(e);
    		return readMoving();
    	}
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
    	System.out.println(INPUT_RETRY_MESSAGE);
    	String command = Console.readLine();
    	try {
    		BridgeValidator.validateCommand(command);
    	} catch(IllegalArgumentException e) {
    		System.out.println(e);
    		return readGameCommand();
    	}
        return command;
    }
    
    
}
