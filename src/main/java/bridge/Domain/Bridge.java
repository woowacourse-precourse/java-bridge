package bridge.Domain;

import java.util.List;

public class Bridge {
    private final List<String> spaces;
    private final int size;

    public Bridge(List<String> spaces, int size) {
        this.spaces = spaces;
        this.size = size;
    }

    @Override public String toString() {
        StringBuilder result = new StringBuilder();

        for (String space : spaces) {
            result.append(space);
        }
        return result.toString();
    }

    public String getSpaceByLocation(int location) {
        return spaces.get(location);
    }

    public int getSize() {
        return size;
    }
}
