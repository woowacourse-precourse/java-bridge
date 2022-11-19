package bridge;

import bridge.models.BridgeGame;
import bridge.models.BridgeMaker;
import bridge.utils.BridgeNumberGenerator;
import bridge.utils.BridgeRandomNumberGenerator;
import bridge.views.InputView;
import bridge.views.OutputView;

public class Controller {
    public static final String RESTART = "R";

    public static BridgeGame makeBridgeMap() {
        int bridgeSize;
        while (true) {
            try {
                bridgeSize = InputView.readBridgeSize();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return new BridgeGame(bridgeMaker, bridgeSize);
    }

    public static void startRound(BridgeGame bridgeGame, OutputView outputView) {
        do {
            String directions;
            while (true) {
                try {
                    directions = InputView.readMoving();
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            bridgeGame.move(directions);
            outputView.printMap(directions, bridgeGame.checkStatus(directions));

            if (bridgeGame.gameSuccess()) {
                break;
            }
        } while (bridgeGame.isGameContinue());
    }

    public static void restartGame(BridgeGame bridgeGame) {
        String gameCommand;
        while (true) {
            try {
                gameCommand = InputView.readGameCommand();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        if (gameCommand.equals(RESTART)) {
            bridgeGame.retry();
        }
    }
}