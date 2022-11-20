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
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public boolean checkToMove(int position, String moveTo) {
        return bridge.get(position).equals(moveTo);
    }
}
