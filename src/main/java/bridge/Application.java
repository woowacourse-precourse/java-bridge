package bridge;

import static bridge.BridgeProgram.runBridgeProgram;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            runBridgeProgram();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
