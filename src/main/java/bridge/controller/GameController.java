package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeMaker;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeSizeInput;
import bridge.domain.DirectionInput;
import bridge.domain.RetryInput;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeGame bridgeGame = new BridgeGame();
    private static int tryCount = 0;
    private List<String> bridge = new ArrayList<>();
    private boolean success = true;
    public void play() {
        try {
            BridgeSizeInput bridgeSizeInput = new BridgeSizeInput(inputView.readBridgeSize());
            this.bridge = bridgeMaker.makeBridge(bridgeSizeInput.getBridgeSize());
            tryCount++;
            bridgeGame.initBridgeGame();
            crossingBridge();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void crossingBridge() {
        for(String space: this.bridge) {
            DirectionInput directionInput = new DirectionInput(inputView.readMoving());
            if(validateMovement(directionInput.getDirectionInput(),space)){
                this.bridgeGame.move(directionInput.getDirectionInput());
                outputView.printMap(bridgeGame.getUpBlocks(), bridgeGame.getDownBlocks());
            }
            if(!validateMovement(directionInput.getDirectionInput(),space)){
                this.bridgeGame.WrongMove(directionInput.getDirectionInput());
                outputView.printMap(bridgeGame.getUpBlocks(), bridgeGame.getDownBlocks());
                retryOrExitFail();
                return;
            }
        }
        outputView.printResult(true, tryCount);
    }

    private boolean validateMovement(String movement, String space){
        if(movement.equals(space)) return true;
        return false;
    }

    private void retryOrExitFail() {
        RetryInput retryInput = new RetryInput(inputView.readGameCommand());
        if(!bridgeGame.retry(retryInput.getRetryInput())) {
            outputView.printResult(false, tryCount);
        }
    }
}
