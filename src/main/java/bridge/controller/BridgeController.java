package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.Row;
import bridge.view.InputView;
import bridge.view.OutputView;


public class BridgeController {


    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    BridgeController(){
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
    }
    public void startGame(){
        int size = validateNumeric(inputView.readBridgeSize());
        bridgeGame.start(size);
    }

    int validateNumeric(String input){
        if(!input.matches("^[0-9]")){
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }
    void validateLetter(String input){
        if(!Row.isValidateLetter(input)){
            throw new IllegalArgumentException();
        }
    }
    void validateEndLetter(String input){
        if(!input.equals(GameMessage.RETRY) || !input.equals(GameMessage.CLOSE)){
            throw new IllegalArgumentException();
        }
    }
}
