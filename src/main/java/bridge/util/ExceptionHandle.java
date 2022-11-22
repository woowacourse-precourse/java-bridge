package bridge.util;

import bridge.view.OutputView;

public class ExceptionHandle {

    private final OutputView outputView;

    public ExceptionHandle(OutputView outputView) {
        this.outputView = outputView;
    }

    public <T> T getCorrectInput(Callback<T> callback) {
        while (true) {
            try {
                return callback.run();
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }
}
