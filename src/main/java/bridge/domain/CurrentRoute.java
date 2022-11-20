package bridge.domain;

import java.util.List;

public class CurrentRoute {

    private final List<String> currentRoute;

    public CurrentRoute(List<String> currentRoute) {
        this.currentRoute = currentRoute;
    }

    public void initiation() {
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

    public List<String> getCurrentRoute() {
        return currentRoute;
    }
}
