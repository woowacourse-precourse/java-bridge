package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws NumberFormatException {
        String readLine = Console.readLine();
        int size = Integer.parseInt(readLine);
        if (!correctBridgeSize(size)) {
            throw new IllegalArgumentException("[ERROR] 3 이상 20 이하의 숫자를 입력하세요");
        }
        return size;
    }

    private boolean correctBridgeSize(int size) {
        return size >= 3 && size <= 20;
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
