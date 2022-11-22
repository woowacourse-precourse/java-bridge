package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String ERROR = "[ERROR] ";

    public int readBridgeSize() {
        try {
            System.out.println("다리의 길이를 입력해주세요.");
            return inputSize();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR + e.getMessage());
            return readBridgeSize();
        }
    }

    private int inputSize() {
        int size = parseInt(Console.readLine());
        InputValidator.validateBridgeSize(size);
        return size;
    }

    private int parseInt(String size) {
        InputValidator.validateNumber(size);
        return Integer.parseInt(size);
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
}
