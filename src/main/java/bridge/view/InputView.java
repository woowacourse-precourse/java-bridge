package bridge.view;

import static bridge.model.constnce.Text.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            System.out.println(BRIDGE_SIZE_MESSAGE);
            return Integer.parseInt(readLine());
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(MOVE_TO_WHERE);
        return readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(RETRY_MESSAGE);
        return readLine();
    }
}
