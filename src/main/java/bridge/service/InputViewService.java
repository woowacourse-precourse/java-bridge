package bridge.service;

import bridge.domain.GameCommand;
import bridge.domain.MovingCommand;
import bridge.domain.SizeOfBridge;
import bridge.utils.CommandInputParser;
import bridge.view.InputView;

public class InputViewService {
    private final InputView inputView;

    public InputViewService() {
        inputView = new InputView();
    }

    public SizeOfBridge getReadBridgeSize() {
        try {
            int size = inputView.readBridgeSize();

            return SizeOfBridge.from(size);
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
