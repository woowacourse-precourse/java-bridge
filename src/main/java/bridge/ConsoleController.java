package bridge;

import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class ConsoleController {
    private OutputView outputView;
    private InputView inputView;

    public ConsoleController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public int inputBridgeSize(){
        try {
            outputView.printGameStart();
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBridgeSize();
        }
    }

    public String inputMovingDirection(){
        try {
            outputView.printDirectionInput();
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMovingDirection();
        }
    }

    public String inputGameCommand() {
        try {
            outputView.printGameCommandInput();
            return inputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputGameCommand();
        }
    }

    public void outputFinalResult(List<String> finalResult) {
        outputView.printResult(finalResult);
    }

    public void outputStepProgress(List<String> stepProgress) {
        outputView.printMap(stepProgress);
    }
}
