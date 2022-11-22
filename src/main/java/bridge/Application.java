package bridge;

import java.util.NoSuchElementException;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeProgram bridgeProgram = new BridgeProgram();
            bridgeProgram.start();
            bridgeProgram.loop();
            bridgeProgram.finish();
        } catch (NoSuchElementException e) {
            System.out.println("[ERROR]" + e.getMessage());
        }
    }
}
