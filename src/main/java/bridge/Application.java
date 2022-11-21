package bridge;

import View.InputView;
import View.OutputView;

interface IFunction{
    void execute();
}

public class Application {

    public static void inputFunctions(OutputView outputView, IFunction f) {
        boolean flag = true;
        while (flag) {
            try{
                f.execute();
                flag = false;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView  = new InputView();
        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame();
        Controller controller = new Controller(inputView, outputView, bridgeGame);

        inputFunctions(outputView, controller::start);



    }
}
