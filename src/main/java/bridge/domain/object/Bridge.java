package bridge.domain.object;

import java.util.List;
import java.util.Objects;

public class Bridge {
    List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public boolean checkCorrectRoute(final List<String> route) {
        validateRoute(route);
        return bridge.equals(route);
    }

    public boolean checkDifferentRoute(final List<String> route) {
        validateRoute(route);
        for (int i =0; i < route.size(); i++) {
            if (!Objects.equals(route.get(i), bridge.get(i))) {
                return true;
            }
        }
        return false;
    }

    private void validateRoute(final List<String> route) {
        if (route.size() > this.bridge.size()) {
            throw new IllegalArgumentException("");
        }
    }
}
