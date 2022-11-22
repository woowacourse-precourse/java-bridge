package view;

import camp.nextstep.edu.missionutils.Console;
import domain.Message;
import exception.BridgeException;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static BridgeException bridgeException = new BridgeException();

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(Message.INPUT_BRIDGE_LENGTH.get());
        String bridgeLength = Console.readLine();
        int bridgeLen = bridgeException.validateBridgeSize(bridgeLength);
        return bridgeLen;

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
