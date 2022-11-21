package bridge.view;

import bridge.constant.Constant;
import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException{
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        validateSizeType(input);
        validateSizeRange(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        validateMoveValid(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        validateRetryValid(input);
        return input;
    }

    /**
     * @param input 사용자에게 입력받는 다리의 길이
     */
    private void validateSizeType(String input) {
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
    private void validateSizeRange(String input) {
        int inputNumber = Integer.parseInt(input);
        if (inputNumber < Constant.minBridgeLength || inputNumber > Constant.maxBridgeLength) {
            System.out.println("[ERROR] 입력한 size의 범위가 유효하지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

    /**
     * @param input 사용자에게 입력받는 이동할 칸
     */
    private void validateMoveValid(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            System.out.println("[ERROR] 입력한 칸이 유효하지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

    /**
     * @param input 사용자에게 입력받는 재시도 여부
     */
    private void validateRetryValid(String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            System.out.println("[ERROR] 유효하지 않은 명령어 입니다.");
            throw new IllegalArgumentException();
        }
    }

}
