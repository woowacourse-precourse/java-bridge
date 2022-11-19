package bridge;

import bridge.models.BridgeGame;
import bridge.models.BridgeMaker;
import bridge.utils.BridgeNumberGenerator;
import bridge.utils.BridgeRandomNumberGenerator;
import bridge.utils.Setting;
import bridge.views.InputView;
import bridge.views.OutputView;

public class Controller {

    public static BridgeGame makeBridgeMap() {
        int bridgeSize = getBridgeSize();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return new BridgeGame(bridgeMaker, bridgeSize);
    }

    public static int getBridgeSize() {
        try {
            return InputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBridgeSize();
        }
    }

    public static void startRound(BridgeGame bridgeGame, OutputView outputView) {
        do {
            String directions = getMovingDirection();
            bridgeGame.move(directions);
            outputView.printMap(directions, bridgeGame.checkStatus(directions), bridgeGame.getBridgeIndex());
            if (bridgeGame.gameSuccess()) {
                break;
            }
        } while (bridgeGame.isGameContinue());
    }

    public static String getMovingDirection() {
        while (true) {
            try {
                return InputView.readMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void restartGame(BridgeGame bridgeGame) {
        String gameCommand = getGameCommand();
        if (gameCommand.equals(Setting.GAME_RESTART)) {
            bridgeGame.retry();
        }
    }

    public static String getGameCommand() {
        try {
            return InputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getGameCommand();
        }
    }
}