package bridge;

public class OutputView {

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printStartGameMessage() {
        System.out.println(Messages.START_GAME);
        printEmptyLine();
    }

    public static void printMap(BridgeGame game) {
        System.out.println(game.getResult());
    }

    public static void printResult(BridgeGame game) {
        System.out.println(Messages.FINAL_RESULT_HEADER);
        printMap(game);
        printEmptyLine();
        System.out.println(Messages.FINAL_RESULT_GAME_STATE_PREFIX + game.getState().getText());
        System.out.println(Messages.FINAL_RESULT_TRY_PREFIX + game.getTryCount());
    }
}
