package bridge;

public class Validation {
    private final static int MIN_BRIDGE_SIZE = 3;
    private final static int MAX_BRIDGE_SIZE = 20;
    private final static String ERROR_MESSAGE = "[ERROR] ";
    private final static String NOT_BRIDGE_INPUT_TYPE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private final static String NOT_BRIDGE_INPUT_RANGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    void totalValidation(String value){
        isInputType(value);
        isInputRange(value);
    }

    void isInputType(String value){
        try {
            Integer.parseInt(value);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + NOT_BRIDGE_INPUT_TYPE);
        }
    }

    void isInputRange(String value){
        int input = Integer.parseInt(value);
        if(input < MIN_BRIDGE_SIZE || input > MAX_BRIDGE_SIZE){
            System.out.println(ERROR_MESSAGE + NOT_BRIDGE_INPUT_RANGE);
        }
    }

}
