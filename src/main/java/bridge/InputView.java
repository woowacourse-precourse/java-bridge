package bridge;

import camp.nextstep.edu.missionutils.Console;
import exception.ExceptionHandler;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int size = 0;
        try {
            size = Integer.parseInt(Console.readLine());
            if (!(size >= 3 && size <= 20)) throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 3과 20 사이의 숫자여야 합니다.");
            this.readBridgeSize();
        }
        return size;
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
