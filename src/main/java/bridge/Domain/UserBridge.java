package bridge.Domain;

import java.util.ArrayList;
import java.util.List;

public class UserBridge {
    private List<String> spaces;

    public UserBridge() {
        this.spaces = new ArrayList<>();
    }

    public List<String> getSpaces() {
        return this.spaces;
    }

    public void saveSpace(String move) {
        spaces.add(move);
    }

    public void resetSpace() {
        this.spaces = new ArrayList<>();
    }

}
