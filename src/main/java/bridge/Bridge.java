package bridge;

import java.util.List;

public class Bridge {

    private final List<String> positions;

    public Bridge(List<String> positions) {
        this.positions = positions;
    }

    public List<String> getPositions() {
        return positions;
    }
}
