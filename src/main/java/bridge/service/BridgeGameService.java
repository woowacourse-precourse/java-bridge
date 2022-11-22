package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.utils.Constants;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameService {
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
        output.printResult(Constants.GAME_SUCCESS, bridgeGame.getTotalGame(), bridge.getLastBridge());
    }

    private void moveCrossBridge() {
        int moveIndex = Constants.START_BRIDGE_INDEX;
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
        if (movingCount != crossByBridge.size() || bridgeGame.getLastMoving().equals(Constants.CAN_NOT_MOVING)) {
            bridgeGame = new BridgeGame(new ArrayList<>(), bridgeGame.getTotalGame(), bridge);
            selectGameRestart();
            return true;
        }
        return false;
    }

    private void selectGameRestart() {
        output.printEnterGameCommand();
        String gameCommand = input.readGameCommand();

        if (gameCommand.equals(Constants.RESTART_GAME)) {
            bridgeGame.retry();
            playBridgeGame();
            return;
        }
        output.printResult(Constants.GAME_FAIL, bridgeGame.getTotalGame(), bridge.getLastBridge());
    }
}
