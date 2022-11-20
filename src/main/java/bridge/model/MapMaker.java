package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class MapMaker {
    private static final String MAP_START = "[ ";
    private static final String MAP_FINISH = " ]";
    private static final String MAP_DIVIDER = " | ";

    private final List<String> upsideRecords;
    private final List<String> downsideRecords;

    public MapMaker(List<String> uStatus, List<String> dStatus) {
        this.upsideRecords = uStatus;
        this.downsideRecords = dStatus;
    }

    public String makeUpsideMap() {
        return MAP_START + String.join(MAP_DIVIDER, upsideRecords) + MAP_FINISH;
    }

    public String makeDownsideMap() {
        return MAP_START + String.join(MAP_DIVIDER, downsideRecords) + MAP_FINISH;
    }
}