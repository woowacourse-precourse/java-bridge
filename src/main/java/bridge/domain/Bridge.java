package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> movableSpaces;
    public Bridge(List<String> movableSpaces) {
        this.movableSpaces = movableSpaces;
    }

    public List<String> getMovableSpaces() {
        return movableSpaces;
    }
}
