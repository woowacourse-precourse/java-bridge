package bridge.controller;

import bridge.BridgeMaker;
import bridge.domain.BridgeGame;
import bridge.domain.constants.Command;
import bridge.domain.constants.GameState;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.text.OutputText;

public class Controller {
    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;
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
            if (bridgeGame.getGameState() == GameState.PAUSE) {
                retry();
            }
        }
        showResult();
    }

    private void startGame(){
        outputView.printGameStart();
        this.bridgeGame = new BridgeGame();
    }

    private void inputBridgeLength(){
        try {
            outputView.printBridgeLengthInputRequest();
            bridgeGame.setBridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
            showMap();
        }
        catch (IllegalArgumentException exception){
            outputView.printErrorMessage(exception.getMessage());
            inputBridgeLength();
        }
    }

    private void move(){
        try {
            outputView.printMoveInputRequest(Command.MOVE_UP.getCommand(), Command.MOVE_DOWN.getCommand());
            bridgeGame.move(inputView.readMoving());
        }
        catch (IllegalArgumentException exception){
            outputView.printErrorMessage(exception.getMessage());
            move();
        }
    }

    private void retry(){
        try {
            outputView.printRetryInputRequest(Command.RETRY.getCommand(), Command.QUIT.getCommand());
            bridgeGame.retry(inputView.readGameCommand());
        }
        catch (IllegalArgumentException exception){
            outputView.printErrorMessage(exception.getMessage());
            retry();
        }
    }

    private void showResult(){
        outputView.printResult(gameStateToString(bridgeGame.getGameState()), bridgeGame.getTrialCount());
        showMap();
    }

    private String gameStateToString(GameState gameState){
        if (gameState == GameState.CLEAR) return OutputText.CLEAR.getMessage();
        return OutputText.FAIL.getMessage();
    }

    private void showMap(){
        outputView.printMap(bridgeGame.getProgress().asString());
    }
}
