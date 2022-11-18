package bridge;

import bridge.view.InputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView input = new InputView();
        input.gameStart();
        String size = input.readBridgeSize();
        System.out.println("size = " + size);
    }
}
