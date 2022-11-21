package bridge;

import static bridge.exception.ExceptionName.BRIDGE_MOVE_EXCEPTION;

import java.util.List;
import view.InputView;

public class BridgeMove {

    private final List<String> bridge;

    public BridgeMove(List<String> bridge) {
        this.bridge = bridge;
    }

    public String readMoving() {
        InputView inputView = new InputView();
        return validateMove(inputView.readMoving());
    }

    private String validateMove(String move) {
        if (!move.equals("U") && !move.equals("D")) {
            throw new IllegalArgumentException(BRIDGE_MOVE_EXCEPTION);
        }
        return move;
    }

}
