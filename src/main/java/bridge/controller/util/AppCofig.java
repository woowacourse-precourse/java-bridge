package bridge.controller.util;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeSizeGenerator;
import bridge.GameOverChecker;
import bridge.GameRetryChecker;
import bridge.GameWinChecker;
import bridge.MovementStatusCalculator;
import bridge.controller.BridgeGameController;
import bridge.service.BridgeGame;
import bridge.service.GameChecker;

public class AppCofig {

    public static BridgeGameController createBridgeGameController() {
        return new BridgeGameController(createBridgeGame(), createGameChecker());
    }

    public static GameChecker createGameChecker() {
        return new GameChecker(createGameOverChecker(), createGameWinChecker());
    }

    private static GameOverChecker createGameOverChecker() {
        return new GameOverChecker();
    }

    private static GameWinChecker createGameWinChecker() {
        return new GameWinChecker();
    }

    public static BridgeGame createBridgeGame() {
        return new BridgeGame(new MovementStatusCalculator(), new GameRetryChecker());
    }

    public static BridgeMaker createBridgeMaker() {
        return new BridgeMaker(createBridgeNumberGenerator());
    }

    private static BridgeNumberGenerator createBridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    public static BridgeSizeGenerator createBridgeSizeGenerator() {
        return new BridgeSizeGenerator();
    }


}
