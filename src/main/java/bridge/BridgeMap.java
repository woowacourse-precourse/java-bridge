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

    public RouteMap getStatusAt(int distance) {
        List<String> upSideStatus = List.of(upSide.get(distance - 1));
        List<String> downSideStatus = List.of(downSide.get(distance - 1));

        return new RouteMap(upSideStatus, downSideStatus);
    }

    public RouteMap join(RouteMap other) {
        List<String> newUpSide = new ArrayList<>(upSide);
        List<String> newDownSide = new ArrayList<>(downSide);

        newUpSide.addAll(other.upSide);
        newDownSide.addAll(other.downSide);

        return new RouteMap(newUpSide, newDownSide);
    }
}
