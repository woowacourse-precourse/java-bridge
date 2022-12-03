package bridge.controller.game;

import bridge.constant.Bridge;
import bridge.constant.Message.LogicExceptionMessage;
import bridge.controller.service.BridgeCommunication;
import bridge.domain.game.BridgeGame;
import bridge.BridgeMaker;
import bridge.domain.game.BridgeMap;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.OutputView;

public class BridgeController {

    private final BridgeMap bridgeMap = new BridgeMap();
    private final BridgeGame game;
    private final BridgeCommunication service;

    public BridgeController() {
        final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.service = new BridgeCommunication();
        this.game = new BridgeGame(bridgeMaker.makeBridge(service.takeSize()));
    }

    public void play() {
        OutputView.printGameStart();
        attemptGameClear();
        OutputView.printResult(bridgeMap.toString(),
                findOutSuccessOrNot(), game.getNumberOfAttempts());
    }


    private void attemptGameClear() {
        move();
        while (game.over() && service.retry()) {    // 두 함수 순서 바꾸면 오류발생
            game.retry(bridgeMap);
            move();
        }
    }

    private void move() {
        while (game.inProgress()) {
            final String direction = service.decideDirection();
            game.move(direction);
            bridgeMap.update(direction, game.over());
            OutputView.printMap(bridgeMap.toString());
        }
    }
    private String findOutSuccessOrNot() {
        if (game.inProgress()) {
            throw new IllegalStateException(LogicExceptionMessage.WRONG_USE_SUCCESS_OR_NOT);
        }
        if (game.success()) {
            return Bridge.GameConstants.GAME_SUCCESS;
        }
        return Bridge.GameConstants.GAME_FAILURE;
    }
}
