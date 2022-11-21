package bridge.controller;

import bridge.service.BridgeGame;
import bridge.service.BridgeMaker;
import bridge.service.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    private Integer bridgeSize;
    private List<String> bridgeList;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }
    void init(){
        outputView.printGameStartMessage();
        outputView.printBridgeRequestMessage();
        bridgeSize = inputView.readBridgeSize();
        bridgeList = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame = new BridgeGame(bridgeList);
    }
    public void run(){
        init();
        do{
            game();
        }
        while(gameOver());
        outputView.printResult(bridgeGame);
    }
    public void game() {
        while(!(bridgeGame.isOver())){
            outputView.printMovingInputMessage();
            bridgeGame.move(inputView.readMoving());
            outputView.printBridge(bridgeGame.getUpBridge(),bridgeGame.getDownBridge());
        }
    }
    public boolean gameOver() {
        if(!(bridgeGame.isSuccess())) {
            return isRetry();
        }
        return false;
    }
    public boolean isRetry() {
        outputView.printRetryMessage();
        String gameCommand = inputView.readGameCommand();
        return bridgeGame.retry(gameCommand);
    }
}
