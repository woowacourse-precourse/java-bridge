package bridge;

import java.util.function.Supplier;

public class InputViewRetryProxy extends InputView {

    private static final Logger logger = Logger.getInstance();

    private final InputView target;

    public InputViewRetryProxy(InputView target) {
        this.target = target;
    }

    @Override
    public int readBridgeSize(Runnable printInputMessage) {
        return retryWhenFail(() -> target.readBridgeSize(printInputMessage));
    }

    @Override
    public String readMoving(Runnable printInputMessage) {
        return retryWhenFail(() -> target.readMoving(printInputMessage));
    }

    @Override
    public GameCommand readGameCommand(Runnable printInputMessage) {
        return retryWhenFail(() -> target.readGameCommand(printInputMessage));
    }

    private <R> R retryWhenFail(Supplier<R> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            logger.printError(e.getMessage());
            return retryWhenFail(supplier);
        }
    }
}
