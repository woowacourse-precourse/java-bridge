package bridge.view;

import static bridge.util.Constant.*;
import static bridge.util.Validator.*;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
        int result = BRIDGE_LENGTH_ERROR;
        while (result == BRIDGE_LENGTH_ERROR) {
            result = bridgeSizeInput();
        }
        System.out.println();
        return result;
    }

    private static int bridgeSizeInput() {
        try {
            String bridgeSize = Console.readLine();
            validateNumericInputType(bridgeSize);
            int parsedBridgeSize = Integer.parseInt(bridgeSize);
            validateBridgeSize(parsedBridgeSize);
            return parsedBridgeSize;
        } catch (IllegalArgumentException e) {
            System.out.println(ERRORMESSAGE + e.getMessage());
        }
        return BRIDGE_LENGTH_ERROR;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        String result = BRIDGE_MOVE_ERROR;
        while (result.equals(BRIDGE_MOVE_ERROR)) {
            result = bridgeMovingInput();
        }
        return result;
    }

    private static String bridgeMovingInput() {
        try {
            String moveto = Console.readLine();
            validateMovingInput(moveto);
            return moveto;
        } catch (IllegalArgumentException e) {
            System.out.println(ERRORMESSAGE + e.getMessage());
        }
        return BRIDGE_MOVE_ERROR;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(INPUT_RESTART_OR_QUIT);
        String command = COMMAND_ERROR;
        while (command.equals(COMMAND_ERROR)) {
            command = gameCommandInput();
        }
        return command;
    }

    private static String gameCommandInput() {
        try {
            String command = Console.readLine();
            validateGameCommandInput(command);
            return command;
        } catch (IllegalArgumentException e) {
            System.out.println(ERRORMESSAGE + e.getMessage());
        }
        return COMMAND_ERROR;
    }
}
