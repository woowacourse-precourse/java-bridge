package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.exception.ExceptionInput;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private BridgeGameService bridgeGameService;

    public void start() {
        OutputView.printStart();
        initial();
    }

    private void initial() {
        try {
            int size = ExceptionInput.validateInputLength(InputView.readBridgeSize());
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            bridgeGameService = new BridgeGameService(new BridgeGame(bridgeMaker.makeBridge(size)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initial();
        }
    }

    private void moving() {
        try {
            String command = getMoveCommand();
            bridgeGameService.moveNext(command);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            moving();
        }
    }
    private String getMoveCommand() {
        return ExceptionInput.validateInputMoveCommand(InputView.readMoving());
    }
}
