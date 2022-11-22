package bridge.controller;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.MoveResult;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    public  void playGame(){
        Bridge bridge = startGame();
        runGame(bridge);
    }
    public Bridge startGame() {
        Bridge bridge = new Bridge(InputView.readBridgeSize());
        return bridge;
    }


    public static void runGame(Bridge bridge) {
        List<MoveResult> moveResults= new ArrayList<>();
        BridgeGame bridgeGame = new BridgeGame(moveResults, bridge);
        while (bridge.crossingBridgeSuccess() && bridgeGame.notExit()) {
            bridgeGame.move();
            OutputView.printMap(bridgeGame.getMoveResults());
        }
        retryOrOver(bridgeGame);
    }


    private static void retryOrOver(BridgeGame bridgeGame) {
        if (bridgeGame.isFailedGame()) {
            bridgeGame.retry();
        }
    }

}
