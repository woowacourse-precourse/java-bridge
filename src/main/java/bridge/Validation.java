package bridge;

public class Validation {
    private final static String ERROR_MESSAGE = "[ERROR] ";
    private final static String NOT_BRIDGE_INPUT_TYPE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    void isInputType(String value) {
        try {
            Integer.parseInt(value);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + NOT_BRIDGE_INPUT_TYPE);
        }
    }

}
