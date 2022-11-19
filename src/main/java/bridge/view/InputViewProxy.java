package bridge.view;

import bridge.domain.BridgeSize;
import bridge.domain.command.MoveCommand;
import bridge.domain.command.RetryCommand;

/**
 * 입력값 에러 발생시 다시 입력값을 받도록 해주는 클래스
 */
public class InputViewProxy extends InputView {

    @Override
    public BridgeSize readBridgeSize() {
        try {
            return super.readBridgeSize();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return this.readBridgeSize();
        }
    }

    @Override
    public MoveCommand readMoving() {
        try {
            return super.readMoving();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return this.readMoving();
        }
    }

    @Override
    public RetryCommand readGameCommand() {
        try {
            return super.readGameCommand();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e);
            return this.readGameCommand();
        }
    }

    private void printErrorMessage(IllegalArgumentException e) {
        System.out.println("[ERROR] " + e.getMessage());
    }
}
