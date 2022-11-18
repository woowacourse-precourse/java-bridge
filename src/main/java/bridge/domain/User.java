package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<String > position = new ArrayList<>();

    public void move(String currentPosition) {
        position.add(currentPosition);
    }

    @Override
    public String toString() {
        return null;
    }
}
