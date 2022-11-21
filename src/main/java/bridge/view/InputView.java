package bridge.view;

import bridge.domain.game.Retry;
import bridge.validator.BridgeSizeValidator;
import bridge.validator.MovingValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {}

    public static InputView getInstance() {
        return LazyHolder.instance;
    }

    private static class LazyHolder {
        private static final InputView instance = new InputView();
    }

    public int readBridgeSize() {
        return BridgeSizeValidator.validate(Console.readLine());
    }

    public String readMoving() {
        return MovingValidator.validate(Console.readLine());
    }

    public Retry readGameCommand() {
        return Retry.of(Console.readLine());
    }
}
