package bridge;

import bridge.controller.Controller;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("다리 건너기 게임을 시작합니다.");
        Controller controller = new Controller();
        controller.run();
    }
}
