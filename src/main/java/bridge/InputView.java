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
        }catch(Exception e){
            OutputView.printError(e);
            return getBrideSize();
        }
    }
    public String getReadMoving() {
        try {
            return readMoving();
        }catch(Exception e){
            OutputView.printError(e);
            return getReadMoving();
        }
    }
    public String getRestartCommand(){
        try {
           return readGameCommand();
        }catch(Exception e){
            OutputView.printError(e);
            return getRestartCommand();
        }
    }
}
