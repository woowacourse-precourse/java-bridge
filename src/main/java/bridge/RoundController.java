package bridge;

import java.util.ArrayList;
import java.util.List;

public class RoundController {

    private final BridgeMaker bridgeMaker;
    private List<String> bridgeShape;
    private List<String> bridgeFirstLayer = new ArrayList<>();
    private List<String> bridgeSecondLayer = new ArrayList<>();
    private int position = 0;

    public RoundController(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public void makeBridgeWithSize() {
        InputView input = new InputView();

        int size = input.readBridgeSize();

        this.bridgeShape = bridgeMaker.makeBridge(size);
    }

    public void moveToStatus() {
        InputView input = new InputView();
        BridgeGame game = new BridgeGame(bridgeShape);
        String moving = input.readMoving();
        String status = game.move(position, moving);
    }

    public void upCorrect() {
        bridgeFirstLayer.add(bridgeStatus.MOVING_CORRECT.get());
        bridgeSecondLayer.add(bridgeStatus.NO_MOVING.get());
    }

    public void upIncorrect() {
        bridgeFirstLayer.add(bridgeStatus.MOVING_INCORRECT.get());
        bridgeSecondLayer.add(bridgeStatus.NO_MOVING.get());
    }

    public void downCorrect() {
        bridgeFirstLayer.add(bridgeStatus.NO_MOVING.get());
        bridgeSecondLayer.add(bridgeStatus.MOVING_CORRECT.get());
    }

    public void downIncorrect() {
        bridgeFirstLayer.add(bridgeStatus.NO_MOVING.get());
        bridgeSecondLayer.add(bridgeStatus.MOVING_INCORRECT.get());
    }
}

enum bridgeStatus {

    BRIDGE_HEAD("["),
    BRIDGE_TAIL("]"),
    BRIDGE_MIDDLE("|"),

    MOVING_CORRECT(" O "),
    MOVING_INCORRECT(" X "),
    NO_MOVING("   ");

    private final String message;

    bridgeStatus(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}