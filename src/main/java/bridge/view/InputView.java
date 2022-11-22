package bridge.view;

import bridge.validation.Exception;

import bridge.constant.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;
import bridge.constant.BridgeGameInfo;

public class InputView {

    private static String input() {
        return Console.readLine();
    }

    public static int readBridgeSize() {
        System.out.println(BridgeGameInfo.INPUT_BRIDGE_SIZE.message);
        String input = input();

        Exception.checkIsNumberException(input);
        Exception.checkRangeException(input);

        return Integer.parseInt(input);
    }

    public static String readMoving() throws IllegalArgumentException {
        System.out.println(BridgeGameInfo.SELECT_UP_DOWN.message);
        String input = input();

        Exception.checkCorrectInputUpDown(input);

        return input;
    }

    public static String readGameCommand() throws IllegalArgumentException {
        System.out.println(BridgeGameInfo.RESTART.message);
        String input = input();

        Exception.checkCorrectInputQuitRestart(input);

        return input;
    }
}
