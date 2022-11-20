package bridge.model;

import bridge.error.Error;
import java.util.List;
import java.util.Objects;

public class Crossing {

    private final List<PassOrFail> history;

    public Crossing(List<PassOrFail> history) {
        this.history = history;
    }

    public void savePassOrFail(PassOrFail passOrFail) {
        if (Objects.isNull(passOrFail)) {
            throw new IllegalArgumentException(Error.SYSTEM_ERROR.getMessage());
        }

        history.add(passOrFail);
    }

    public boolean isPass() {
        return history.stream()
                .allMatch(PassOrFail::getValue);
    }

    public int getNextStep() {
        return history.size();
    }
}
