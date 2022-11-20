package bridge;

public class TotalResult {
    private final RouteMap routeMap;
    private final int tryCnt;

    public TotalResult(RouteMap routeMap, int tryCnt) {
        this.routeMap = routeMap;
        this.tryCnt = tryCnt;
    }

    public RouteMap getRouteMap() {
        return routeMap;
    }

    public boolean win() {
        return !routeMap.fail();
    }

    public int getTryCnt() {
        return tryCnt;
    }
}
