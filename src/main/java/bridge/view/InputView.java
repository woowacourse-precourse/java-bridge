package bridge.view;

import static java.lang.Integer.parseInt;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_NOT_INTEGER_ERROR = "[ERROR] 생성할 다리의 길이는 정수만 입력이 가능합니다.";
    private static final String INPUT_VALID_RANGE_OF_NUMBER_ERROR = "[ERROR] 3~20사이의 숫자만 입력이 가능합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        processingBridgeSize(input);

        return parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");

        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        return Console.readLine();
    }

    private void processingBridgeSize(String input) {
        try {
            validateInteger(input);
            validateRange(parseInt(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readBridgeSize();
        }
    }

    private void validateInteger(String size) {
        String regex = "^[0-9]+$";

        if (!size.matches(regex)) {
            throw new IllegalArgumentException(INPUT_NOT_INTEGER_ERROR);
        }

    }

    private void validateRange(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(INPUT_VALID_RANGE_OF_NUMBER_ERROR);
        }
    }
}
