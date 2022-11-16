package bridge;

import bridge.controller.Controller;

public class Application {

    static private OutputView outputView= new OutputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        outputView.printStart();
        Controller controller = new Controller();
        //controller.play();
    }
}
