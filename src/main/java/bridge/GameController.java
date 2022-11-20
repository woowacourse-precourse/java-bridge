package bridge;

import bridge.support.BridgeGameReferee;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeNumberGenerator bridgeNumberGenerator;

    public GameController(InputView inputView, OutputView outputView, BridgeNumberGenerator bridgeNumberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeNumberGenerator = bridgeNumberGenerator;
        outputView.printGameStart();
    }

    public void execute() {
        BridgeGameStatus status = new BridgeGameStatus(true);
        while (status.isRunning()) {
            Bridge bridge = this.generateBridge();

            BridgeGame bridgeGame = new BridgeGame(bridge);
            BridgeGameReferee referee = new BridgeGameReferee();

            Result result = new Result();

            for (int i = 0; i < bridge.getBridgeSize(); i++) {
                MoveDirection direction = this.readMoving();
                result = referee.updateResult(result, direction, bridgeGame.move(direction, i));
                if (result.hasWrong()) {
                    status.changeToGameOver();
                    break;
                }
            }
        }
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
}
