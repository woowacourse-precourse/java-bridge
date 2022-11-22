package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    private List<String> bridges;
    private BridgeGame bridgeGame;

    public BridgeGameController() {
        initiate();
        gameStart();
    }

    private void initiate() {
        OutputView.printgameStart();
        bridges = InputController.getBridgeMaker();
        bridgeGame = new BridgeGame();
        OutputView.printbr();

    }

    private void gameStart() {
        int count = 0;
        do {
            count++;
        } while (Bridgemove(bridges, bridgeGame));
        OutputView.printResult(bridgeGame, bridgeGame.gameSuccessMessage(), count);

    }

    private Boolean Bridgemove(List<String> bridges, BridgeGame bridgeGame) {
        for (String bridge : bridges) {
            bridgeGame.move(InputController.getUserMoveBox(), bridge);
            OutputView.printMap(bridgeGame.upline(), bridgeGame.downline());
            if (bridgeGame.failCheck()) {
                return bridgeGame.retry(InputController.getRestartStatus());
            }
        }
        return false;
    }

}
