package bridge;

import bridge.controller.Controller;
import bridge.exception.IllegalArgumentError;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            System.out.println("다리 건너기 게임을 시작합니다.");
            new Controller().run();
        } catch (IllegalArgumentError ignored) {

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
