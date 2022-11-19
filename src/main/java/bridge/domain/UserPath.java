package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class UserPath {

    private List<String> userPath = new ArrayList<>();

    public void move(String input) {
        validateMovingInput(input);
        userPath.add(input);
    }

    public void initialize() {
        userPath = new ArrayList<>();
    }

    public boolean compare(Bridge bridge) {
        for (int idx = 0; idx < userPath.size(); idx++) {
            if (!bridge.compareWithPosition(idx, userPath.get(idx)))
                return false;
        }
        return true;
    }

    private void validateMovingInput(String input) {
        if (!input.equals(Bridge.down) && !input.equals(Bridge.up)) {
            throw new IllegalArgumentException("다리는 위, 아래 두 칸만으로 이루어져 있습니다.");
        }
    }
}
