package bridge.domain;

import java.util.Objects;

public class PlayState {
    private final boolean state;

    public PlayState(boolean state) {
        this.state = state;
    }

    public boolean nowState() {
        return this.state;
    }

    public PlayState end() {
        return new PlayState(false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayState playState = (PlayState) o;
        return state == playState.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(state);
    }
}
