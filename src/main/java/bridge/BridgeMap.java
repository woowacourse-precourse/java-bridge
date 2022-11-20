package bridge;

import java.util.List;
import java.util.ArrayList;

public class BridgeMap extends RouteMap {

    public BridgeMap(List<String> upSide, List<String> downSide) {
        super(upSide, downSide);
    }

    public RouteMap getRouteAt(int distance) {
        List<String> slicedUpSide = new ArrayList<>(upSide.subList(0, distance));
        List<String> slicedDownSide = new ArrayList<>(downSide.subList(0, distance));

        return new RouteMap(slicedUpSide, slicedDownSide);
    }
}
