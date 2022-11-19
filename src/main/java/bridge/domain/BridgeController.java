package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.option.GameCommand;
import bridge.result.Result;
import bridge.size.BridgeSize;
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

    public void inputBridgeSize() {
        try {
            outputView.printInputBridgeSizeMessage();
            BridgeSize bridgeSize = inputView.readBridgeSize();
            bridgeService.generateBridge(bridgeSize.getSize());
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            inputBridgeSize();
        }
    }

    public Result inputPlayerMove() {
        try {
            outputView.printInputMoveMessage();
            Result result = bridgeService.insertMove(inputView.readMoving());
            outputView.printMap(result);
            return result;
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return inputPlayerMove();
        }
    }

    public GameCommand inputGameCommand() {
        try {
            outputView.printInputGameCommand();
            return inputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return inputGameCommand();
        }
    }

    public void restartGame() {
        bridgeService.clearPlayerBridge();
    }
}
