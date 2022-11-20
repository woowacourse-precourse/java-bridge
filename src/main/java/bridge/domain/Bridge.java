package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> movableSpaces;
    public Bridge(List<String> movableSpaces) {
        this.movableSpaces = movableSpaces;
    }

    public List<String> getMovableSpaces() {
        return movableSpaces;
    }

    public int size() {
        return movableSpaces.size();
    }

    private String get(int index) {
        if (index < 1 || size() < index) {
            throw new IllegalStateException("[ERROR] 음..");
        }
        return movableSpaces.get(index - 1);
    }

    public boolean isBroken(int index, String spaceToMove) {
        if (get(index).equals(spaceToMove)) {
            return false;
        }
        return true;
    }
}
