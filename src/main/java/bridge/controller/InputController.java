package bridge.controller;

import bridge.exception.constant.Exception;
import bridge.exception.input.InputException;
import bridge.view.InputView;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class InputController {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public int checkBridgeSize(){
        try{
            outputView.printEnterBridgeLength();
            String bridgeLength = inputView.readBridgeSize();
            InputException.checkBridgeLengthInput(bridgeLength);
            return Integer.parseInt(bridgeLength);
        }catch (IllegalArgumentException illegalArgumentException){
            String errorMessage= Exception.getErrorMessage(illegalArgumentException.getMessage());
            outputView.printErrorMessage(errorMessage);
            return checkBridgeSize();
        }
    }

    public String checkMoving(){
        try{
            outputView.printEnterMoving();
            String moving = inputView.readMoving();
            InputException.validateMovingInput(moving);
            return moving;
        }catch (IllegalArgumentException illegalArgumentException){
            String errorMessage= Exception.getErrorMessage(illegalArgumentException.getMessage());
            outputView.printErrorMessage(errorMessage);
            return checkMoving();
        }
    }

    public String checkGameCommand() {
        try {
            outputView.printEnterGameCommand();
            String gameCommand = inputView.readGameCommand();
            InputException.validateGameCommandInput(gameCommand);
            return gameCommand;
        } catch (IllegalArgumentException illegalArgumentException) {
            String errorMessage = Exception.getErrorMessage(illegalArgumentException.getMessage());
            outputView.printErrorMessage(errorMessage);
            return checkGameCommand();
        }
    }

}
