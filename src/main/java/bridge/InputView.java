package bridge;

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
    public int readBridgeSize() {
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
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
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
        if (inputNumber < 3 || inputNumber > 20) {
            System.out.println("[ERROR] 입력한 size의 범위가 유효하지 않습니다.");
            throw new IllegalArgumentException();
        }
    }

}
