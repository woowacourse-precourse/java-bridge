package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class UserPath {

    private List<String> userPath = new ArrayList<>();

    public void move(String input) {
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
}
