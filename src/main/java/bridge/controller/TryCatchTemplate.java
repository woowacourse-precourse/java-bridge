package bridge.controller;

import bridge.view.OutputView;

public interface TryCatchTemplate<T> {
    default T repeatToRunWhileValid(TryCatchCallback<T> callback) {
        while (true) {
            try {
                return callback.run();
            } catch (IllegalArgumentException e) {
                OutputView.printExceptionMessageForInvalidInput(e);
            }
        }
    }
}
