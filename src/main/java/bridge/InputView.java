package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    int bridge_size;
    /**
     * 다리의 길이를 입력받는다.
     */

    public InputView(){
        this.bridge_size = Integer.valueOf(Console.readLine());
    }
    public int readBridgeSize(int bridge_size) {
        return this.bridge_size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
