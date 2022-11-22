package bridge.domain.PlayerMove;

import bridge.domain.gameManagement.BridgeGame;
import bridge.domain.gameManagement.BridgeState;
import bridge.domain.gameOver.GameRestartOrQuit;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class PlayerMove {
    private static final String GAME_COMMAND_RESTART = "R";
    private static final int ONE_INDEX = 1;

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

    public static void repeatGame(List<String> bridge, List<String> currentBridge, int currentLocation) {
        int count = 0;
        while (true) {
            count++;
            int updatedCurrentLocation = handlePlayerMove(currentLocation, bridge, currentBridge);

            if (count == 5) {
                break;
            }
            currentLocation = updatedCurrentLocation;
        }
    }

    public static int handlePlayerMove(int currentLocation, List<String> bridge, List<String> currentBridge) {
        currentLocation = crossBridgeUntilFailOrEnd(currentLocation, bridge, currentBridge);

        int currentLocationForRestart = handleIntermediateFailure(currentLocation, bridge, currentBridge);

        return currentLocationForRestart;
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

    public static int handleIntermediateFailure(int currentLocation, List<String> bridge, List<String> currentBridge) {
        if (currentLocation <= bridge.size()) {
            String gameRestartOrQuitCommand = GameRestartOrQuit.takeGameRestartOrQuitCommand();

            BridgeGame bridgeGame = new BridgeGame();
            currentLocation = bridgeGame.retry(gameRestartOrQuitCommand, currentLocation, currentBridge);
        }

        return currentLocation;
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

    public static int checkGameRestartOrQuitCommand(String gameRestartOrQuitCommand, int currentLocation, List<String> currentBridge) {
        if (gameRestartOrQuitCommand.equals(GAME_COMMAND_RESTART)) {
            currentLocation--;
            int lastFailedStateLocation = currentBridge.size() - ONE_INDEX;
            currentBridge.remove(lastFailedStateLocation);
        }
        return currentLocation;
    }
}
