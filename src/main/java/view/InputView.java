package view;

import camp.nextstep.edu.missionutils.Console;
import utils.Invalidator;

public class InputView {

    public static int readBridgeSize() {
        return Invalidator.isValidBridgeLength(Console.readLine());
    }

    public static String readMoving() {
        return Invalidator.isValidMoveValue(Console.readLine());
    }

    public static String readGameCommand() {
        return Invalidator.isValidRestartValue(Console.readLine());
    }
}
