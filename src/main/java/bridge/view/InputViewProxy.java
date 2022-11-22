package bridge.view;

import bridge.domain.vo.BridgeSize;
import bridge.domain.vo.MoveCommand;
import bridge.domain.vo.RetryCommand;

/**
 * 입력값 에러 발생시 다시 입력값을 받도록 해주는 클래스
 */
public class InputViewProxy extends InputView {

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    private final InputView inputView;

    public InputViewProxy(InputView inputView) {
        this.inputView = inputView;
    }

    @Override
    public BridgeSize readBridgeSize() {
        try {
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return readBridgeSize();
        }
    }

    @Override
    public MoveCommand readMoving() {
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return readMoving();
        }
    }

    @Override
    public RetryCommand readGameCommand() {
        try {
            return inputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return readGameCommand();
        }
    }

    private void printErrorMessage(IllegalArgumentException error) {
        System.out.println(ERROR_MESSAGE_PREFIX + error.getMessage());
    }
}
