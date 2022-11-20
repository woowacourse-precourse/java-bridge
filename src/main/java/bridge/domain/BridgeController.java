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

    public void inputBridgeSize() {
        outputView.printStartGame();
        try {
            outputView.printInputBridgeSizeMessage();
            Size size = inputView.readBridgeSize();
            bridgeService.generateBridge(size.getSize());
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



    public void restartGame() {
        bridgeService.clearPlayerBridge();
    }


}
