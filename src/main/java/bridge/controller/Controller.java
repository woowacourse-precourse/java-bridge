package bridge.controller;

import bridge.BridgeMaker;
import bridge.domain.BridgeGame;
import bridge.domain.constants.Command;
import bridge.domain.constants.GameState;
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
            int bridgeLength = inputView.readBridgeSize();
            List<String> bridge = bridgeMaker.makeBridge(bridgeLength);
            bridgeGame.setBridge(bridge);
        }
        catch (IllegalArgumentException exception){
            outputView.printErrorMessage(exception.getMessage());
            inputBridgeLength();
        }
    }

    private void move(){
        try {
            outputView.printMoveInputRequest(Command.MOVE_UP.getCommand(), Command.MOVE_DOWN.getCommand());
            String moveCommand = inputView.readMoving();
            bridgeGame.move(moveCommand);
            outputView.printMap(mapToString(bridgeGame.getUpperBlock()), mapToString(bridgeGame.getLowerBlock()));
        }
        catch (IllegalArgumentException exception){
            outputView.printErrorMessage(exception.getMessage());
            move();
        }
    }

    private String mapToString(List<String> map){
        String ret = "";
        for (int i = 0; i < map.size(); i++){
            if (i == 0) {
                ret += "[ ";
            }
            ret += map.get(i);
            if (i != map.size() - 1){
                ret += " | ";
            }
            if (i == map.size() - 1){
                ret += " ]";
            }
        }
        return ret;
    }

    private void retry(){
        try {
            outputView.printRetryInputRequest(Command.RETRY.getCommand(), Command.QUIT.getCommand());
            String retrialInput = inputView.readGameCommand();
            bridgeGame.retry(retrialInput);
        }
        catch (IllegalArgumentException exception){
            outputView.printErrorMessage(exception.getMessage());
            retry();
        }
    }

    private void showResult(){
        outputView.printResult(gameStateToString(bridgeGame.getGameState()), bridgeGame.getTrialCount());
        outputView.printMap(mapToString(bridgeGame.getUpperBlock()), mapToString(bridgeGame.getLowerBlock()));
    }

    private String gameStateToString(GameState gameState){
        if (gameState == GameState.CLEAR) return OutputText.CLEAR.getMessage();
        return OutputText.FAIL.getMessage();
    }
}
