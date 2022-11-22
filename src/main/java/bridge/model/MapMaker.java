package bridge.model;

import bridge.model.data.MapData;

import java.util.List;

public class MapMaker {

    private static final String MAP_START = "[ ";
    private static final String MAP_FINISH = " ]";
    private static final String MAP_DIVIDER = " | ";

    private final List<String> upsideRecords;
    private final List<String> downsideRecords;

    public MapMaker(List<String> uRecords, List<String> dRecords) {
        this.upsideRecords = uRecords;
        this.downsideRecords = dRecords;
    }

    public MapData makeMap() {
        String upsideMap = MAP_START + String.join(MAP_DIVIDER, upsideRecords) + MAP_FINISH;
        String downsideMap = MAP_START + String.join(MAP_DIVIDER, downsideRecords) + MAP_FINISH;

        return new MapData(upsideMap, downsideMap);
    }
}