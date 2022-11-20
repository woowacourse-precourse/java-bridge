package bridge.step;

import bridge.BridgeGame;
import bridge.status.Retry;
import bridge.status.UserStatus;
import bridge.view.input.InputView;
import bridge.view.output.OutputView;
import java.util.ArrayList;
import java.util.List;

public class PlayGameStep implements Step {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final UserStatus userStatus;
    private List<String> bridges;

    public PlayGameStep(InputView inputView, OutputView outputView, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
        this.userStatus = new UserStatus(new ArrayList<>());
        this.userStatus.changeNextStep(StepType.MAKE_BRIDGE);
    }

    @Override
    public void doStep() {
        while (executeByStep(userStatus.getNowStep())) {

        }
    }

    private void changeNextStep() {

        if (userStatus.getNowStep() == StepType.MAKE_BRIDGE) {
            userStatus.changeNextStep(StepType.MOVE_BRIDGE);
            return;
        }

        if (userStatus.getNowStep() == StepType.MOVE_BRIDGE) {
            userStatus.changeNextStep(StepType.RETRY_OR_QUIT);
        }
    }


    private boolean executeByStep(StepType stepType) {
        if (stepType == StepType.MAKE_BRIDGE) {
            return makeBridge();
        }

        if (stepType == StepType.MOVE_BRIDGE) {
            return moveBridge(userStatus, bridges);
        }

        if (stepType == StepType.RETRY_OR_QUIT) {
            return retryOrQuit(userStatus);
        }
        return true;
    }


    private boolean makeBridge() {
        int bridgeSize = inputView.readBridgeSize();

        bridges = bridgeGame.makeBridge(bridgeSize);
        changeNextStep();
        return true;
    }


    private boolean moveBridge(UserStatus userStatus, List<String> bridges) {
        while (userStatus.isAvailable() && userStatus.getPosition() + 1 < bridges.size()) {
            String direction = inputView.readMoving();
            userStatus.addDirection(direction);

            bridgeGame.move(bridges, userStatus);
            outputView.printMap(userStatus);
        }

        changeNextStep();
        return true;
    }

    private boolean retryOrQuit(UserStatus userStatus) {
        if (userStatus.isAvailable()) {
            return endGame();
        }

        String command = inputView.readGameCommand();
        if (Retry.convert(command) == Retry.QUIT) {
            return endGame();
        }

        return tryAgain();
    }

    private boolean tryAgain() {
        bridgeGame.retry(userStatus);
        userStatus.changeNextStep(StepType.MOVE_BRIDGE);
        return true;
    }

    private boolean endGame() {
        outputView.printResult(userStatus);
        return false;
    }
}
