package bridge.view;

import bridge.domain.game.Retry;
import bridge.validator.BridgeSizeValidator;
import bridge.validator.MovingValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final OutputView outputView = OutputView.getInstance();

    private InputView() {}

    public static InputView getInstance() {
        return LazyHolder.instance;
    }

    private static class LazyHolder {
        private static final InputView instance = new InputView();
    }

    public int readBridgeSize() {
        outputView.inputBridgeSize();
        String input = Console.readLine();
        try {
            return BridgeSizeValidator.validate(input);
        } catch (IllegalArgumentException e) {
            ExceptionView.print(e.getMessage());
        }
        return readBridgeSize();
    }

    public String readMoving() {
        outputView.inputMoving();
        String input = Console.readLine();
        try {
            return MovingValidator.validate(input);
        } catch (IllegalArgumentException e) {
            ExceptionView.print(e.getMessage());
        }
        return readMoving();
    }

    public Retry readGameCommand() {
        outputView.inputRetry();
        String input = Console.readLine();
        try {
            return Retry.of(input);
        } catch (IllegalArgumentException e) {
            ExceptionView.print(e.getMessage());
        }
        return readGameCommand();
    }
}
