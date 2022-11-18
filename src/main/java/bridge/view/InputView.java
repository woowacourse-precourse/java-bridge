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
            bridgeSize = getValidBridgeLength();
        }
        return bridgeSize;
    }

    private static int getValidBridgeLength() {
        String input;
        try {
            input = Console.readLine();
            ValidationUtil.isValidBridgeLength(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            input = "-1";
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
            inputKey = getValidMovingKey();
        }
        return inputKey;
    }

    private static String getValidMovingKey() {
        String inputKey;
        try {
            inputKey = Console.readLine();
            ValidationUtil.isUpOrDown(inputKey);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputKey = "";
        }
        return inputKey;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        printMessage(ViewMessage.INPUT_RETRY_OR_QUIT);
        String inputKey = "";
        while (inputKey.isBlank()) {
            inputKey = getValidReadGameCommand();
        }
        return inputKey;
    }

    private static String getValidReadGameCommand() {
        String inputKey;
        try {
            inputKey = Console.readLine();
            ValidationUtil.isRetryOrQuit(inputKey);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputKey = "";
        }
        return inputKey;
    }

    private static void printMessage(ViewMessage... inputStartGame) {
        for (ViewMessage viewMessage : inputStartGame) {
            System.out.println(viewMessage.getValue());
        }
    }
}
