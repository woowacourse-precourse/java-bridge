package bridge.view;

import bridge.BridgeMaker;
import bridge.domain.CompareResult;

public class ViewMaker {

    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;

    public ViewMaker(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = new InputView();
        this.outputView = new OutputView();

        this.printGameStart();
    }

    public void receiveClientRequest() {
        try {
            this.outputView.printInputBridgeLength();
            this.bridgeMaker.makeBridge(this.inputView.readBridgeSize());
        } catch (IllegalArgumentException exception) {
            this.outputView.printError(exception.getMessage());
            this.receiveClientRequest();
        }
    }

    public CompareResult receiveUserDirection(int bridgeLocation) {
        try {
            this.outputView.printInputMoveDirection();

            return this.outputView.printMap(bridgeMaker.compareToStoredBridgeBlueprint(inputView.readDirection(),
                    bridgeLocation));
        } catch (IllegalArgumentException exception) {
            this.outputView.printError(exception.getMessage());

            return this.receiveUserDirection(bridgeLocation);
        }
    }

    public boolean receiveUserGameCommand() {
        try {
            this.outputView.inputGameCommand();

            return this.outputView.isQuitGame(this.inputView.readGameCommand());
        } catch (IllegalArgumentException exception) {
            this.outputView.printError(exception.getMessage());

            return this.outputView.isQuitGame(this.inputView.readGameCommand());
        }
    }

    public void printGameStart() {
        this.outputView.printStart();
    }

    public void printGameExit() {
        this.outputView.finalMapPrint(true);
    }

    public void printAttemptCount(int attemptNumber) {
        this.outputView.printAttemptNumber(attemptNumber);
    }

}
