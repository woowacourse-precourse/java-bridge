package bridge.controller;

import java.util.List;

import bridge.service.BridgeGame;
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
    private static final Boolean CORRECT_ANSWER = Boolean.TRUE;
    private static final Boolean WRONG_ANSWER = Boolean.FALSE;

    public GameController(InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        Bridge bridge = createBridge();
        System.out.println(bridge.getBridge());
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
            if (!bridgeGame.move(directionInput)) {
                retryGame(bridge, player, bridgeGame);
                break;
            }
            judgeTrue(player);
        }
    }

    private void retryGame(Bridge bridge, Player player, BridgeGame bridgeGame) {
        judgeFalse(player);
        boolean retryCommandInput = inputController.getRetryCommandInput();
        if (retryCommandInput) {
            bridgeGame.retry(result);
            crossABridge(bridge, player, bridgeGame);
        }
    }

    private void judgeTrue(Player player) {
        result.setGameResult(CORRECT_ANSWER);
        OutputView.printMap(result, player);
    }

    private void judgeFalse(Player player) {
        result.setGameResult(WRONG_ANSWER);
        OutputView.printMap(result, player);
    }
}