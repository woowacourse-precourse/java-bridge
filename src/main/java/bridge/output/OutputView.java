package bridge.output;

import bridge.map.Map;
import bridge.output.message.Error;
import bridge.output.message.Read;
import bridge.output.message.Status;

public class OutputView {

    public static void printStartMessage() {
        System.out.println(Status.START.getMessage());
    }

    public static void printReadBridgeSizeMessage() {
        System.out.println(Read.BRIDGE_SIZE.getMessage());
    }

    public static void printReadBridgeSizeErrorMessage() {
        System.out.println(Error.BRIDGE_SIZE.getMessage());
    }

    public static void printReadMovingMessage() {
        System.out.println(Read.MOVING.getMessage());
    }

    public static void printReadMovingErrorMessage() {
        System.out.println(Error.MOVING.getMessage());
    }

    public static void printReadGameCommandMessage() {
        System.out.println(Read.GAME_COMMAND.getMessage());
    }

    public static void printReadGameCommandErrorMessage() {
        System.out.println(Error.GAME_COMMAND.getMessage());
    }

    public static void printMap(Map map) {
        System.out.println(map.toString());
    }
    
    public static void printResult(Map map, boolean success, int totalTry) {
        System.out.println(Status.FINISH.getMessage());
        printMap(map);
        System.out.print(Status.SUCCESS_OR_NOT.getMessage());
        System.out.println(successOrNotToString(success));
        System.out.print(Status.TOTAL_TRY.getMessage());
        System.out.println(totalTry);
    }

    private static String successOrNotToString(boolean success) {
        if (success) {
            return Status.SUCCESS.getMessage();
        }
        return Status.FAIL.getMessage();
    }
}
