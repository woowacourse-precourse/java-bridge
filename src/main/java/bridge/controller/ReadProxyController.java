package bridge.controller;

import bridge.domain.Command;
import bridge.view.OutputView;

public class ReadProxyController implements ReadController {

    private final ReadController readController;

    public ReadProxyController() {
        this.readController = new ReadControllerImpl();
    }

    @Override
    public int readBridgeSize() {
        while (true) {
            try {
                return readController.readBridgeSize();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    @Override
    public String readMoving() {
        while (true) {
            try {
                return readController.readMoving();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    @Override
    public Command readGameCommand() {
        while (true) {
            try {
                return readController.readGameCommand();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}
