package bridge;

import bridge.enums.UpDown;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Validation {
    /**
     *
     * */
    public static void validateObjectNull(Object object) {
        if (Objects.isNull(object)) {
            System.out.println("[ERROR] Null 객체는 유효하지 않습니다.");
            throw new NullPointerException();
        }
    }

    /**
     * input의 Type이 정수인지 확인
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
     * input의 범위가 원하는 값 사이인지 확인
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
     * Up, Down 선택에서 input의 커멘드가 정상적인 커멘드 인지 확인
     * @param input 사용자에게 입력받는 이동할 칸
     */
    public static void validateMoveValid(String input) {
        if (!(input.equals(UpDown.UP.label()) || input.equals(UpDown.DOWN.label()))) {
            System.out.println("[ERROR] 입력한 칸이 유효하지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

    /**
     * Retry, Quit 선택에서 input의 커멘드가 정상적인 커멘드 인지 확인
     * @param input 사용자에게 입력받는 재시도 여부
     */
    public static void validateRetryValid(String input) {
        if (!(input.equals(Constant.retryCommand) || input.equals(Constant.quitCommand))) {
            System.out.println("[ERROR] 유효하지 않은 명령어 입니다.");
            throw new IllegalArgumentException();
        }
    }
}
