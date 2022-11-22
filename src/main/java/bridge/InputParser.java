package bridge;

import data.BridgeData;
import data.ExceptionData;
import view.InputView;
import view.OutputView;

/**
 * Inputview를 관리하는 클래스.
 * <p>
 * 입력 예외도 여기에서 처리함.
 */
public class InputParser {
    InputView inputView = new InputView();
    OutputView outPutView = new OutputView();

    /**
     * 다리길이를 받아서 예외를 검출하고 BridgeGame에 전달.
     * @return 다리 길이
     */
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

    public String getGameCommand(){
        String gameCommand;
        while(true) {
            try{
                gameCommand = inputView.readGameCommand();
                return validateGameCommand(gameCommand);
            }catch(IllegalArgumentException e){
                ExceptionData.EXCEPTION_RESTART.printExceptionData();
            }
        }
    }


    private int validateSize(int bridgeSize) throws IllegalArgumentException{
        if(bridgeSize < BridgeData.MINIMUM_LENGTH || bridgeSize > BridgeData.MAXIMUM_LENGTH){
            throw new IllegalArgumentException();
        }
        return bridgeSize;
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


    private String validateGameCommand(String gameCommand) throws IllegalArgumentException {
        try {
            if (!gameCommand.equals(BridgeData.RESTART) && !gameCommand.equals(BridgeData.QUIT)) {
                throw new IllegalArgumentException();
            }
            return gameCommand;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

}
