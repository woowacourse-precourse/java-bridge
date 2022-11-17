package bridge.controller;

import bridge.domain.*;
import bridge.domain.generator.BridgeRandomNumberGenerator;
import bridge.domain.vo.GameCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static bridge.view.InputView.*;
import static bridge.view.OutputView.*;

public class BridgeController {
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;

    private final String QUIT_CONDITION = "Q";

    public BridgeController(BridgeRandomNumberGenerator bridgeRandomNumberGenerator) {
        this.bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        this.bridgeGame = new BridgeGame();
    }

    public void start() {
        try {
            printStartMessage();
            List<BridgeGameResult> bridgeGameResults = play(createBridge());
            printResult(bridgeGameResults);
        } catch (IllegalArgumentException error) {
            printErrorMessage(error.getMessage());
        }
    }

    private List<BridgeGameResult> play(List<String> bridge) {
        List<BridgeGameResult> bridgeGameResults = tryOnce(bridge);
        if (!isSuccess(bridgeGameResults, bridge.size())) {
            bridgeGame.retry();
        }
        return bridgeGameResults;
    }

    private List<BridgeGameResult> tryOnce(List<String> bridge) {
        List<BridgeGameResult> bridgeGameResults = new ArrayList<>();
        do {
            bridgeGameResults.clear();
            createGameResult(bridgeGameResults, bridge);
        } while (isRetry());
        return bridgeGameResults;
    }

    private void createGameResult(List<BridgeGameResult> bridgeGameResults, List<String> bridge) {
        BridgeGameResult bridgeGameResult;
        int bridgeIndex = 0;
        do {
            bridgeGameResult = bridgeGame.move(bridge, bridgeIndex);
            bridgeIndex += 1;
            addGameResult(bridgeGameResult, bridgeGameResults);
            printMap(bridgeGameResults);
        } while (isContinue(bridgeGameResult, bridgeIndex, bridge.size()));
    }

    private void addGameResult(BridgeGameResult bridgeGameResult, List<BridgeGameResult> bridgeGameResults) {
        bridgeGameResults.add(bridgeGameResult);
    }

    private boolean isContinue(BridgeGameResult bridgeGameResult, int bridgeIndex, int bridgeSize) {
        if (bridgeIndex == bridgeSize){
            return false;
        }
        return bridgeGameResult.getIsMatched();
    }

    private boolean isSuccess(List<BridgeGameResult> bridgeGameResults, int bridgeSize) {
        if (bridgeGameResults.size() == bridgeSize) {
            return true;
        }
        return false;
    }

    private List<String> createBridge() {
        return bridgeMaker.makeBridge(readBridgeSize().getBridgeSize());
    }
}
