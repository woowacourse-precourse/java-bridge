package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class CurrentRoute {

    private final List<String> currentRoute;

    public CurrentRoute() {
        this.currentRoute = new ArrayList<>();
    }

    public void clear() {
        currentRoute.clear();
    }

    public void moveNext(String nextLocation) {
        currentRoute.add(nextLocation);
    }

    public int getCurrentLocationIndex() {
        return currentRoute.size() - 1;
    }

    public String getCurrentLocation() {
        return currentRoute.get(getCurrentLocationIndex());
    }
}
