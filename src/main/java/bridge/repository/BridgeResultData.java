package bridge.repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임의 결과 데이터를 저장하는 클래스
 */
public class BridgeResultData {

    private static final List<String> upBridgeResults = new ArrayList<>();
    private static final List<String> downBridgeResults = new ArrayList<>();

    public static List<String> getUpBridgeResults() {
        return upBridgeResults;
    }

    public static List<String> getDownBridgeResults() {
        return downBridgeResults;
    }

    public static void add(String upBridgeResult, String downBridgeResult) {
        upBridgeResults.add(upBridgeResult);
        downBridgeResults.add(downBridgeResult);
    }

    public static void resetLastMove() {
        upBridgeResults.remove(upBridgeResults.size() - 1);
        downBridgeResults.remove(downBridgeResults.size() - 1);
    }

    public static void reset() {
        upBridgeResults.clear();
        downBridgeResults.clear();
    }
}
