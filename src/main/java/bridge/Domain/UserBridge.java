package bridge.Domain;

import java.util.ArrayList;
import java.util.List;

public class UserBridge {
    private List<String> spaces;

    public UserBridge() {
        this.spaces = new ArrayList<>();
    }

    public String getSpaceByLocation(int location) {
        return spaces.get(location);
    }

    public void saveSpaceResult(String move) {
        spaces.add(move);
    }

    public void resetSpace() {
        this.spaces = new ArrayList<>();
    }

}
