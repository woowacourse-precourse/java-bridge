package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final int MIN_LENGTH_OF_BRIDGE = 3;
    private final int MAX_LENGTH_OF_BRIDGE = 20;
    private final String ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.\n다시 입력해 주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        String checkedInput = receiveInputUntilCondition(input);
        return stringToInteger(checkedInput);
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

    private String receiveInputUntilCondition(String input){
        while ((!isNumber(input))||(!isSizeOfNumber(input))) {
            input = Console.readLine();
        }
        return input;
    }

    private boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE);
            return false;
        }
    }

    private boolean isSizeOfNumber(String input) {
        int number = stringToInteger(input);
        if (MIN_LENGTH_OF_BRIDGE <= number && number <= MAX_LENGTH_OF_BRIDGE) {
            return true;
        }
        System.out.println(ERROR_MESSAGE);
        return false;
    }

    private int stringToInteger(String str) {
        try {
            int number = Integer.parseInt(str);
            return number;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE);
            return 0;
        }
    }
}
