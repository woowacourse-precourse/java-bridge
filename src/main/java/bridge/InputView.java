package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해 주세요.");
        String input = Console.readLine();
        validateBridgeSize(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        validateMoving(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        validateGameCommand(input);
        return input;
    }

    public void validateBridgeSize(String input) {
        Validator.validateNumeric(input);
        Validator.validateNumericSize(3, 20, input);
    }

    public void validateMoving(String input) {
        Validator.validateContains(Arrays.asList("U", "D"), input);
    }

    public void validateGameCommand(String input) {
        Validator.validateContains(Arrays.asList("R", "Q"), input);
    }
}
