package bridge.service;

import bridge.domain.command.GameCommand;
import bridge.domain.command.MovingCommand;
import bridge.domain.bridge.BridgeSize;

import bridge.utils.parser.CommandInputParser;

import bridge.view.InputView;

public class InputViewService {

    private final InputView inputView;

    public InputViewService() {
        inputView = new InputView();
    }

    public BridgeSize getReadBridgeSize() {
        try {
            int size = inputView.readBridgeSize();

            return BridgeSize.from(size);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getReadBridgeSize();
        }
    }

    public MovingCommand getReadMoving() {
        try {
            String command = inputView.readMoving();

            return CommandInputParser.parseMovingCommand(command);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getReadMoving();
        }
    }

    public GameCommand getReadGameCommand() {
        try {
            String command = inputView.readGameCommand();

            return CommandInputParser.parseGameCommand(command);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getReadGameCommand();
        }
    }

}
