package bridge;

import bridge.config.Injector;
import bridge.view.InputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = Injector.getInputView();

        inputView.makeBridge();
        inputView.move();
    }
}
