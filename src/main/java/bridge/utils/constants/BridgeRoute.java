package bridge.utils.constants;

import java.util.Arrays;
import java.util.Optional;

public enum BridgeRoute {
    UP(1, "U"),
    DOWN(0, "D");

    private final int routeCode;
    private final String route;

    BridgeRoute(int routeCode, String route){
        this.routeCode = routeCode;
        this.route = route;
    }

    public static Optional<BridgeRoute> getMatchRoute(int routeCode){
        return Arrays.stream(BridgeRoute.values())
                .filter(route -> route.getRouteCode() == routeCode)
                .findAny();
    }

    private int getRouteCode(){
        return this.routeCode;
    }

    public String getRoute(){
        return this.route;
    }
}
