package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
	private static final String INPUT_MAKE_BRIDGE_NUMBER = "다리의 길이를 입력해주세요.";
	private static final int MINIMUM_BRIDGE_NUMBER = 3; 
	private static final int MAXIMUM_BRIDGE_NUMBER = 20; 
	private static final String INPUT_MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	private static final String INPUT_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
	
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
    	System.out.println(INPUT_MAKE_BRIDGE_NUMBER);
    	String bridgeNumber = Console.readLine();
    	try {
    		validateInput(bridgeNumber);
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
    		validateMovingString(moving);
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
    		validateCommand(command);
    	} catch(IllegalArgumentException e) {
    		System.out.println(e);
    		return readGameCommand();
    	}
        return command;
    }
    
    private static int validateInput(final String bridgeNumber) {
    	int convertBridgeNumberToInt = Integer.parseInt(validateInteger(bridgeNumber));
    	return validateNumberRange(convertBridgeNumberToInt);
    }
    
    private static String validateInteger(final String bridgeNumber) {
    	if (!bridgeNumber.chars().allMatch(Character::isDigit)) {
			throw new IllegalArgumentException("[ERROR] 숫자를 입력해주셔야 합니다.");
		}
    	return bridgeNumber;
    }
    
    private static int validateNumberRange(final int value) {
		if (value < MINIMUM_BRIDGE_NUMBER || MAXIMUM_BRIDGE_NUMBER < value) {
			throw new IllegalArgumentException("[ERROR] 유효한 숫자 범위는 "
					+ MINIMUM_BRIDGE_NUMBER + "~" + MAXIMUM_BRIDGE_NUMBER + "입니다.");
		}
		return value;
    }
    
    private static String validateMovingString(String moving) {
    	if (moving.equals("U") || moving.equals("D")) {
    		return moving;
    	}
    	throw new IllegalArgumentException("[ERROR] 유효한 입력값은 U 혹은 D 만 가능합니다.");	
    }
    
    private static String validateCommand(String command) {
    	if(command.equals("R") || command.equals("Q")) {
    		return command;
    	}
    	throw new IllegalArgumentException("[ERROR] 유효한 입력값은 R 혹은 Q 만 가능합니다.");	
    }
}
