package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Message;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.printf(Message.INPUT_BRIDGE_LENGTH.get());
        String bridgeLength  = Console.readLine();
        return Integer.parseInt(bridgeLength);

    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        return null;
    }
}
