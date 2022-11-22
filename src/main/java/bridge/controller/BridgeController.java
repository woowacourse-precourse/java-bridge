package bridge.controller;

import bridge.domain.*;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.vo.BridgeGameResult;

import java.util.ArrayList;
import java.util.List;

import static bridge.domain.BridgeGame.RETRY_COUNT;
import static bridge.view.InputView.*;
import static bridge.view.OutputView.*;

public class BridgeController {
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;


    public BridgeController(BridgeRandomNumberGenerator bridgeRandomNumberGenerator) {
        this.bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        this.bridgeGame = new BridgeGame();
    }

    public void start() {
        try {
            init();
            List<String> bridge = createBridge();
            List<BridgeGameResult> bridgeGameResults = play(bridge);
            printResult(bridgeGameResults, bridge.size());
        } catch (IllegalArgumentException error) {
            printErrorMessage(error.getMessage());
        }
    }

    private void init() {
        printStartMessage();
        RETRY_COUNT = 1;
    }

    private List<BridgeGameResult> play(List<String> bridge) {
        List<BridgeGameResult> bridgeGameResults = tryOnce(bridge);
        return bridgeGameResults;
    }

    private List<BridgeGameResult> tryOnce(List<String> bridge) {
        List<BridgeGameResult> bridgeGameResults = new ArrayList<>();
        do {
            bridgeGameResults.clear();
            determineResultByMoving(bridgeGameResults, bridge);
        } while (bridgeGame.retry(bridgeGameResults, bridge.size()));
        return bridgeGameResults;
    }

    private void determineResultByMoving(List<BridgeGameResult> bridgeGameResults, List<String> bridge) {
        BridgeGameResult bridgeGameResult;
        int bridgeIndex = 0;
        do {
            bridgeGameResult = bridgeGame.move(bridge, bridgeIndex);
            bridgeIndex += 1;
            addGameResult(bridgeGameResult, bridgeGameResults);
            printMap(bridgeGameResults);
        } while (bridgeGame.isContinue(bridgeGameResult, bridgeIndex, bridge.size()));
    }

    private void addGameResult(BridgeGameResult bridgeGameResult, List<BridgeGameResult> bridgeGameResults) {
        bridgeGameResults.add(bridgeGameResult);
    }

    private List<String> createBridge() {
        return bridgeMaker.makeBridge(readBridgeSize().getBridgeSize());
    }
}
