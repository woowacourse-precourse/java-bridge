package bridge.view;

import bridge.valid.BridgeValidUtil;
import bridge.enums.BridgeMark;
import bridge.enums.GameCommand;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputView {

    public static final String NUMBER_REGEX = "^[0-9]*$";
    public static final String ERROR_INVALID_BRIDGE_NUMBER = "[ERROR] 다리의 길이는 숫자이어야 합니다.";

    public static int readBridgeSize() {
        String size = Console.readLine();
        try {
            validate(size);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e);
            OutputView.printBridgeSize();
            return readBridgeSize();
        }
        return Integer.parseInt(size);
    }

    private static void validate(String size) {
        validateIsNumber(size);
        BridgeValidUtil.validateSize(Integer.parseInt(size));
    }

    public static void validateIsNumber(String size) {
        if (!isNumber(size)) {
            throw new IllegalArgumentException(ERROR_INVALID_BRIDGE_NUMBER);
        }
    }

    private static boolean isNumber(String size) {
        return Pattern.matches(NUMBER_REGEX, size);
    }

    public static String readMoving() {
        String movingMark = Console.readLine();
        try {
            BridgeMark.validateInput(movingMark);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e);
            OutputView.printMove();
            return readMoving();
        }
        return movingMark;
    }

    public static String readGameCommand() {
        String command = Console.readLine();
        try {
            GameCommand.validateInput(command);
        } catch (IllegalArgumentException e) {
            OutputView.printExceptionMessage(e);
            OutputView.printRestart();
            return readGameCommand();
        }
        return command;
    }
}
