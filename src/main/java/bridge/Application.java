package bridge;

import bridge.bridgeGame.BridgeGame;
import bridge.bridgeGame.BridgeGameResultDto;
import bridge.bridgeMaker.BridgeMaker;
import bridge.enums.GameStatus;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller();

        try {
            BridgeGame bridgeGame = controller.prepareBridgeGame();
            controller.startBridgeGame(bridgeGame);
        } catch (IllegalArgumentException iae) {
            return;
        }
    }


}
