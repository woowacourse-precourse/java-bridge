package bridge;

import bridge.constant.Messages;
import bridge.service.BridgeMaker;
import bridge.service.BridgeNumberGenerator;
import bridge.service.BridgeRandomNumberGenerator;

public class Application {

    public static void main(String[] args) {
        try {
            System.out.println(Messages.START_MESSAGE);
            BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(bridgeNumberGenerator));
            bridgeGame.startGame();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
