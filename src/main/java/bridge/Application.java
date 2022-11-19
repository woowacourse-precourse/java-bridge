package bridge;

import bridge.view.GameStartView;
import bridge.view.InputView;

public class Application {

    private static final InputView inputView=new InputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new GameStartView().printStartMessage();
        inputView.readBridgeSize();
    }
}
