package bridge.view;

import bridge.game.BridgeGame;
import bridge.game.MapMaker;
import bridge.game.Progress;
import java.util.List;

public class OutputView {
    public void printMap(List<Progress> progresses) {
        MapMaker mapMaker = new MapMaker();
        String map = mapMaker.makeMap(progresses);
        System.out.println(map);
    }

    public void start() {
        System.out.println(Message.GAME_START + "\n");
    }

    public void enterBridgeSize() {
        System.out.println(Message.ENTER_BRIDGE_SIZE);
    }

    public void enterMove() {
        System.out.println(Message.ENTER_MOVE);
    }

    public void enterGameCommand() {
        System.out.println(Message.ENTER_GAME_COMMAND);
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println(Message.FINAL_GAME_RESULT);
        printMap(bridgeGame.showCurrentResult());
        printSuccess(bridgeGame);
        printTotalTry(bridgeGame);
    }

    private void printSuccess(BridgeGame bridgeGame) {
        System.out.println(Message.IS_GAME_SUCCESS + bridgeGame.showSuccess());
    }

    private void printTotalTry(BridgeGame bridgeGame) {
        System.out.println(Message.TOTAL_TRY.toString() + bridgeGame.showTotalTry());
    }

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }
}
