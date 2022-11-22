package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 게임의 현재 상태에 맞는 다리를 만드는 역할을 한다.
 */
public class BridgeStatus {

    private final List<String> bridgeFirstLayer = new ArrayList<>();
    private final List<String> bridgeSecondLayer = new ArrayList<>();
    private List<List<String>> bridgeStatusLayers;

    public void correctToBridge(String status) {
        if (status.equals(MoveStatus.UP_CORRECT.get())) {
            this.bridgeStatusLayers = upCorrect();
        }

        if (status.equals(MoveStatus.DOWN_CORRECT.get())) {
            this.bridgeStatusLayers = downCorrect();
        }
    }

    public void incorrectToBridge(String status) {
        if (status.equals(MoveStatus.UP_INCORRECT.get())) {
            this.bridgeStatusLayers = upIncorrect();
        }

        if (status.equals(MoveStatus.DOWN_INCORRECT.get())) {
            this.bridgeStatusLayers = downIncorrect();
        }
    }

    public List<List<String>> upCorrect() {
        bridgeFirstLayer.add(Status.MOVING_CORRECT.get());
        bridgeSecondLayer.add(Status.NO_MOVING.get());

        return Arrays.asList(bridgeFirstLayer, bridgeSecondLayer);
    }

    public List<List<String>> upIncorrect() {
        bridgeFirstLayer.add(Status.MOVING_INCORRECT.get());
        bridgeSecondLayer.add(Status.NO_MOVING.get());

        return Arrays.asList(bridgeFirstLayer, bridgeSecondLayer);
    }

    public List<List<String>> downCorrect() {
        bridgeFirstLayer.add(Status.NO_MOVING.get());
        bridgeSecondLayer.add(Status.MOVING_CORRECT.get());

        return Arrays.asList(bridgeFirstLayer, bridgeSecondLayer);
    }

    public List<List<String>> downIncorrect() {
        bridgeFirstLayer.add(Status.NO_MOVING.get());
        bridgeSecondLayer.add(Status.MOVING_INCORRECT.get());

        return Arrays.asList(bridgeFirstLayer, bridgeSecondLayer);
    }

    public void clearBridgeStatus() {
        bridgeFirstLayer.clear();
        bridgeSecondLayer.clear();
    }

    public List<List<String>> getBridgeStatusLayers() {
        return bridgeStatusLayers;
    }
}

enum Status {

    MOVING_CORRECT(" O "),
    MOVING_INCORRECT(" X "),
    NO_MOVING("   ");

    private final String message;

    Status(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}