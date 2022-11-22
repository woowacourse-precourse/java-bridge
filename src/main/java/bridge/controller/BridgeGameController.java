package bridge.controller;

import bridge.model.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

import static bridge.MODEnum.RE_GAME;
import static bridge.MODEnum.SUCCESS_GAME_MESSAGE;

public class BridgeGameController {
    private BridgeGame bridgeGame;
    private BridgeGame maxDistanceBridge;
    private List<String> bridge;

    public void startBridgeGame() {
        init();
        do {
            bridgeGame.move(InputView.getMoving());
            OutputView.printMap(bridgeGame);
            makeMaxDistanceBridge(bridgeGame,maxDistanceBridge);
            if (!bridgeGame.getGameBoolean().equals(SUCCESS_GAME_MESSAGE.getMessage())) {
                continueBrideGameCommand(InputView.getGameCommand());
            }
        } while (bridgeGame.gameContinue());
        OutputView.printResult(maxDistanceBridge);
    }

    public void continueBrideGameCommand(String gameCommand) {
        if (gameCommand.equals(RE_GAME.getMessage())) {
            bridgeGame.retry();
            bridgeGame.totalGamePlus();
        }
    }

    public void init() {
        OutputView.printGameStart();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridge = bridgeMaker.makeBridge(InputView.getBridgeSize());
        bridgeGame = new BridgeGame(bridge);
        maxDistanceBridge = new BridgeGame(bridge);
    }

    private void makeMaxDistanceBridge(BridgeGame bridgeGame, BridgeGame maxDistanceBridge){
        if (bridgeGame.getUpPresentBridge().size() > maxDistanceBridge.getUpPresentBridge().size()) {
            this.maxDistanceBridge.setUpPresentBridge(bridgeGame.getUpPresentBridge().stream().collect(Collectors.toList()));
            this.maxDistanceBridge.setDownPresentBridge(bridgeGame.getDownPresentBridge().stream().collect(Collectors.toList()));
            this.maxDistanceBridge.setUserMoveList(bridgeGame.getUserMoveList().stream().collect(Collectors.toList()));
        }
        this.maxDistanceBridge.setGameBoolean(bridgeGame.getGameBoolean());
        this.maxDistanceBridge.setGameCount(bridgeGame.getGameCount());
    }
}
