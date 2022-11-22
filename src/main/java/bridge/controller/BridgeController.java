package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.utils.BridgeNumberGenerator;
import bridge.utils.BridgeRandomNumberGenerator;
import bridge.utils.ErrorMessage;
import bridge.utils.Setting;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

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
            if (!bridgeGame.isGameContinue()) {
                break;
            }
        } while (bridgeGame.isGameSuccess());
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

    public static void restartOrQuitGame(BridgeGame bridgeGame, OutputView outputView) {
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