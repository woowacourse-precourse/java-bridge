package bridge.io;

import camp.nextstep.edu.missionutils.*;

public class InputView {

    public static int readBridgeSize() {
        String bridgeSizeCommand = commandForBridgeSize();
        try {
            validateBridgeSize(bridgeSizeCommand);
            return Integer.parseInt(bridgeSizeCommand);
        }catch (IllegalArgumentException e) {
            System.out.println(IO_msg.ERR_001.msg);
            return readBridgeSize();
        }
    }
    private static String commandForBridgeSize() {
        System.out.println(IO_msg.INPUT_BRIDGE_SIZE.msg);
        return Console.readLine();
    }
    private static void validateBridgeSize(String bridgeSizeCommand) {
        String regex = "^[3-9]$|^[1][0-9]$|^20$";
        if (!bridgeSizeCommand.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }


    public static String readMoving() {
        String movingCommand = commandForMoving();
        try {
            validateMoving(movingCommand);
            return movingCommand;
        }catch (IllegalArgumentException e) {
            System.out.println(IO_msg.ERR_002.msg);
            return readMoving();
        }
    }
    private static String commandForMoving() {
        System.out.println(IO_msg.INPUT_MOVING.msg);
        return Console.readLine();
    }
    private static void validateMoving(String movingCommand) {
        String regex = "[UD]";
        if (!movingCommand.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }


    public static String readGameCommand() {
        String gameCommand = commandForGame();
        try {
            validateGame(gameCommand);
            return gameCommand;
        }catch (IllegalArgumentException e) {
            System.out.println(IO_msg.ERR_003.msg);
            return readGameCommand();
        }
    }
    private static String commandForGame() {
        System.out.println(IO_msg.INPUT_GAME.msg);
        return Console.readLine();
    }
    private static void validateGame(String gameCommand) {
        String regex = "[RQ]";
        if (!gameCommand.matches(regex)) {
            throw new IllegalArgumentException();
        }
    }
}
