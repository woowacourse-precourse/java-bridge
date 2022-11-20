package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private static final String RETRY_COMMAND = "R";
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final Bridge bridge;

    public GameController(InputView inputView, OutputView outputView, BridgeNumberGenerator bridgeNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeNumberGenerator = bridgeNumberGenerator;
        bridge = this.generateBridge();
        outputView.printGameStart();
    }

    public void execute() {
        BridgeGameStatus status = new BridgeGameStatus(RETRY_COMMAND);
        while (status.isRunning()) {
            BridgeGame bridgeGame = new BridgeGame(bridge, new BridgeGameReferee());
            Result result = playGame(bridge, bridgeGame);
            result.increaseTryCount();
            if (bridgeGame.retry(result)) {
                readGameCommand(status);
                outputView.printResult(result);
                continue;
            }
            outputView.printResult(result);
            break;
        }
    }

    private Result playGame(Bridge bridge, BridgeGame bridgeGame) {
        Result result = new Result();
        for (int i = 0; i < bridge.getBridgeSize(); i++) {
            bridgeGame.move(result, this.readMoving(), i);
            if (result.hasWrong()) {
                return result;
            }
        }
        return result;
    }

    private Bridge generateBridge() {
        try {
            int bridgeSize = this.readBridgeSize();
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
            return new Bridge(bridgeMaker.makeBridge(bridgeSize));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return this.generateBridge();
        }
    }

    private int readBridgeSize() {
        outputView.printInputBridgeSize();
        return inputView.readBridgeSize();
    }

    private MoveDirection readMoving() {
        outputView.printInputMoveDirection();
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return this.readMoving();
        }
    }

    private void readGameCommand(BridgeGameStatus status) {
        outputView.printInputGameCommand();
        status.changeStatus(inputView.readGameCommand());
    }
}
