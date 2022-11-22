package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameService {
    private static final String RESTART_GAME = "R";
    private static final String GAME_FAIL = "실패";
    private static final String GAME_SUCCESS = "성공";
    private static final String CAN_NOT_MOVING = "X";
    private static final int START_BRIDGE_INDEX = 0;
    private static List<String> crossByBridge;
    private static Bridge bridge;
    private static BridgeGame bridgeGame;
    private InputView input = new InputView();
    private OutputView output = new OutputView();
    private int bridgeSize;

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
        output.printEnterBridgeSize();
    }

    public void playBridgeGame() {
        bridgeGame = new BridgeGame(new ArrayList<>(), bridgeGame.getTotalGame(), bridge);
        moveCrossBridge();
        if (checkRestartCondition(bridgeGame.getMovingCount())) {
            return;
        }
        output.printResult(GAME_SUCCESS, bridgeGame.getTotalGame(), bridge.getLastBridge());
    }

    private void moveCrossBridge() {
        int moveIndex = START_BRIDGE_INDEX;
        boolean movingResult = true;
        while (moveIndex < bridgeSize && movingResult) {
            output.printSelectMoveDirection();
            String movingInput = input.readMoving();
            movingResult = bridgeGame.move(crossByBridge.get(moveIndex), movingInput);
            bridgeGame.setMovingResult(crossByBridge.get(moveIndex++), movingInput);
            output.printMap(bridge);
        }
    }

    private boolean checkRestartCondition(int movingCount) {
        if (movingCount != crossByBridge.size() || bridgeGame.getLastMoving().equals(CAN_NOT_MOVING)) {
            bridgeGame = new BridgeGame(new ArrayList<>(), bridgeGame.getTotalGame(), bridge);
            selectGameRestart();
            return true;
        }
        return false;
    }

    private void selectGameRestart() {
        output.printEnterGameCommand();
        String gameCommand = input.readGameCommand();

        if (gameCommand.equals(RESTART_GAME)) {
            bridgeGame.retry();
            playBridgeGame();
            return;
        }
        output.printResult(GAME_FAIL, bridgeGame.getTotalGame(), bridge.getLastBridge());
    }
}
