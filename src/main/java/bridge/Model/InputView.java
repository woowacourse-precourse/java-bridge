package bridge.Model;

import bridge.View.OutputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.InputMismatchException;

public class InputView {
    private final ValidateUserInput validateUserInput;

    public InputView(){
        validateUserInput = new ValidateUserInput();
    }
    public int readBridgeSize() {
        String bridgeSize = Console.readLine();

        validateUserInput.checkBridgeSizeIsDigit(bridgeSize);
        validateUserInput.checkBridgeSizeRange(bridgeSize);
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
        }catch(NumberFormatException e){
            OutputView.printError(e);
            return getBrideSize();
        }
    }
    public String getMovingCommand() {
        try {
            return readMoving();
        }catch(InputMismatchException e){
            OutputView.printError(e);
            return getMovingCommand();
        }
    }
    public String getRestartCommand(){
        try {
           return readGameCommand();
        }catch(InputMismatchException e){
            OutputView.printError(e);
            return getRestartCommand();
        }
    }
}
