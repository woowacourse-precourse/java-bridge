package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.constant.command.Command;
import bridge.exception.ExceptionInput;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private BridgeGameService bridgeGameService;

    public void start() {
        OutputView.printStart();
        initial();
        progress();
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

    private void progress() {
        while(bridgeGameService.success() && !bridgeGameService.isComplete()) {
            moving();
            OutputView.printMap(bridgeGameService.getBridge(), bridgeGameService.getSelections());
        }
        if(!bridgeGameService.isComplete()) {
            retry();
        }
    }

    private void retry() {
        try {
            String command = getRetryCommand();
            if( command.equals(Command.RETRY.getCommand())) {
                bridgeGameService.restart();
                progress();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            retry();
        }
    }

    private String getRetryCommand() {
        return ExceptionInput.validateInputRetryCommand(InputView.readGameCommand());
    }
}
