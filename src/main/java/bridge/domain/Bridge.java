package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> bridge;
    private final int size;

    public Bridge(List<String> bridge, int size) {
        validate(size);
        this.bridge = bridge;
        this.size = size;
    }

    private void validate(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(Error.BRIDGE_SIZE_ERROR.getErrorMessage());
        }
    }

    public boolean checkToMove(int position, String moveTo) {
        return bridge.get(position).equals(moveTo);
    }
}
