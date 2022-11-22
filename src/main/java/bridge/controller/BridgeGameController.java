package bridge.controller;

import bridge.MODEnum;
import bridge.model.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.MODEnum.RE_GAME;
import static bridge.MODEnum.SUCCESS_GAME_MESSAGE;

public class BridgeGameController {
    private BridgeGame bridgeGame;
    private List<String> bridge;

    public void startBridgeGame() {
        init();
        do {
            bridgeGame.move(InputView.getMoving());
            OutputView.printMap(bridgeGame);
            if(!bridgeGame.getGameBoolean().equals(SUCCESS_GAME_MESSAGE.getMessage())) {
                String gameCommand = InputView.getGameCommand();
                continueBrideGameCommand(gameCommand);
            }
        } while (bridgeGame.gameContinue());
        OutputView.printResult(bridgeGame);
    }

    public void continueBrideGameCommand(String gameCommand){
        if(gameCommand.equals(RE_GAME.getMessage())){
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
    }
}
