package bridge.service;

import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.Optional;

public class ViewService {

    private final InputView inputView;
    private final OutputView outputView;

    public ViewService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void printStartMessage() {
        outputView.printStartingMessage();
    }

    public int getBridgeLength() {
        Optional<Integer> size;
        do {
            size = inputView.readBridgeSize();
        } while (size.isEmpty());
        return size.get();
    }

    public String askMovement() {
        Optional<String> move;
        do {
            move = inputView.readMoving();
        } while (move.isEmpty());
        return move.get();
    }

    public void printBridge(Bridge bridge) {
        outputView.printMap(bridge);
    }

    public String askReGame() {
        Optional<String> cmd;
        do {
            cmd = inputView.readGameCommand();
        } while (cmd.isEmpty());
        return cmd.get();
    }

    public void printTotalResult() {
        outputView.printResult();
    }
}
