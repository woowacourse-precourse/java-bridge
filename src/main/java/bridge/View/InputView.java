package bridge.View;

import bridge.EnumCollections.InputSystemMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static String readBridgeSize() {
        printSystemMessage(InputSystemMessage.BRIDGE_LENGTH_INPUT);
        return Console.readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        printSystemMessage(InputSystemMessage.MOVE_BRIDGE_INPUT);
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        printSystemMessage(InputSystemMessage.GAME_RESTART_INPUT);
        return Console.readLine();
    }

    public static void printSystemMessage(InputSystemMessage situation) {
        String message = InputSystemMessage.getMessage(situation);
        System.out.println(message);
    }
}
