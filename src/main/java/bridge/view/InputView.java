package bridge.view;
import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int size = 0;
        System.out.println("\n다리의 길이를 입력해주세요.");
        try {
            size = Integer.parseInt(readLine());
            return size;
        } catch (Exception e) {
            generateError("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
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
    public void generateError(String message) {
        throw new IllegalArgumentException(message);
    }
}
