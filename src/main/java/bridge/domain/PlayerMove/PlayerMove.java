package bridge.domain.PlayerMove;

import bridge.domain.gameManagement.BridgeState;
import bridge.view.InputView;

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

    public static int moveOneStep(int currentLocation, List<String> bridge, List<String> currentBridge) {
        String movingPosition = takeMovingPosition();

        if (!movingPosition.equals(bridge.get(currentLocation))) {
            currentLocation = moveFail(currentBridge, bridge, currentLocation);
        }

        if (movingPosition.equals(bridge.get(currentLocation))) {
            currentLocation = moveSuccess(currentBridge, movingPosition, currentLocation);
        }

        return currentLocation;
    }

    public static int moveFail(List<String> currentBridge, List<String> bridge, int currentLocation) {
        String stateOfBridgeLine = bridge.get(currentLocation);
        Arrays.stream(BridgeState.values())
                .filter(bridgeState -> bridgeState.getMovablePosition().equals(stateOfBridgeLine))
                .forEach(bridgeState -> currentBridge.add(bridgeState.getFailedBridgeState()));

        currentLocation++;
        return currentLocation;
    }

    public static int moveSuccess(List<String> currentBridge, String movingPosition, int currentLocation) {
        Arrays.stream(BridgeState.values())
                .filter(bridgeState -> bridgeState.getMovablePosition().equals(movingPosition))
                .forEach(bridgeState -> currentBridge.add(bridgeState.getSuccessfulBridgeState()));

        currentLocation++;
        return currentLocation;
    }
}
