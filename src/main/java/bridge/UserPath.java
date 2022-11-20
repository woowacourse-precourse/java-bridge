package bridge;

import java.util.ArrayList;
import java.util.List;

public class UserPath {
    private final List<String> userPath;

    public UserPath() {
        this.userPath = new ArrayList<String>();
    }

    public List<String> getUserPath() {
        return this.userPath;
    }

    public void addPath(String userPath) {
        this.userPath.add(userPath);
    }

    public void clearPath() {
        this.userPath.clear();
    }

    public int getBridgePosition() {
        return this.userPath.size()-1;
    }
}
