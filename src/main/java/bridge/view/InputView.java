package bridge.view;

import bridge.validator.BridgeSizeValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String REQUEST_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";

    public static int readBridgeSize() {
        System.out.println(REQUEST_BRIDGE_SIZE);
        String input = Console.readLine();
        BridgeSizeValidator.validateBridgeSize(input);
        return Integer.parseInt(input);
    }

    public static String readMoving() {
        return null;
    }

    public static String readGameCommand() {
        return null;
    }
}
