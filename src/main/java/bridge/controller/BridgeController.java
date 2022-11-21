package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeMap;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.BridgeServices;
import bridge.view.OutputView;

public class BridgeController {


    private final BridgeMap bridgeMap = new BridgeMap();
    private final BridgeGame game;
    private final BridgeServices service;

    public BridgeController() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        service = new BridgeServices();
        game = new BridgeGame(bridgeMaker.makeBridge(service.takeSize()));
    }

    public void play() {
        OutputView.printGameStart();
        attemptGameClear();
        OutputView.printResult(bridgeMap.getBridgeMap(), game.successOrNot(), game.getNumberOfAttempts());
    }

    private void attemptGameClear() {
        move();
        while (game.over() && service.retry()) {    // 두 함수 순서 바꾸면 오류발생
            game.retry(bridgeMap);
            move();
        }
    }

    private void move() {
        do {
            String direction = service.decideDirection();
            game.move(direction);
            bridgeMap.update(direction, game.over());
            OutputView.printMap(bridgeMap.getBridgeMap());
        } while (game.inProgress());
    }
}
