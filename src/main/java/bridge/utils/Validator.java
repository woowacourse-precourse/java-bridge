package bridge.utils;

import bridge.view.InputView;
import camp.nextstep.edu.missionutils.Console;

public class Validator {

    public static String readGameCommand() {
        while (true) {
            try {
                String command = InputView.readGameCommand();
                checkValueOfReadGameCommand(command);
                return command;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static String readBridgeMove() {
        while (true) {
            try {
                String inputBridgeMove = InputView.readMoving();
                checkValueOfReadBridgeMove(inputBridgeMove);
                return inputBridgeMove;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int readBridgeSize() {
        while (true) {
            try {
                String inputBridgeSize = InputView.readBridgeSize();
                checkValueOfReadBridgeSize(inputBridgeSize);
                return Integer.parseInt(inputBridgeSize);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                Console.readLine();
            }
        }
    }

    public static void checkValueOfReadBridgeSize(String value) {
        if (isNumeric(value))
            throw new IllegalArgumentException(ErrorMsgs.ERROR_BRIDGE_SIZE_NOT_INT);
        int sInt = Integer.parseInt(value);
        if (sInt < 3 || sInt > 20)
            throw new IllegalArgumentException(ErrorMsgs.ERROR_BRIDGE_SIZE_LOW);
    }

    public static boolean isNumeric(String s) {
        return s == null || !s.matches("[-+]?\\d*\\.?\\d+");
    }

    public static void checkValueOfReadBridgeMove(String value) {
        if (!value.equals("U") && !value.equals("D"))
            throw new IllegalArgumentException(ErrorMsgs.ERROR_BRIDGE_MOVE_TYPE);
    }

    public static void checkValueOfReadGameCommand(String value) {
        if (!value.equals("R") && !value.equals("Q"))
            throw new IllegalArgumentException(ErrorMsgs.ERROR_COMMAND_TYPE);
    }
}
