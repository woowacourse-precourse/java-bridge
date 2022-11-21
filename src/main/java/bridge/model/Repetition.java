package bridge.model;

import java.util.Objects;

public class Repetition {
    private final int repetition;

    public Repetition() {
        this.repetition = 1;
    }

    public Repetition(final int retryCount) {
        this.repetition = retryCount;
    }

    public int getRepetition() {
        return repetition;
    }

    public Repetition increaseCount() {
        return new Repetition(this.repetition + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Repetition that = (Repetition) o;
        return repetition == that.repetition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(repetition);
    }
}
