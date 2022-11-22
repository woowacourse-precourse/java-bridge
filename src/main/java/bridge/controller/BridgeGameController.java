package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeGameStat;
import bridge.BridgeMaker;
import bridge.BridgeMap;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputView;
import bridge.OutputView;
import bridge.constant.BridgeMove;
import bridge.constant.GameCommand;
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

        BridgeGameStat bridgeGameStat = bridgeGame.getBridgeGameStat();
        outputView.printResult(bridgeGameStat);
    }

    private void doGame(List<String> bridge, int bridgeSize) {
        do {
            round(bridge, bridgeSize);
        } while (bridgeGame.isCountOfRoundLessThan(bridgeSize));
    }

    private void round(List<String> bridge, int bridgeSize) {
        BridgeMap bridgeMap = movingBridge(bridge);

        List<BridgeMap> bridgeMaps = bridgeGame.getBridgeGameStat().getBridgeMaps();
        bridgeMaps.add(bridgeMap);
        outputView.printMap(bridgeMaps);

        canNotMoveBridge(bridgeMap);
        canMoveBridge(bridgeMap, bridgeSize);
    }

    private BridgeMap movingBridge(List<String> bridge) {
        BridgeMove playerBridgeMove = inputView.readMoving();

        int countOfRound = bridgeGame.getCountOfRound();
        MoveResult moveResult = bridgeGame.move(bridge, playerBridgeMove.getFirstLetter(), countOfRound);

        return new BridgeMap(playerBridgeMove, moveResult);
    }

    private void canNotMoveBridge(BridgeMap bridgeMap) {
        if (bridgeMap.getMoveResult().isCanNotMove()) {
            doRestartOrQuit();
        }
    }

    private void doRestartOrQuit() {
        GameCommand gameCommand = inputView.readGameCommand();

        if (gameCommand.isRestart()) {
            bridgeGame.retry();
        }

        if (gameCommand.isQuit()) {
            bridgeGame.quit();
        }
    }

    private void canMoveBridge(BridgeMap bridgeMap, int bridgeSize) {
        if (bridgeMap.getMoveResult().isCanMove()) {
            bridgeGame.checkGameWin(bridgeSize);
            bridgeGame.nextRound();
        }
    }
}
