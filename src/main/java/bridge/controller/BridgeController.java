package bridge.controller;

import bridge.domain.BridgeGameMachine;
import bridge.domain.BridgeGameResult;
import bridge.domain.BridgeGameTotalResult;
import bridge.domain.BridgeMaker;
import bridge.domain.generator.BridgeRandomNumberGenerator;

import java.util.List;

import static bridge.view.InputView.*;
import static bridge.view.OutputView.*;

public class BridgeController {
    private final BridgeMaker bridgeMaker;
    private final BridgeGameMachine bridgeGameMachine;

    public BridgeController(BridgeRandomNumberGenerator bridgeRandomNumberGenerator) {
        this.bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        this.bridgeGameMachine = new BridgeGameMachine();
    }

    public void start() {
        try {
            printStartMessage();
            BridgeGameTotalResult bridgeGameTotalResult = play(createBridge());
            printResult(bridgeGameTotalResult);
        } catch (IllegalArgumentException error) {
            printErrorMessage(error.getMessage());
        }
    }

    private BridgeGameTotalResult play(List<String> bridge) {
        BridgeGameTotalResult bridgeGameTotalResult = new BridgeGameTotalResult();
        createGameResult(bridgeGameTotalResult, bridge);
        return bridgeGameTotalResult;
    }

    private void createGameResult(BridgeGameTotalResult bridgeGameTotalResult, List<String> bridge) {
        BridgeGameResult bridgeGameResult;
        int bridgeIndex = 0;
        do {
            bridgeGameResult = bridgeGameMachine.computeGameResult(readMoving(), bridge.get(bridgeIndex));
            bridgeIndex += 1;
        } while (isContinue(bridgeGameResult));
    }

    private void addGameResult(BridgeGameResult bridgeGameResult, BridgeGameTotalResult bridgeGameTotalResult) {
    }

    private boolean isContinue(BridgeGameResult bridgeGameResult) {
        return bridgeGameResult.getIsMatched();
    }

    private List<String> createBridge() {
        return bridgeMaker.makeBridge(readBridgeSize().getBridgeSize());
    }
}
