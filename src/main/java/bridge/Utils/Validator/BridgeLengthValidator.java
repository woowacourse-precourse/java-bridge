package bridge.Utils.Validator;

public class BridgeLengthValidator {

    private static final String NUMBER_PATTERN = "-?\\d+";
    private static final String ERROR_MESSAGE_NOT_NUMBER = "[ERROR] 입력값이 숫자가 아닙니다.";
    private static final String ERROR_MESSAGE_BRIDGE_LENGTH = "[ERROR] 다리의 길이가 3이상 20이하가 아닙니다.";

    private static final int BRIDGE_MIN_LENGTH = 3;
    private static final int BRIDGE_MAX_LENGTH = 20;
    private static final String INIT_NUMBER = "3";


    /**
     * 다리의 길이 입력값이 맞는지 확인
     *
     * @param input 다리의 길이
     */
    public static String validateBridgeInput(String input) {
        try {
            validateNumber(input);
            validateRange(input);
            return input;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.err.println(e);
            return INIT_NUMBER;
        }
    }


    /**
     * @param input 다리의 길이
     */
    private static void validateNumber(String input) {
        if (!(input.matches(NUMBER_PATTERN))) {
            System.out.println(ERROR_MESSAGE_NOT_NUMBER);
            throw new IllegalArgumentException();
        }
    }

    /**
     * 예외처리(정수변환+ 다리 길이의 범위)
     *
     * @param input 다리의 길이
     */
    private static void validateRange(String input) {
        try {
            int bridgeLength = Integer.parseInt(input);
            bridgeLengthValid(bridgeLength);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.err.println(e);
        }
    }

    /**
     * 예외처리(다리 길이의 범위)
     *
     * @param input 다리의 길이
     */
    private static void bridgeLengthValid(int input) {
        if (!(input >= BRIDGE_MIN_LENGTH && input <= BRIDGE_MAX_LENGTH)) {
            System.out.println(ERROR_MESSAGE_BRIDGE_LENGTH);
            throw new IllegalArgumentException();
        }
    }

}
