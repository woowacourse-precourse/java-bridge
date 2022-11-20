package bridge.view.inputCallback;

import bridge.Logger;

public interface ReadLineTemplate<T> {
    default T repeatToReadWhileValid(ReadLineCallback<T> callback) {
        while (true) {
            try {
                return callback.repeatToRead();
            } catch (IllegalArgumentException e) {
                Logger.log(e);
            }
        }
    }
}
