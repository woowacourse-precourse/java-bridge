package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.CompareBridge;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;

    private BridgeGame bridgeGame;
    private List<String> upSideDownSideMove = new ArrayList<>(List.of("", ""));

    public BridgeGameController() {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(numberGenerator);
        bridgeGame = new BridgeGame(1, true);
        outputView = new OutputView();
        inputView = new InputView();
    }

    public void run() {
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);
        tryGame(bridge);
        outputView.printResult(upSideDownSideMove, bridgeGame.getRetryCount());
    }

    public void tryGame(List<String> bridge) {
        while (bridgeGame.getGameFlag() && bridgeGame.isFailure(upSideDownSideMove)) {
            upSideDownSideMove = updateUpSideDownSideMove(bridge);
            if (bridgeGame.isFailure(upSideDownSideMove)) {
                String gameCommand = inputView.readGameCommand();
                bridgeGame = bridgeGame.retry(gameCommand);
            }
        }
    }

    public List<String> updateUpSideDownSideMove(List<String> bridge) {
        List<String> updateMove = new ArrayList<>(List.of("", ""));
        updateMove = tryMove(updateMove, bridge);
        return updateMove;
    }

    public List<String> tryMove(List<String> updateMove, List<String> bridge) {
        for (String bridgeElement : bridge) {
            CompareBridge playerMove = new CompareBridge(inputView.readMoving());
            updateMove = bridgeGame.move(playerMove, updateMove, bridgeElement);
            outputView.printMap(updateMove);
            if (bridgeGame.isFailure(updateMove)) {
                break;
            }
        }
        return updateMove;
    }
}
