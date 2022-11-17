package bridge;

import bridge.constant.Messages;
import bridge.service.BridgeMaker;
import bridge.service.BridgeNumberGenerator;
import bridge.service.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        try {
            System.out.println(Messages.START_MESSAGE);
            BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeGame bridgeGame = new BridgeGame(
                    new BridgeMaker(bridgeNumberGenerator), new InputView(), new OutputView());
            bridgeGame.startGame();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
