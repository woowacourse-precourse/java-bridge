package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.MapMaker;
import bridge.view.InputView;
import bridge.view.OutputView;


import java.util.List;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    MapMaker mapMaker = new MapMaker();
    BridgeGame bridgeGame;

    boolean hasMoved;
    boolean hasRetried;
    boolean hasWin;


    private void makeBridgeByInput() {
        try {
            bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        } catch (IllegalArgumentException e) {
            outputView.printErrorNotice(e);
            makeBridgeByInput();
        }
    }


    public void start() {
        outputView.printStartNotice();
        outputView.printBridgeSizeInputNotice();
        makeBridgeByInput();
    }

    public void play() {
        do {
            outputView.printMovingDirectionInputNotice();
            hasMoved = moveByInput();
            outputView.printMap(mapMaker.makeMap(bridgeGame.getUserBridgeHistroy(), hasMoved));
            if (bridgeGame.checkWin()) {
                break;
            }
        } while (hasMoved);
    }

    private boolean moveByInput() {
        try {
            String moving = inputView.readMoving();
            return bridgeGame.move(moving);
        } catch (IllegalArgumentException e) {
            outputView.printErrorNotice(e);
            return moveByInput();
        }
    }


    public void reTry() {
        outputView.printRestartOrQuitInputNotice();
        hasRetried = retryByInput();
    }

    private boolean retryByInput() {
        try {
            String gameCommand = inputView.readGameCommand();
            return bridgeGame.retry(gameCommand);
        } catch (IllegalArgumentException e) {
            outputView.printErrorNotice(e);
            return retryByInput();
        }
    }

    public void end() {
        List<String> map = mapMaker.makeMap(bridgeGame.getUserBridgeHistroy(), hasMoved);
        outputView.printResult(map, bridgeGame.checkWin(), bridgeGame.getTryCount());
    }

    public void run() {
        start();
        do {
            play();
            if (bridgeGame.checkWin()) {
                break;
            }
            reTry();
        } while (hasRetried);
        end();
    }

}
