package bridge;

import java.util.List;

public class Controller {

    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeStatus bridgeStatus;

    private BridgeGame bridgeGame;
    private List<String> bridgeShape;
    private String success = OutputMessage.SUCCESS.get();
    private int position = 0;
    private int trial = 1;

    public Controller() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeStatus = new BridgeStatus();
    }

    public void makeBridgeWithSize() {
        int size = inputView.readBridgeSize();
        this.bridgeShape = bridgeMaker.makeBridge(size);
        this.bridgeGame = new BridgeGame(bridgeShape);
    }

    public String moveToStatus() {
        String moving = inputView.readMoving();
        String status = bridgeGame.move(position, moving);
        makeStatusBridge(status);

        return status;
    }

    public void makeStatusBridge(String status) {
        if (!isCorrectMove(status)) {
            bridgeStatus.incorrectToBridge(status);
        }

        if (isCorrectMove(status)) {
            bridgeStatus.correctToBridge(status);
            position += 1;
        }
    }

    public boolean isCorrectMove(String status) {
        if (status.contains("Incorrect")) {
            return false;
        }
        return true;
    }

    public boolean isRetry() {
        String command = inputView.readGameCommand();
        return bridgeGame.retry(command);
    }

    public void setRetryCondition() {
        bridgeStatus.clearBridgeStatus();
        position = 0;
        trial += 1;
    }

    public boolean isContinueMove(boolean correction) {
        if (!correction) {
            if (!isRetry()){
                return false;
            }
            setRetryCondition();
        }
        return true;
    }

    public void bridgeRound() {
        while (position < bridgeShape.size()) {
            boolean correction = isCorrectMove(moveToStatus());
            outputView.printMap(bridgeStatus.getBridgeStatusLayers());

            if (!isContinueMove(correction)) {
                success = OutputMessage.FAILURE.get();
                break;
            }
        }
    }

    public void bridgeGame() {
        outputView.printInitialization();
        makeBridgeWithSize();

        bridgeRound();

        outputView.printResult(bridgeStatus.getBridgeStatusLayers(), success, trial);
    }
}