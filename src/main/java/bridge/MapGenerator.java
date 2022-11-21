package bridge;

import java.util.ArrayList;
import java.util.List;

public class MapGenerator {
    private final String bridgeStart = "[";
    private final String bridgeEnd = "]";
    private final String bridgeSeperator = "|";

    public List<String> generateMap(Result result) {
        List<String> map = new ArrayList<>();
        map.add(buildBridgeRow(result.getFirstRow()));
        map.add(buildBridgeRow(result.getSecondRow()));
        return map;
    }

    private String buildBridgeRow(List<ResultType> resultRow) {
        List<String> row = new ArrayList<>();
        row.add(bridgeStart);
        for (ResultType col : resultRow) {
            row.add(bridgeSeperator);
            row.add(col.getValue());
        }
        row.add(bridgeEnd);
        return String.join(" ", row);
    }
}
