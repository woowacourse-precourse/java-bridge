package bridge;

import java.util.List;

public class Controller {

    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeStatus bridgeStatus;

    private BridgeGame bridgeGame;
    private String success = OutputMessage.SUCCESS.get();


    public Controller() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeStatus = new BridgeStatus();
    }

    public void makeBridgeWithSize() {
        int size = inputView.readBridgeSize();
        List<String> bridgeShape = bridgeMaker.makeBridge(size);
        this.bridgeGame = new BridgeGame(bridgeShape, bridgeStatus);
    }

    public String moveToStatus() {
        String moving = inputView.readMoving();
        String status = bridgeGame.move(moving);
        bridgeGame.makeStatusBridge(status);

        return status;
    }

    public boolean isRetry() {
        String command = inputView.readGameCommand();
        return bridgeGame.retry(command);
    }

    public boolean isContinueMove(boolean correction) {
        if (!correction) {
            if (!isRetry()){
                return false;
            }
            bridgeGame.setRetryCondition();
        }
        return true;
    }

    public void bridgeRound() {
        while (!bridgeGame.isEndBridge()) {
            boolean correction = bridgeGame.isCorrectMove(moveToStatus());
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

        outputView.printResult(bridgeStatus.getBridgeStatusLayers(), success, bridgeGame.getTrial());
    }
}