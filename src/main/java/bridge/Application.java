package bridge;

import bridge.config.AppConfig;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            AppConfig.config().play();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
