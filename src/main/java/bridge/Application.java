package bridge;

import bridge.config.ClassConfig;

public class Application {

    private static final String ERROR_MESSAGE = "[ERROR] ";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ClassConfig classConfig = new ClassConfig();
        try {
            classConfig.bridgeController().run();
        } catch (IllegalArgumentException e) {
            System.out.println((ERROR_MESSAGE + e.getMessage()));
        }
    }
}
