package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
	private static final String INPUT_MAKE_BRIDGE_NUMBER = "다리의 길이를 입력해주세요.";
	private static final int MINIMUM_BRIDGE_NUMBER = 3; 
	private static final int MAXIMUM_BRIDGE_NUMBER = 20; 
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
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
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
}
