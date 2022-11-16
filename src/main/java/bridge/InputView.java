package bridge;

import static camp.nextstep.edu.missionutils.Console.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String inputSize = readLine();

        return Integer.parseInt(inputSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public int readMoving() {
        String move = readLine();
        if (move.equals("U"))
            return 1;
        if (move.equals("D"))
            return 0;
        throw new IllegalArgumentException();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String reply = readLine();

        return reply;
    }
}
