package bridge;

import View.InputView;
import View.OutputView;

public class Application {

    public static int inputFunctions(OutputView outputView, IFunction f) {
        boolean flag = true;
        int res = 0;
        while (flag) {
            try{
                res = f.execute();
                flag = false;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView  = new InputView();
        OutputView outputView = new OutputView();
        Controller controller = new Controller(inputView, outputView);


        outputView.printStart();
        inputFunctions(outputView, controller::start);
        boolean flag = true;
        while (flag) {
            int moveFlag = inputFunctions(outputView, controller::move);
            if(moveFlag == 1) {
                flag = inputFunctions(outputView, controller::askRetry) == 1;
            }
            if(moveFlag == 2) {
                break;
            }
        }
        controller.result();

    }
}
