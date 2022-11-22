package bridge.view.inputCallback;

import bridge.view.OutputView;

public interface ReadLineTemplate<T> {
    default T repeatToReadWhileValid(ReadLineCallback<T> callback) {
        while (true) {
            try {
                return callback.repeatToRead();
            } catch (IllegalArgumentException e) {
                OutputView.printExceptionMessageForInvalidInput(e);
            }
        }
    }
}
