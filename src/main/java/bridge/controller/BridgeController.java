package bridge.controller;

import bridge.constant.BridgeGameConstants;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeMap;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.Checker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final Checker checker = Checker.getInstance();
    private final BridgeMap bridgeMap = new BridgeMap();
    private final BridgeGame game;

    public BridgeController() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        game = new BridgeGame(bridgeMaker.makeBridge(takeSize()));
    }

    public void play() {
        OutputView.printGameStart();
        attemptGameClear();
        OutputView.printResult(bridgeMap.getBridgeMap(), game.successOrNot(), game.getNumberOfAttempts());
    }

    private void attemptGameClear() {
        move();
        while (game.over() && retry()) {    // 두 함수 순서 바꾸면 오류발생
            game.retry(bridgeMap);
            move();
        }
    }

    private boolean retry() {
        try {
            String retryOrNot = InputView.readGameCommand();
            checker.validateGameCommand(retryOrNot);
            return retryOrNot.equals(BridgeGameConstants.GAME_RETRY);
        } catch (IllegalArgumentException e) {
            return handlingGameCommandException(e);
        }
    }

    private void move() {
        do {
            String direction = decideDirection();
            game.move(direction);
            bridgeMap.update(direction, game.over());
            OutputView.printMap(bridgeMap.getBridgeMap());
        } while (game.inProgress());
    }

    private String decideDirection() {
        try {
            String direction = InputView.readMoving();
            checker.validateMoving(direction);
            return direction;
        } catch (IllegalArgumentException e) {
            return handlingMovingException(e);
        }
    }

    private int takeSize() { //
        try {
            String bridgeSize = InputView.readBridgeSize();
            checker.validateBridgeSize(bridgeSize);
            return Integer.parseInt(bridgeSize);
        } catch (IllegalArgumentException e) {
            return handlingBridgeSizeException(e);
        }
    }

    private String handlingMovingException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
        return decideDirection();
    }

    private boolean handlingGameCommandException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
        return retry();
    }

    private int handlingBridgeSizeException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
        return takeSize();
    }
}
