package bridge;

import bridge.domain.BridgeGameManager;

import java.util.NoSuchElementException;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            BridgeGameManager bridgeGameManager = new BridgeGameManager();
            bridgeGameManager.start();
        } catch (IllegalArgumentException | IllegalStateException ex) {
            System.out.println(ex.getMessage());
            throw new NoSuchElementException();
        }
    }
}
