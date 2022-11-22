package bridge.controller;

import bridge.*;
import bridge.model.BridgeGame;
import bridge.model.BridgeMaker;
import bridge.model.GameResult;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public BridgeGameController() {
    }

    public void play(){
        outputView.startGameMessage();
        List<String> bridge = createBridge(inputView.readBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridge);

        startGame(bridgeGame);
        outputView.printResult(bridgeGame.getTopResult(), bridgeGame.getBottomResult(), bridgeGame.successOrFailure(), bridgeGame.getTotalPlayCnt());
    }

    private List<String> createBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);
        return bridge;
    }

    private void startGame(BridgeGame bridgeGame) {
        moveBridge(bridgeGame);
        restart(bridgeGame);
    }

    public void moveBridge(BridgeGame bridgeGame){
        for(int i = 0; i < bridgeGame.getBridge().size(); i++){
            boolean success = bridgeGame.move(inputView.readMoving(), i);
            outputView.printMap(bridgeGame.getTopResult(), bridgeGame.getBottomResult());
            if(!success){
                return;
            }
        }
    }

    public void restart(BridgeGame bridgeGame){
        if(bridgeGame.successOrFailure() == GameResult.SUCCESS){
            return;
        }
        String restartCommand = inputView.readGameCommand();
        if(restartCommand.equals("R")){
            bridgeGame.retry();
            startGame(bridgeGame);
        }
    }
}
