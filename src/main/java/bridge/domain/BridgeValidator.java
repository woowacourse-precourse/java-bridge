package bridge.domain;

public class BridgeValidator {
	private static final int MINIMUM_BRIDGE_NUMBER = 3; 
	private static final int MAXIMUM_BRIDGE_NUMBER = 20; 
	private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해주셔야 합니다.";
	private static final String NOT_VALID_MOVING_STRING_ERROR_MESSAGE = "[ERROR] 유효한 입력값은 U 혹은 D 만 가능합니다.";
	private static final String NOT_VALID_RETRY_STRING_ERROR_MESSAGE = "[ERROR] 유효한 입력값은 R 혹은 Q 만 가능합니다.";
	private static final String NOT_VALID_NUMBER_RANGE_ERROR_MESSAGE = 
			"[ERROR] 유효한 숫자 범위는 "+ MINIMUM_BRIDGE_NUMBER + "~" + MAXIMUM_BRIDGE_NUMBER + "입니다.";
	
	public static int validateInput(final String bridgeNumber) {
    	int convertBridgeNumberToInt = Integer.parseInt(validateInteger(bridgeNumber));
    	return validateNumberRange(convertBridgeNumberToInt);
    }
    
	public static String validateInteger(final String bridgeNumber) {
    	if (!bridgeNumber.chars().allMatch(Character::isDigit)) {
			throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
		}
    	return bridgeNumber;
    }
    
	public static int validateNumberRange(final int value) {
		if (value < MINIMUM_BRIDGE_NUMBER || MAXIMUM_BRIDGE_NUMBER < value) {
			throw new IllegalArgumentException(NOT_VALID_NUMBER_RANGE_ERROR_MESSAGE);
		}
		return value;
    }
    
	public static String validateMovingString(String moving) {
    	if (moving.equals("U") || moving.equals("D")) {
    		return moving;
    	}
    	throw new IllegalArgumentException(NOT_VALID_MOVING_STRING_ERROR_MESSAGE);	
    }
    
	public static String validateCommand(String command) {
    	if(command.equals("R") || command.equals("Q")) {
    		return command;
    	}
    	throw new IllegalArgumentException(NOT_VALID_RETRY_STRING_ERROR_MESSAGE);	
    }
}
