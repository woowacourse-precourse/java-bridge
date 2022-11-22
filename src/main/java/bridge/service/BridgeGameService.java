package bridge.service;

import bridge.domain.InputValidator;
import bridge.domain.game.BridgeGame;
import bridge.domain.game.GameMode;
import bridge.domain.generator.BridgeMaker;
import bridge.domain.generator.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameService {
    private static final String EMPTY_MAP = "";
    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator validator;
    private BridgeGame game;

    public BridgeGameService() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        inputView = new InputView();
        validator = new InputValidator();
        outputView = new OutputView();
    }

    public void start() {
        int size = validator.returnNum(inputView.readBridgeSize());
        List<String> answerBridge = bridgeMaker.makeBridge(size);
        game = new BridgeGame(answerBridge);
        run();
    }

    private void run() {
        String map = EMPTY_MAP;
        while (map.equals(EMPTY_MAP)) {
            map = go(EMPTY_MAP);
        }
        outputView.printResult(map, game.isSuccess(), game.getTotalTrial());
    }

    private String go(String map) {
        if (game.getBridge().bridgeEnd()) {
            return map;
        }
        map = move();

        if (!game.isSuccess()) {
            return isRetry(map);
        }
        return go(map);
    }

    private String isRetry(String map) {
        if (retry()) {
            return EMPTY_MAP;
        }
        game.setSuccess(false);
        return map;
    }

    private String move() {
        String map = game.move(inputView.readMoving());
        outputView.printMap(map);
        return map;
    }

    private boolean retry() {
        String gameMode = inputView.readGameCommand();
        validator.checkRetry(gameMode);
        if (gameMode.equals(GameMode.RETRY.getKey())) {
            game.retry();
            return true;
        }
        return false;
    }
}
