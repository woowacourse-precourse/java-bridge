package model;

import bridge.constants.BridgeConstant;
import bridge.constants.DirectionTable;

import java.util.Arrays;
import java.util.List;

public class RouteMap {

    private String[][] routeMap;

    public RouteMap(List<String> route) {
        routeMap = new String[BridgeConstant.BRIDGE_WIDTH][route.size()];

        for (int row = 0; row < BridgeConstant.BRIDGE_WIDTH; row++) {
            Arrays.fill(routeMap[row], " ");
        }

        makeRouteMap(route);
    }

    private void makeRouteMap(List<String> route) {
        for (int column = 0; column < route.size(); column++) {
            String originalWord = BridgeConstant.directionAccessTable.get(route.get(column));
            DirectionTable directionTable= DirectionTable.valueOf(originalWord);

            routeMap[directionTable.getDirection()][column] =directionTable.getState();
        }
    }

    public String[][] getRouteMap() {
        return routeMap;
    }
}
