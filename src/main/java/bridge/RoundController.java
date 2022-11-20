package bridge;

import java.util.ArrayList;
import java.util.List;

public class RoundController {

    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;
    private final StateView stateView;
    private List<String> bridgeShape;
    private List<String> bridgeFirstLayer = new ArrayList<>();
    private List<String> bridgeSecondLayer = new ArrayList<>();
    private List<String> failureFirstLayer = new ArrayList<>();
    private List<String> failureSecondLayer = new ArrayList<>();
    private int position = 0;

    public RoundController(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.stateView = new StateView();
    }

    public void makeBridgeWithSize() {
        int size = inputView.readBridgeSize();
        this.bridgeShape = bridgeMaker.makeBridge(size);
        this.bridgeGame = new BridgeGame(bridgeShape);
    }

    public boolean moveToStatus() {
        String moving = inputView.readMoving();
        String status = bridgeGame.move(position, moving);
        if (status.contains("In")) {
            incorrectToBridge(status);
            return false;
        }
        correctToBridge(status);
        return true;
    }

    public boolean bridgeRound() {
        makeBridgeWithSize();
        System.out.println(bridgeShape);
        moveToStatus();

        if (!moveToStatus()) {
            outputView.printMap(failureFirstLayer, failureSecondLayer);
            return false;
        }

        outputView.printMap(bridgeFirstLayer, bridgeSecondLayer);
        return true;
    }

    public boolean progressGame() {
        if (!bridgeRound()) {
            if (inputView.readGameCommand().equals(Retry.QUIT.get())) {
                return false;
            }
            return true;
        }
        return true;
    }

    public void correctToBridge(String status) {
        if (status.equals(MoveStatus.UP_CORRECT.get())) {
            upCorrect();
        }

        if (status.equals(MoveStatus.DOWN_CORRECT.get())) {
            downCorrect();
        }
    }

    public void incorrectToBridge(String status) {
        if (status.equals(MoveStatus.UP_INCORRECT.get())) {
            upIncorrect();
        }

        if (status.equals(MoveStatus.DOWN_INCORRECT.get())) {
            downIncorrect();
        }
    }

    public void upCorrect() {
        bridgeFirstLayer.add(BridgeStatus.MOVING_CORRECT.get());
        bridgeSecondLayer.add(BridgeStatus.NO_MOVING.get());
        position += 1;
    }

    public void upIncorrect() {
        failureFirstLayer = bridgeFirstLayer;
        failureSecondLayer = bridgeSecondLayer;

        failureFirstLayer.add(BridgeStatus.MOVING_INCORRECT.get());
        failureSecondLayer.add(BridgeStatus.NO_MOVING.get());
    }

    public void downCorrect() {
        bridgeFirstLayer.add(BridgeStatus.NO_MOVING.get());
        bridgeSecondLayer.add(BridgeStatus.MOVING_CORRECT.get());
        position += 1;
    }

    public void downIncorrect() {
        failureFirstLayer = bridgeFirstLayer;
        failureSecondLayer = bridgeSecondLayer;

        bridgeFirstLayer.add(BridgeStatus.NO_MOVING.get());
        bridgeSecondLayer.add(BridgeStatus.MOVING_INCORRECT.get());
    }
}

enum BridgeStatus {

    MOVING_CORRECT(" O "),
    MOVING_INCORRECT(" X "),
    NO_MOVING("   ");

    private final String message;

    BridgeStatus(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}