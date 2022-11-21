package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.result.Result;
import bridge.command.Size;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final BridgeService bridgeService;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeService = new BridgeService(bridgeNumberGenerator);
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void makeBridge() {
        outputView.printStartGame();
        try {
            bridgeService.generateBridge(inputBridgeSize());
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            makeBridge();
        }
    }

    public Result toMove() {
        try {
            return inputPlayerMove();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return toMove();
        }
    }

    public void resetGame() {
        bridgeService.clearPlayerBridge();
    }

    private Size inputBridgeSize() {
        outputView.printInputBridgeSizeMessage();
        return inputView.readBridgeSize();
    }

    private Result inputPlayerMove() {
        outputView.printInputMoveMessage();
        Result result = bridgeService.insertMove(inputView.readMoving());
        outputView.printMap(result);
        return result;
    }
}
