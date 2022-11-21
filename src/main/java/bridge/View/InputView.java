package bridge.View;

import bridge.Message.Error;
import bridge.Message.Message;
import camp.nextstep.edu.missionutils.Console;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        System.out.println(Message.INPUT_BRIDGE_LENGTH);
        String length = Console.readLine();
        System.out.println();
        try {
            return Integer.parseInt(length);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException(Error.WRONG_BRIDGE_NUMBER);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Message.CHOOSE_MOVE_DIRECTION);
        String direction = Console.readLine();
        return direction;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(Message.CHOOSE_RETRY);
        String retry = Console.readLine();
        return retry;
    }
}
