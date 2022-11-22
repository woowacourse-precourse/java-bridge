package bridge.view;

import bridge.game.BridgeGame;
import bridge.generator.MapMaker;
import bridge.game.Move;
import bridge.message.GameMessage;
import java.util.List;

public class OutputView {
    public void printMap(List<Move> moves) {
        MapMaker mapMaker = new MapMaker();
        String map = mapMaker.makeMap(moves);
        System.out.println(map);
    }

    public void start() {
        System.out.println(GameMessage.GAME_START + "\n");
    }

    public void enterBridgeSize() {
        System.out.println(GameMessage.ENTER_BRIDGE_SIZE);
    }

    public void enterMove() {
        System.out.println(GameMessage.ENTER_MOVE);
    }

    public void enterGameCommand() {
        System.out.println(GameMessage.ENTER_GAME_COMMAND);
    }

    public void printResult(BridgeGame bridgeGame) {
        System.out.println(GameMessage.FINAL_GAME_RESULT);
        printMap(bridgeGame.showCurrentMap());
        printSuccess(bridgeGame);
        printTotalTry(bridgeGame);
    }

    private void printSuccess(BridgeGame bridgeGame) {
        System.out.println(GameMessage.IS_GAME_SUCCESS + bridgeGame.getResultMessage());
    }

    private void printTotalTry(BridgeGame bridgeGame) {
        System.out.println(GameMessage.TOTAL_TRY.toString() + bridgeGame.getTotalTry());
    }

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }
}
