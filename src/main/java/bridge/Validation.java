package bridge;

import bridge.constant.Constant;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Validation {
    public static void validateObjectNull(Object object) {
        if (Objects.isNull(object)) {
            System.out.println("[ERROR] Null 객체는 유효하지 않습니다.");
            throw new NullPointerException();
        }
    }

    /**
     * @param input 사용자에게 입력받는 다리의 길이
     */
    public static void validateSizeType(String input) {
        List<String> inputSplit = Arrays.asList(input.split(""));
        boolean typeValid = inputSplit.stream().anyMatch(i -> Character.isDigit(i.charAt(0)));
        if (typeValid == false) {
            System.out.println("[ERROR] 입력한 size의 타입이 유효하지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

    /**
     * @param input 사용자에게 입력받는 다리의 길이
     */
    public static void validateSizeRange(String input) {
        int inputNumber = Integer.parseInt(input);
        if (inputNumber < Constant.minBridgeLength || inputNumber > Constant.maxBridgeLength) {
            System.out.println("[ERROR] 입력한 size의 범위가 유효하지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

    /**
     * @param input 사용자에게 입력받는 이동할 칸
     */
    public static void validateMoveValid(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            System.out.println("[ERROR] 입력한 칸이 유효하지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

    /**
     * @param input 사용자에게 입력받는 재시도 여부
     */
    public static void validateRetryValid(String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            System.out.println("[ERROR] 유효하지 않은 명령어 입니다.");
            throw new IllegalArgumentException();
        }
    }
}
