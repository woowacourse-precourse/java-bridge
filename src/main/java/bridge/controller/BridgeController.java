package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMatcher;
import bridge.domain.GameResult;
import bridge.validator.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeController {

    public void startGame() {
        List<String> bridge = generateBridge();
        BridgeMatcher bridgeMatcher = makeBridgeMatcher();
        OutputView outputView = makeResultBridge();
        BridgeGame bridgeGame = startBridgeGame(bridge, bridgeMatcher);
        while (!bridgeMatcher.isGameSuccess(bridge)) {
            boolean isReStart = runGame(bridgeGame, outputView, bridgeMatcher);
            if (!isReStart) break;
        }
        outputView.printResult(bridge, bridgeMatcher);
    }

    private boolean reStarGame(BridgeGame bridgeGame, OutputView outputView, BridgeMatcher bridgeMatcher) {
        String command = InputView.readGameCommand();
        if (command.equals(Validator.GAME_RESTART_COMMAND)) {
            bridgeGame.retry();
            runGame(bridgeGame, outputView, bridgeMatcher);
        }
        if (command.equals(Validator.GAME_QUIT_COMMAND)) {
            return false;
        }
        return true;
    }

    private boolean runGame(BridgeGame bridgeGame, OutputView outputView, BridgeMatcher bridgeMatcher) {
        String moving = InputView.readMoving();
        boolean isMatch = bridgeGame.move(moving);
        outputView.printMap(moving, isMatch, bridgeMatcher);
        boolean isReStart = true;
        if (!bridgeMatcher.getLatestTry()) {
            isReStart = reStarGame(bridgeGame, outputView, bridgeMatcher);
        }
        return isReStart;
    }

    private BridgeGame startBridgeGame(List<String> bridge, BridgeMatcher bridgeMatcher) {
        return new BridgeGame(bridge, bridgeMatcher);
    }

    private OutputView makeResultBridge() {
        String upBridge = "";
        String downBridge = "";
        GameResult gameResult = new GameResult(upBridge, downBridge);
        return new OutputView(gameResult);
    }

    private BridgeMatcher makeBridgeMatcher() {
        List<Boolean> matchedBridge = new ArrayList<>();
        int firstTry = 1;
        return new BridgeMatcher(matchedBridge, firstTry);
    }

    private List<String> generateBridge() {
        OutputView.printGameStart();
        int size = InputView.readBridgeSize();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        return bridgeMaker.makeBridge(size);
    }
}