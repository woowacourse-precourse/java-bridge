package bridge.domain.PlayerMove;

import bridge.domain.gameManagement.BridgeState;
import bridge.domain.gameOver.GameRestartOrQuit;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class PlayerMove {
    public static String takeMovingPosition() {
        InputView inputView = new InputView();
        String movingPosition = inputView.readMoving();

        try {
            PlayerMoveValidator.validate(movingPosition);
            return movingPosition;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return takeMovingPosition();
        }
    }

    public static int handlePlayerMove(int currentLocation, List<String> bridge, List<String> currentBridge) {
        currentLocation = crossBridgeUntilFailOrEnd(currentLocation, bridge, currentBridge);

        String restartOrEndCommand = handleIntermediateFailure(currentLocation, bridge);

        return currentLocation;
    }

    public static int crossBridgeUntilFailOrEnd (int currentLocation, List<String> bridge, List<String> currentBridge) {
        while (currentLocation < bridge.size()) {
            String movingPosition = takeMovingPosition();

            if (!movingPosition.equals(bridge.get(currentLocation))) {
                currentLocation = moveFail(currentBridge, bridge, currentLocation);
                break;
            }
            currentLocation = moveSuccess(currentBridge, movingPosition, currentLocation);
        }
        return currentLocation;
    }

    public static String handleIntermediateFailure(int currentLocation, List<String> bridge) {
        String gameRestartOrQuitCommand = null;

        if (currentLocation <= bridge.size()) {
            gameRestartOrQuitCommand = GameRestartOrQuit.takeGameRestartOrQuitCommand();
        }
        return gameRestartOrQuitCommand;
    }

    public static int moveFail(List<String> currentBridge, List<String> bridge, int currentLocation) {
        OutputView outputView = new OutputView();

        String stateOfBridgeLine = bridge.get(currentLocation);
        Arrays.stream(BridgeState.values())
                .filter(bridgeState -> bridgeState.getMovablePosition().equals(stateOfBridgeLine))
                .forEach(bridgeState -> currentBridge.add(bridgeState.getFailedBridgeState()));

        currentLocation++;
        outputView.printMap(currentBridge);
        return currentLocation;
    }

    public static int moveSuccess(List<String> currentBridge, String movingPosition, int currentLocation) {
        OutputView outputView = new OutputView();

        Arrays.stream(BridgeState.values())
                .filter(bridgeState -> bridgeState.getMovablePosition().equals(movingPosition))
                .forEach(bridgeState -> currentBridge.add(bridgeState.getSuccessfulBridgeState()));

        currentLocation++;
        outputView.printMap(currentBridge);
        return currentLocation;
    }
}
