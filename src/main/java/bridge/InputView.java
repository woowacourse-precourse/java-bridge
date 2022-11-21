package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
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

    private int validateIsNumeric(String inputSize) throws IllegalArgumentException {
        if (!inputSize.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 3~20 사이의 양의 정수를 입력해주세요");
        }
        return Integer.parseInt(inputSize);
    }

    private void validateCorrectRange(int size) {
        if (size < 3 || size > 20) {
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
        if (!(choice.equals("U")) && !(choice.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] U 또는 D 문자만 입력해주세요");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}