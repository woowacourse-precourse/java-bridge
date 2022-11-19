package bridge.Domain;

import java.util.List;

public class Bridge {
    private final List<String> spaces;

    public Bridge(List<String> spaces) {
        this.spaces = spaces;
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
}
