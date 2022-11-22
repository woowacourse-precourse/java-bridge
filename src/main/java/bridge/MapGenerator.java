package bridge;

import java.util.ArrayList;
import java.util.List;

public class MapGenerator {
    private final String bridgeStart = "[";
    private final String bridgeEnd = "]";
    private final String bridgeSeperator = "|";


    /**
     * Result 객체를 받아서 다리의 상태를 출력할 수 있는 형태로 변환한다.
     * 
     * @param result 게임의 결과
     * @return 다리의 상태를 출력할 수 있는 문자열 리스트로 변환된 결과
     */
    public List<String> generateMap(Result result) {
        List<String> map = new ArrayList<>();
        map.add(buildBridgeRow(result.getFirstRow()));
        map.add(buildBridgeRow(result.getSecondRow()));
        return map;
    }

    /**
     * 다리의 한 줄을 출력할 수 있는 형태로 변환한다.
     * 
     * @param resultRow
     * @return String 다리의 한 줄을 출력할 수 있는 형태로 변환된 결과
     */
    private String buildBridgeRow(List<ResultType> resultRow) {
        List<String> row = new ArrayList<>();
        row.add(bridgeStart);
        for (ResultType col : resultRow) {
            row.add(col.getValue());
            row.add(bridgeSeperator);
        }
        // Remove last seperator
        row.remove(row.size() - 1);
        row.add(bridgeEnd);
        return String.join(" ", row);
    }
}
