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

    public String find(int position) {
        return userPath.get(position);
    }

    public int size() {
        return userPath.size();
    }
}
