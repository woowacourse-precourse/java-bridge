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

    public static BridgeGame startGame() {
        System.out.printf("다리 건너기 게임을 시작합니다.%n%n");
        int bridgeSize = requestBridgeSize();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return new BridgeGame(bridgeMaker, bridgeSize);
    }

    public static int requestBridgeSize() {
        try {
            return InputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            ErrorMessage.print(e.getMessage());
            return requestBridgeSize();
        }
    }

    public static void startRound(BridgeGame bridgeGame, OutputView outputView) {
        do {
            String direction = requestMovingDirection();
            bridgeGame.move(direction);
            outputView.printMap(bridgeGame, direction);
            if (bridgeGame.isGameSuccess()) {
                outputView.printResult(bridgeGame);
                break;
            }
        } while (bridgeGame.isGameContinue());
    }

    public static String requestMovingDirection() {
        while (true) {
            try {
                return InputView.readMoving();
            } catch (IllegalArgumentException e) {
                ErrorMessage.print(e.getMessage());
            }
        }
    }

    public static void restartGame(BridgeGame bridgeGame, OutputView outputView) {
        String gameCommand = requestGameCommand();
        if (gameCommand.equals(Setting.GAME_RESTART)) {
            bridgeGame.retry();
            return;
        }
        outputView.printResult(bridgeGame);
    }

    public static String requestGameCommand() {
        try {
            return InputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            ErrorMessage.print(e.getMessage());
            return requestGameCommand();
        }
    }
}