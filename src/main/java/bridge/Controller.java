package bridge;

import bridge.models.BridgeGame;
import bridge.models.BridgeMaker;
import bridge.models.BridgeNumberGenerator;
import bridge.models.BridgeRandomNumberGenerator;
import bridge.utils.ErrorMessage;
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
            ErrorMessage.print(e.getMessage());
            return getBridgeSize();
        }
    }

    public static void startRound(BridgeGame bridgeGame, OutputView outputView) {
        do {
            String direction = getMovingDirection();
            bridgeGame.move(direction);
            outputView.printMap(bridgeGame, direction);
            if (bridgeGame.isGameSuccess()) {
                break;
            }
        } while (bridgeGame.isGameContinue());
    }

    public static String getMovingDirection() {
        while (true) {
            try {
                return InputView.readMoving();
            } catch (IllegalArgumentException e) {
                ErrorMessage.print(e.getMessage());
            }
        }
    }

    public static void restartRound(BridgeGame bridgeGame) {
        String gameCommand = getGameCommand();
        if (gameCommand.equals(Setting.GAME_RESTART)) {
            bridgeGame.retry();
        }
    }

    public static String getGameCommand() {
        try {
            return InputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            ErrorMessage.print(e.getMessage());
            return getGameCommand();
        }
    }
}