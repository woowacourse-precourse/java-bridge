package bridge.view;

import bridge.domain.CommandType;
import bridge.domain.bridge.MoveType;
import bridge.domain.result.Map;
import bridge.domain.result.Result;

public class ViewController {
    private final InputView inputView;
    private final OutputView outputView;

    public ViewController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String readBridgeSize() {
        return inputView.readBridgeSize();
    }

    public MoveType readMoving() {
        while (true) {
            try {
                String inputMove = inputView.readMoving();
                return MoveType.create(inputMove);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public CommandType readGameCommand() {
        while (true) {
            try {
                String inputGameCommand = inputView.readGameCommand();
                return CommandType.create(inputGameCommand);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printMap(Map map) {
        outputView.printMap(map);
    }

    public void printResult(Result result) {
        outputView.printResult(result);
    }
}
