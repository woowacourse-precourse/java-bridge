package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.GameState;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.text.OutputText;

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

    public void run(){
        startGame();
        inputBridgeLength();
        while (bridgeGame.getGameState() == GameState.RUNNING){
            move();
            retry();
        }
        showResult();
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

    private void showResult(){
        outputView.printResult(gameStateToString(bridgeGame.getGameState()), bridgeGame.getTrialCount());
    }

    private String gameStateToString(GameState gameState){
        if (gameState == GameState.CLEAR) return OutputText.CLEAR.getMessage();
        return OutputText.FAIL.getMessage();
    }
}
