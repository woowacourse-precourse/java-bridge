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
        String size = Console.readLine();

        try {
            return checkBrideSizeRange(Integer.parseInt(size));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
        }
        return readBridgeSize();
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

    private int checkBrideSizeRange(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException();
        }

        return size;
    }

}
