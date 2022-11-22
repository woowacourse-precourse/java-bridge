package bridge.controller;

import bridge.domain.*;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final Bridge bridge;
    private final BridgeGame bridgeGame;
    private RepeatCount repeatCount;
    private BridgeIndex bridgeIndex;

    public BridgeGameController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        outputView.printGameStart();
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridge = setBridge(bridgeMaker);
        this.bridgeGame = new BridgeGame(bridge, GameStatus.RUNNING, new MapPrinter());
        this.repeatCount = RepeatCount.initRepeatCount();
        this.bridgeIndex = BridgeIndex.initIndex();
    }

    public void play() {
        while (repeatCount.getCount() != bridge.getSize()) {
            bridgeIndex.increment();
            Position position = inputView.readMoving();
            MapPrinter mapPrinter = getMapPrinter(position);
            GameStatus gameStatus = getStatus(position, bridge, bridgeIndex.getIndex());
            if (gameStatus == GameStatus.FAIL) {
                replay(mapPrinter);
                continue;
            }
            if (gameStatus == GameStatus.SUCCESS) {
                outputView.printResult(mapPrinter, gameStatus, repeatCount);
                return;
            }
        }

    }

    private MapPrinter getMapPrinter(Position position) {
        MapPrinter mapPrinter = bridgeGame.move(position, bridge, bridgeIndex);
        outputView.printMap(mapPrinter);
        return mapPrinter;
    }

    private void replay(MapPrinter mapPrinter) {
        RetryCommand retryCommand = inputRetry();
        if (retryCommand.isRetry()) {
            bridgeGame.retry(mapPrinter, repeatCount);
            bridgeIndex = BridgeIndex.initIndex();
        }
    }

    public GameStatus getStatus(Position position, Bridge bridge, int index) {
        if (bridgeIndex.getIndex() + 1 == bridge.getSize()) {
            return GameStatus.SUCCESS;
        }

        if (position.getCommand().equals(bridge.getValue(index))) {
            return GameStatus.RUNNING;
        }

        return GameStatus.FAIL;
    }

    private void move(Position position) {
        getMapPrinter(position);
        repeatCount.increment();
    }

    private Bridge setBridge(BridgeMaker bridgeMaker) {
        BridgeSize bridgeSize = inputView.readBridgeSize();
        return new Bridge(bridgeMaker.makeBridge(bridgeSize.getSize()));
    }

    private RetryCommand inputRetry() {
        return inputView.readGameCommand();
    }
}
