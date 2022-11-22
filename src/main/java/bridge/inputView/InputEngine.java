package bridge.inputView;

import bridge.inputView.exception.IllegalReadBridgeSizeException;
import bridge.inputView.exception.IllegalReadGameCommandException;
import bridge.inputView.exception.IllegalReadMovingException;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class InputEngine {
    private static final int SIZE = 1;
    private static final int BRIDGE_MIN_SIZE = 3;
    private static final int BRIDGE_MAX_SIZE = 20;

    static int readBridgeSize() {
        final int command = Integer.parseInt(readLine());
        validateElseThrow(BRIDGE_MIN_SIZE <= command && command <= BRIDGE_MAX_SIZE,
                IllegalReadBridgeSizeException::new);
        return command;
    }

    static String readMoving() {
        final String command = readLine();
        validateElseThrow(command.length() == SIZE, IllegalReadMovingException::new);
        validateElseThrow(command, Arrays.asList("U", "D"), IllegalReadMovingException::new);
        return command;
    }

    static String readGameCommand() {
        final String command = readLine();
        validateElseThrow(command.length() == SIZE, IllegalReadGameCommandException::new);
        validateElseThrow(command, Arrays.asList("R", "Q"), IllegalReadGameCommandException::new);
        return command;
    }

    private static void validateElseThrow(boolean isNotError, Supplier<? extends RuntimeException> exception) {
        if (isNotError) {
            return;
        }
        throw exception.get();
    }

    private static void validateElseThrow(String readLine, List<String> keys,
                                          Supplier<? extends RuntimeException> exception) {
        for (String key : keys) {
            if (readLine.equals(key)) {
                return;
            }
        }
        throw exception.get();
    }

    private static String readLine() {
        return Console.readLine();
    }
}
