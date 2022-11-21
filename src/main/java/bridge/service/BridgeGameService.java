package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
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

    public void playBridgeGame() {
        bridgeGame = new BridgeGame(new ArrayList<>(), bridgeGame.getTotalGame(), bridge); // 게임 시작
        moveCrossBridge();
        if (checkRestartCondition(bridgeGame.getMovingCount())) { // 게임 재시작
            return;
        }
        output.printResult(GAME_SUCCESS, bridgeGame.getTotalGame(), bridge.getLastBridge()); // 최종 결과 입력(게임 성공, 게임횟수)
    }

    private void moveCrossBridge() {
        int moveIndex = 0;
        boolean movingResult = true;
        while (moveIndex < bridgeSize && movingResult) {
            output.printSelectMoveDirection(); // 이동할 칸을 선택해주세요.
            String movingInput = input.readMoving();
            movingResult = bridgeGame.move(crossByBridge.get(moveIndex), movingInput);
            bridgeGame.setMovingResult(crossByBridge.get(moveIndex++), movingInput);
            output.printMap(bridge);
        }
    }
}
