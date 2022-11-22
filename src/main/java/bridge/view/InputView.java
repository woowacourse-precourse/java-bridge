package bridge.view;

import bridge.domain.value.BridgeSize;
import bridge.domain.value.GameCommand;
import bridge.domain.value.MovingShape;
import bridge.view.input.BridgeSizeInput;
import bridge.view.input.GameCommandInput;
import bridge.view.input.MovingShapeInput;
import bridge.view.input.RepeatInput;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public BridgeSize readBridgeSize() {
        RepeatInput<BridgeSize> repeatInput = new RepeatInput<>();
        return repeatInput.read(new BridgeSizeInput());
    }

    public MovingShape readMovingShape() {
        RepeatInput<MovingShape> repeatInput = new RepeatInput<>();
        return repeatInput.read(new MovingShapeInput());
    }

    public GameCommand readGameCommand() {
        RepeatInput<GameCommand> repeatInput = new RepeatInput<>();
        return repeatInput.read(new GameCommandInput());
    }
}
