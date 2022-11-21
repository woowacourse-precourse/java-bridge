package bridge.io;

import camp.nextstep.edu.missionutils.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println(MSG.INPUT_BRIDGE_SIZE.message);
        String bridgeSizeCommand = Console.readLine();
        try {
            validateBridgeSize(bridgeSizeCommand);
            return Integer.parseInt(bridgeSizeCommand);
        }catch (IllegalArgumentException e) {
            System.out.println(MSG.ERR_001.message);
            return readBridgeSize();
        }
    }
    private static void validateBridgeSize(String bridgeSizeCommand) {
        String regex = "^[3-9]$|^[1][0-9]$|^20$";
        if (!bridgeSizeCommand.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        System.out.println(MSG.INPUT_MOVING.message);
        String movingCommand = Console.readLine();
        try {
            validateMoving(movingCommand);
            return movingCommand;
        }catch (IllegalArgumentException e) {
            System.out.println(MSG.ERR_002.message);
            return readMoving();
        }
    }
    private static void validateMoving(String movingCommand) {
        String regex = "[UD]";
        if (!movingCommand.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        System.out.println(MSG.INPUT_GAME.message);
        String gameCommand = Console.readLine();
        try {
            validateGame(gameCommand);
            return gameCommand;
        }catch (IllegalArgumentException e) {
            System.out.println(MSG.ERR_003.message);
            return readGameCommand();
        }
    }
    private static void validateGame(String gameCommand) {
        String regex = "[RQ]";
        if (!gameCommand.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }
}
