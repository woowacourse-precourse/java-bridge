package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.List;

public class BridgeController {
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeController(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start(){
        this.outputView.announceStartGame();
        createBridgeGame();
        do{
            playTurn();
        }while(!this.bridgeGame.isEnd());
        announceFinalResult();
    }

    private void createBridgeGame(){
        int inputSize = this.inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(inputSize);
        this.bridgeGame = new BridgeGame(bridge);
    }

    private void announceFinalResult() {
        boolean isSuccess = this.bridgeGame.isSuccess();
        this.outputView.announceEndGame();
        String bridgePicture = this.bridgeGame.getPicture();
        int tryCount = this.bridgeGame.getTryCount();
        this.outputView.printResult(isSuccess, tryCount);
    }

    private void playTurn(){
        String moving = this.inputView.readMoving();
        String bridgePicture = this.bridgeGame.move(moving);
        this.outputView.printMap(bridgePicture);
        if(this.bridgeGame.isFail()){
            String gameCommand = this.inputView.readGameCommand();
            this.bridgeGame.retry(gameCommand);
        }
    }

}
