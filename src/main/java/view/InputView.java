package view;

import camp.nextstep.edu.missionutils.Console;
import util.Constants;

public class InputView {

    public int readBridgeSize() {
        try {
            OutputView.printBridgeSize();
            int size = validateIsNumeric(Console.readLine());
            validateCorrectRange(size);
            return size;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    public int validateIsNumeric(String inputSize) throws IllegalArgumentException {
        if (!inputSize.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 3~20 사이의 양의 정수를 입력해주세요");
        }
        return Integer.parseInt(inputSize);
    }

    private void validateCorrectRange(int size) {
        if (size < Constants.MIN_SIZE || size > Constants.MAX_SIZE) {
            throw new IllegalArgumentException("[ERROR] 3~20 사이의 양의 정수를 입력해주세요");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            OutputView.printToChoicePlace();
            String upOrDown = Console.readLine();
            validateCorrectMoving(upOrDown);
            return upOrDown;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    private void validateCorrectMoving(String choice) {
        if (!(choice.equals(Constants.UP)) && !(choice.equals(Constants.DOWN))) {
            throw new IllegalArgumentException("[ERROR] U 또는 D 문자만 입력해주세요");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        try {
            OutputView.printChoiceRetry();
            String quick = Console.readLine();
            validateCorrectRetry(quick);
            return quick;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
    }

    private static void validateCorrectRetry(String choice) {
        if (!(choice.equals(Constants.RESTART)) && !(choice.equals(Constants.EXIT))) {
            throw new IllegalArgumentException("[ERROR] R 또는 Q 문자만 입력해주세요");
        }
    }
}