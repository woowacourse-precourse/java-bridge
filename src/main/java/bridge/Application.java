package bridge;

import bridge.program.BridgeGameProgram;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeGameProgram bridgeGameProgram = new BridgeGameProgram();
            bridgeGameProgram.run();
        } catch (Exception e) {
            System.out.println("[ERROR] "+e.getMessage());
        }
    }
}
