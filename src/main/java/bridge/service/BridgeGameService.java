package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameService {
    private static final String RESTART_GAME = "R";
    private static final String END_GAME = "Q";
    private static final String GAME_FAIL = "실패";
    private static final String GAME_SUCCESS = "성공";
    static InputView input = new InputView();
    static OutputView output = new OutputView();
    static int bridgeSize;
    static List<String> crossByBridge;
    static Bridge bridge;
    static BridgeGame bridgeGame;

    public BridgeGameService() {
    }

    public BridgeGameService(List<String> crossByBridge) {
        BridgeGameService.crossByBridge = crossByBridge;
        bridgeSize = crossByBridge.size();
    }

    public void startBridgeGame() {
        output.printStartBridgeGame();
        bridge = new Bridge();
        bridgeGame = new BridgeGame(bridge);
        output.printEnterBridgeLength(); // 다리의 길이를 입력해주세요.
    }
}
