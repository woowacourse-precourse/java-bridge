package bridge.domain.PlayerMove;

import bridge.domain.gameManagement.BridgeState;
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

    public static int moveOneStep(int currentLocation, List<String> bridge, List<String> currentBridge) {
        String movingPosition = takeMovingPosition();

        if (!movingPosition.equals(bridge.get(currentLocation))) {
            return moveFail(currentBridge, bridge, currentLocation);
        }

        return moveSuccess(currentBridge, movingPosition, currentLocation);
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
