package bridge.view;

import bridge.enums.ViewMessage;
import bridge.util.ValidationUtil;
import camp.nextstep.edu.missionutils.Console;


/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        printMessage(ViewMessage.INPUT_START_GAME, ViewMessage.INPUT_BRIDGE_LENGTH);
        int bridgeSize = -1;
        while (bridgeSize < 0) {
            bridgeSize = getValidBridgeLength(Console.readLine());
        }
        return bridgeSize;
    }

    private static int getValidBridgeLength(String input) {
        try {
            ValidationUtil.isValidBridgeLength(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        printMessage(ViewMessage.INPUT_UP_DOWN);
        String inputKey = "";
        while (inputKey.isBlank()) {
            inputKey = getValidMovingKey(Console.readLine());
        }
        return inputKey;
    }

    private static String getValidMovingKey(String input) {
        try {
            ValidationUtil.isUpOrDown(input);
        } catch (IllegalArgumentException e) {
            printMessage(e.getMessage());
            return "";
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        printMessage(ViewMessage.INPUT_RETRY_OR_QUIT);
        String inputKey = "";
        while (inputKey.isBlank()) {
            inputKey = getValidReadGameCommand(Console.readLine());
        }
        return inputKey;
    }

    private static String getValidReadGameCommand(String input) {
        try {
            ValidationUtil.isRetryOrQuit(input);
        } catch (IllegalArgumentException e) {
            printMessage(e.getMessage());
            return "";
        }
        return input;
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

    private static void printMessage(ViewMessage... inputStartGame) {
        for (ViewMessage viewMessage : inputStartGame) {
            printMessage(viewMessage.getValue());
        }
    }
}
