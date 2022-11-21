package bridge;

import bridge.exception.ExceptionHandler;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public int readBridgeSize() {
        int bridgeSize = 0;

        try {
            bridgeSize = tryReadBridgeSize();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readBridgeSize();
        }

        return bridgeSize;
    }

    public String readMoving() {
        String moving = "";

        try {
            moving = tryReadMoving();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readMoving();
        }

        return moving;
    }

    public String readGameCommand() {
        String command = "";

        try {
            command = tryReadGameCommand();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readGameCommand();
        }

        return command;
    }
    /**
     * 다리의 길이를 입력받는다.
     */
    public int tryReadBridgeSize() {
        System.out.println("\n다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        ExceptionHandler.checkIsDigit(input);

        int bridgeSize = Integer.parseInt(input);
        ExceptionHandler.checkBridgeLength(bridgeSize);

        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String tryReadMoving() {
        System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = Console.readLine();
        ExceptionHandler.checkMoving(moving);

        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String tryReadGameCommand() {
        System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String command = Console.readLine();
        ExceptionHandler.checkCommand(command);

        return command;
    }
}
