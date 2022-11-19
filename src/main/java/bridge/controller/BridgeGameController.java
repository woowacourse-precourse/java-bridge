package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeMap;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputView;
import bridge.OutputView;
import bridge.constant.BridgeMove;
import bridge.constant.MoveResult;
import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridgeGame = new BridgeGame();
    }

    public void gameStart() {
        outputView.printIntroMessage();

        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        doGame(bridge, bridgeSize);
    }

    private void doGame(List<String> bridge, int bridgeSize) {
        do {
            round(bridge);
        } while (bridgeGame.isCountOfRoundLessThan(bridgeSize));
    }

    private void round(List<String> bridge) {
        BridgeMap bridgeMap = movingBridge(bridge);

        List<BridgeMap> bridgeMaps = bridgeGame.getBridgeGameStat().getBridgeMaps();
        bridgeMaps.add(bridgeMap);

        outputView.printMap(bridgeMaps);
    }

    private BridgeMap movingBridge(List<String> bridge) {
        String playerBridgeMove = inputView.readMoving();

        int countOfRound = bridgeGame.getCountOfRound();
        MoveResult moveResult = bridgeGame.move(bridge, playerBridgeMove, countOfRound);

        return new BridgeMap(BridgeMove.findByInput(playerBridgeMove), moveResult);
    }
}
