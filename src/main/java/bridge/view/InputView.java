package bridge.view;

import bridge.util.Constant;
import bridge.util.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(Constant.INPUT_BRIDGE_SIZE);
        String bridgeSize = Console.readLine();
        Validator.validateNumericInputType(bridgeSize);
        int size = Integer.parseInt(bridgeSize);
        System.out.println();
        return size;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        return Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(Constant.INPUT_RESTART_OR_QUIT);
        return Console.readLine();
    }
}
