package bridge;

import bridge.presentation.BridgeGameSystem;
import config.BridgeGameContainer;
import exception.ExceptionMessage;

public class Application {

    public static void main(String[] args) {
        BridgeGameContainer bridgeGameContainer = BridgeGameContainer.getInstance();
        try {
            BridgeGameSystem bridgeGameSystem = bridgeGameContainer.bridgeGameSystem();
            bridgeGameSystem.play();
        } catch (IllegalArgumentException e) {
            System.out.println(ExceptionMessage.PREFIX + e.getMessage());
        }

    }
}
