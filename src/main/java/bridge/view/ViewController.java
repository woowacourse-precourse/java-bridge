package bridge.view;

import bridge.BridgeSizeConstant;
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

    public int readBridgeSize() {
        while (true) {
            try {
                String inputSize = inputView.readBridgeSize();
                validateIsNumber(inputSize);
                int size = Integer.parseInt(inputSize);
                validateSizeRange(size);
                return size;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateIsNumber(String inputSize) {
        if (!inputSize.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 정수만 입력해야 합니다.");
        }
    }

    private void validateSizeRange(int size) {
        if (size > BridgeSizeConstant.MAX_BRIDGE_SIZE || size < BridgeSizeConstant.MIN_BRIDGE_SIZE) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
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
