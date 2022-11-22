package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final ValidateUserInput validateUserInput;

    public InputView(){
        validateUserInput = new ValidateUserInput();
    }
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();

        validateUserInput.checkBridgeSizeRange(bridgeSize);
        validateUserInput.checkBridgeSizeIsDigit(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }
    public String readMoving() {
        String movingCommand = Console.readLine();

        validateUserInput.checkReadMoving(movingCommand);
        return movingCommand;
    }
    public String readGameCommand(){
        String restartCommand = Console.readLine();

        validateUserInput.checkRestartCommand(restartCommand);
        return restartCommand;
    }
    public int getBrideSize() {
        try {
            return readBridgeSize();
        }catch(IllegalArgumentException e){
            System.out.println(ErrorCase.SIZE_ERROR.getError());
            return getBrideSize();
        }
    }
    public String getReadMoving() {
        try {
            return readMoving();
        }catch(IllegalArgumentException e){
            System.out.println(ErrorCase.MOVE_ERROR.getError());
            return getReadMoving();
        }
    }
    public String getRestartCommand(){
        try {
           return readGameCommand();
        }catch(IllegalArgumentException e){
            System.out.println(ErrorCase.RESTART_ERROR.getError());
            return getRestartCommand();
        }
    }
}
