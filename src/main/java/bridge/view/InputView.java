package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 20;
    private static final String SIZE_ERROR = "다리 길이는 " + MIN_SIZE + "부터 " + MAX_SIZE + "까지 가능합니다.";
    private static final String NUMBER_FORMAT_ERROR = "숫자가 아닙니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return 0;
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

    private int checkSize(int size) {
        if (size < MIN_SIZE || MAX_SIZE < size) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
        return size;
    }

    private int convert(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
    }

    private String input() {
        return Console.readLine();
    }
}
