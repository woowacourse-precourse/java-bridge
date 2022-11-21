package bridge.output;

import bridge.map.Map;

public class OutputView {

    public static void printStartMessage() {
        System.out.println(Guide.START.getMessage());
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
        System.out.println(Guide.FINISH.getMessage());

        printMap(map);

        System.out.print(Guide.RESULT.getMessage());
        System.out.println(toMessage(success));

        System.out.print(Guide.TOTAL_TRY.getMessage());
        System.out.println(totalTry);
    }

    private static String toMessage(boolean success) {
        if (success) {
            return Guide.SUCCESS.getMessage();
        }

        return Guide.FAIL.getMessage();
    }
}
