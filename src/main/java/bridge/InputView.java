package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = readLine();
        String onlyNumber = input.replaceAll("[^0-9]", "");
        if (input.length() != onlyNumber.length()) {
            throw new IllegalArgumentException();
        }
        int size = Integer.parseInt(input);
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException();
        }
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        if (true) {
            throw new IllegalArgumentException();
        }
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        if (true) {
            throw new IllegalArgumentException();
        }
        return null;
    }
}
