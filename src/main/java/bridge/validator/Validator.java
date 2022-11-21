package bridge.validator;

import camp.nextstep.edu.missionutils.Console;

public class Validator {
    private final static String ERROR = "[ERROR]";
    private final static String PUT_INTEGER = "숫자만 입력 가능합니다.";
    private final static String WRONG_SIZE = "다리 길이는 3부터 20 사이의 정수입니다.";
    public static String inputNum = null;

    public static void checkBridgeSizeInputInteger(String input) {
        try {
            if (input != null && !input.matches("-?\\d+")) {
                System.out.println("다리길이를 다시 입력하세요");
                throw new IllegalArgumentException(ERROR + PUT_INTEGER);

            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(ERROR + PUT_INTEGER + "다리길이를 다시 입력하세요");
            inputNum = Console.readLine();
        }
    }

    public static void checkBridgeSize(int input) {
        try {
            if (input < 3 || input > 20) {
                throw new IllegalArgumentException(ERROR + " " + WRONG_SIZE);
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(ERROR + " " + WRONG_SIZE);
        }

    }
}
