package bridge.controller;

import java.util.List;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.Movement;
import bridge.domain.Player;
import bridge.domain.Result;
import bridge.view.OutputView;

public class GameController {

    private final InputController inputController;
    private final Result result = new Result();

    public GameController(InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        Bridge bridge = createBridge();
        Player player = new Player();
        BridgeGame bridgeGame = new BridgeGame(bridge, player);
        crossABridge(bridge, player, bridgeGame);
        OutputView.printResult(result);
    }

    private Bridge createBridge() {
        int bridgeSizeInput = inputController.getBridgeSizeInput();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSizeInput);
        return new Bridge(bridge);
    }

    private void crossABridge(Bridge bridge, Player player, BridgeGame bridgeGame) {
        for (int step = 0; step < bridge.getBridgeSize(); step++) {
            Movement directionInput = inputController.getDirectionInput();
            bridgeGame.move(directionInput, result);
            if (result.getSuccessOrFailure().equals("실패")) {
                retryGame(bridge, player, bridgeGame);
                break;
            }
        }
    }

    private void retryGame(Bridge bridge, Player player, BridgeGame bridgeGame) {
        boolean retryCommandInput = inputController.getRetryCommandInput();
        if (retryCommandInput) {
            bridgeGame.retry(result);
            crossABridge(bridge, player, bridgeGame);
        }
    }
}