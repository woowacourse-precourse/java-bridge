package bridge.view;
import bridge.domain.Message;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static String readBridgeSize() {
        System.out.printf(Message.START_GAME.get());
        System.out.printf(Message.INPUT_BRIDGE_SIZE.get());
        return Console.readLine();
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.printf(Message.INPUT_DIRECTION.get());
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.printf(Message.INPUT_RETRY_GAME.get());
        return Console.readLine();
    }
}
