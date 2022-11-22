package bridge.view;

import bridge.core.GameCommand;
import bridge.Logger;
import java.util.function.Supplier;

public class InputViewRetryProxy extends InputView {

    private final Logger logger;
    private final InputView target;

    public InputViewRetryProxy(InputView target) {
        this.target = target;
        this.logger = Logger.getInstance();
    }

    @Override
    public int readBridgeSize(Runnable printInputMessage) {
        return retryWhenFail(() -> this.target.readBridgeSize(printInputMessage));
    }

    @Override
    public String readMoving(Runnable printInputMessage) {
        return retryWhenFail(() -> this.target.readMoving(printInputMessage));
    }

    @Override
    public GameCommand readGameCommand(Runnable printInputMessage) {
        return retryWhenFail(() -> this.target.readGameCommand(printInputMessage));
    }

    private <R> R retryWhenFail(Supplier<R> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            this.logger.printError(e.getMessage());
            return retryWhenFail(supplier);
        }
    }
}
