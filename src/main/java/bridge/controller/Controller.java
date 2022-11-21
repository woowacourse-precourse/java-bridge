package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Controller {
    private BridgeMaker bridgeMaker;
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    public Controller (BridgeMaker bridgeMaker, InputView inputView, OutputView outputView){
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    private void startGame(){
        outputView.printGameStart();
        this.bridgeGame = new BridgeGame();
    }

    private void inputBridgeLength(){
        outputView.printBridgeLengthInputRequest();
        int bridgeLength = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeLength);
        bridgeGame.setBridge(bridge);
    }

    private void move(){
        outputView.printMoveInputRequest();
        String moveCommand = inputView.readMoving();
        bridgeGame.move(moveCommand);
        List<String> map = bridgeGame.getBridgeProgress();
        outputView.printMap(map);
    }

    private void retry(){
        outputView.printRetryInputRequest();
        String retrialInput = inputView.readGameCommand();
        bridgeGame.retry(retrialInput);
    }
}
