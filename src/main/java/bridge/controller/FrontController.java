package bridge.controller;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.model.Bridge;
import bridge.domain.BridgeConst;
import bridge.domain.BridgeGame;
import bridge.view.Input;
import bridge.view.OutputView;

public class FrontController {
    private final Input inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;

    public FrontController(Input inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        startGame();
        do {
            playingGame();
        }while (isRetry());
        finalResult();
    }

    private void finalResult( ){
        outputView.printResult(bridgeGame.returnMap(),bridgeGame.getCount());
    }

    private boolean isRetry(){
        if(bridgeGame.isComplete())return false;
        String command = inputView.readGameCommand();
        if(command.equals(BridgeConst.QUIT)) return false;
        bridgeGame.retry();
        return true;
    }

    private void playingGame( ){
        while(bridgeGame.isContinue()) {
            String moving = inputView.readMoving();
            bridgeGame.move(moving);
            bridgeGame.changeStatus();
            String map = bridgeGame.returnMap();
            outputView.printMap(map);
        }
    }

    private void startGame(){
        outputView.startGame();
        this.bridgeGame = new BridgeGame(makeBridge());
    }

    private Bridge makeBridge(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = inputView.readBridgeSize();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(size));
        return bridge;
    }
}
