package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        InputView inputView = new InputView();
//        System.out.println("다리의 길이를 입력해주세요.");
//        int p = inputView.readBridgeSize();
//        System.out.println("p = " + p);
        Controller controller = new Controller();
        controller.play();
    }
}
