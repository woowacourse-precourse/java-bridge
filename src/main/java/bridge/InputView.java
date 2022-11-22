package bridge;
import camp.nextstep.edu.missionutils.Console;
public class InputView {
    ExceptionCase exceptionCase = new ExceptionCase();
    OutputView outputView = new OutputView();
    public int readBridgeSize() {
        outputView.printInputBridgeSize();
        int bridgeSize = exceptionCase.validateBridgeSizeIsInteger(Console.readLine());
        return exceptionCase.validateBridgeSizeInRange(bridgeSize);
    }
    public String readMoving() {
        outputView.printInputMove();
        return exceptionCase.validateMoves(Console.readLine().toUpperCase());
    }
    public String readGameCommand() {
        outputView.printInputGameCommand();
        return exceptionCase.validateRetryCommand(Console.readLine().toUpperCase());
    }
}
