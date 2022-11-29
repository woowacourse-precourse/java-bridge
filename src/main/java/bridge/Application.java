package bridge;

import bridge.controller.Controller;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        outputView.printStart();
        Controller controller = new Controller(inputView, outputView);
        controller.play();
    }
}
