package bridge;

import data.BridgeData;
import data.ExceptionData;
import view.InputView;
import view.OutputView;

/**
 * 뷰를 관리하는 클래스
 */
public class ViewManager {
    InputView inputView = new InputView();
    OutputView outPutView = new OutputView();

    public int getBridgeSize(){
        int bridgeSize;
        while(true) {
            try{
                bridgeSize = Integer.parseInt(inputView.readBridgeSize());
                return validateSize(bridgeSize);
            }catch(IllegalArgumentException e ){
                ExceptionData.EXCEPTION_SIZE.printExceptionData();
            }
        }
    }

    private int validateSize(int bridgeSize) throws IllegalArgumentException{
        if(bridgeSize < BridgeData.MINIMUM_LENGTH || bridgeSize > BridgeData.MAXIMUM_LENGTH){
            throw new IllegalArgumentException();
        }
        return bridgeSize;
    }

    public String getMoveCommand(){
        String moveCommand;
        while(true) {
            try{
                moveCommand = inputView.readMoving();
                return validateMove(moveCommand);
            }catch(IllegalArgumentException e){
                ExceptionData.EXCEPTION_MOVE.printExceptionData();
            }
        }
    }

    private String validateMove(String moveCommand) throws IllegalArgumentException {
        try {
            if (!moveCommand.equals(BridgeData.UP) && !moveCommand.equals(BridgeData.DOWN)) {
                throw new IllegalArgumentException();
            }
            return moveCommand;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public String getGameCommand(){
        String gameCommand;
        while(true) {
            try{
                gameCommand = inputView.readGameCommand();
                return validateMove(gameCommand);
            }catch(IllegalArgumentException e){
                ExceptionData.EXCEPTION_RESTART.printExceptionData();
            }
        }
    }

    private String validateCommand(String gameCommand) throws IllegalArgumentException {
        try {
            if (!gameCommand.equals(BridgeData.RESTART) || !gameCommand.equals(BridgeData.QUIT)) {
                throw new IllegalArgumentException();
            }
            return gameCommand;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
