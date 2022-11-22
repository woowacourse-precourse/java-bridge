package controller;

import constants.BridgeConstant;
import constants.DirectionTable;
import constants.TableAccessor;

import java.util.Arrays;
import java.util.List;

public class MapConverter {
    public static String[][] convertMap(List<String> map) {
        String[][] detailedMap = new String[BridgeConstant.BRIDGE_WIDTH][map.size()];
        initializeDetailedMap(detailedMap);
        makeDetailedMap(map, detailedMap);
        return detailedMap;
    }

    private static void initializeDetailedMap(String[][] detailedMap) {
        for (int row = 0; row < BridgeConstant.BRIDGE_WIDTH; row++) {
            Arrays.fill(detailedMap[row], " ");
        }
    }

    private static void makeDetailedMap(List<String> map, String[][] detailedMap) {
        for (int column = 0; column < map.size(); column++) {
            String originalWord = TableAccessor.directionTableAccessor.get(map.get(column));
            DirectionTable directionData = DirectionTable.valueOf(originalWord);

            detailedMap[directionData.getDirectionNumber()][column] = directionData.getCondition();
        }
    }
}
