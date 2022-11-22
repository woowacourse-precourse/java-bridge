package bridge.controller.game;

import bridge.controller.service.BridgeService;
import bridge.domain.game.BridgeGame;
import bridge.BridgeMaker;
import bridge.domain.game.BridgeMap;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.OutputView;

public class BridgeController {

    private final BridgeMap bridgeMap = new BridgeMap();
    private final BridgeGame game;
    private final BridgeService service;

    public BridgeController() {
        final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        service = new BridgeService();
        game = new BridgeGame(bridgeMaker.makeBridge(service.takeSize()));
    }

    public void play() {
        OutputView.printGameStart();
        attemptGameClear();
        OutputView.printResult(bridgeMap.toString(),
                game.successOrNot(), game.getNumberOfAttempts());
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
}
