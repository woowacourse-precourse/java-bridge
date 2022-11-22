package bridge.view;

import bridge.message.ErrorMessage;
import bridge.message.Message;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static String bridgeSize;
    private static String moving;
    private static String gameCommand;

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        try {
            ViewMessage.printBridgeSizeInputRequest();
            bridgeSize = Console.readLine();
            Validator.validateBridgeSize(bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
            readBridgeSize();
        }

        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        try {
            ViewMessage.printMovingInputRequest();
            moving = Console.readLine();
            Validator.validateMoving(moving);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
            readMoving();
        }

        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        try {
            ViewMessage.printGameCommandInputRequest();
            gameCommand = Console.readLine();
            Validator.validateGameCommand(gameCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getLocalizedMessage());
            readGameCommand();
        }

        return gameCommand;
    }
}
