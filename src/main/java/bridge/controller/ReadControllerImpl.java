package bridge.controller;

import bridge.domain.Command;
import bridge.view.InputView;

import static bridge.domain.Command.validateGameCommand;
import static bridge.domain.Move.validateMoving;
import static bridge.BridgeMaker.validateBridgeSize;

public class ReadControllerImpl implements ReadController {

    private final InputView inputView;

    public ReadControllerImpl() {
        this.inputView = new InputView();
    }

    @Override
    public int readBridgeSize() {
        int bridgeSize = inputView.readBridgeSize();
        validateBridgeSize(bridgeSize);
        return bridgeSize;
    }

    @Override
    public String readMoving() {
        String moving = inputView.readMoving();
        validateMoving(moving);
        return moving;
    }

    @Override
    public Command readGameCommand() {
        String command = inputView.readGameCommand();
        validateGameCommand(command);
        return Command.from(command);
    }
}
