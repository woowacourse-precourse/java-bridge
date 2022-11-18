package bridge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    static int count = 0;
    static Map<Integer, String> firstStorage = new HashMap<>();
    static Map<Integer, String> secondStorage = new HashMap<>();

    public void move(List<String> firstBridge, List<String> secondBridge, String move) {
        bridgeSet(firstBridge, secondBridge);
        String firstBridgeMap = moveFirstBridge(firstBridge, move);
        String secondBridgeMap = moveSecondBridge(secondBridge, move);
        count++;
    }

    private String moveSecondBridge(List<String> secondBridge, String move) {
        secondStorage.put(-1, "");
        StringBuilder secondSb = new StringBuilder();
        secondSb.append(secondStorage.get(count - 1));
        secondBridgeMoveDown(secondSb, secondBridge, move);
        secondBridgeMoveUp(secondSb, move);
        secondStorage.put(count, secondSb.toString());
        return secondSb.toString();
    }

    private void secondBridgeMoveUp(StringBuilder secondSb, String move) {
        if (move.equals("U")) {
            if (count != 0) {
                secondSb.append(" | ");
                secondSb.append(" ");
            }
            if (count == 0) {
                secondSb.append(" ");
            }
        }
    }

    private void secondBridgeMoveDown(StringBuilder secondSb, List<String> secondBridge, String move) {
        if (move.equals("D")) {
            if (count != 0) {
                secondSb.append(" | ");
                secondSb.append(secondBridge.get(count));
            }
            if (count == 0) {
                secondSb.append(secondBridge.get(count));
            }
        }
    }

    private String moveFirstBridge(List<String> firstBridge, String move) {
        StringBuilder firstSb = new StringBuilder();
        firstStorage.put(-1, "");
        firstSb.append(firstStorage.get(count - 1));
        firstBridgeMoveDown(firstSb, move);
        firstBridgeMoveUp(firstSb, firstBridge, move);
        firstStorage.put(count, firstSb.toString());
        return firstSb.toString();
    }

    private void firstBridgeMoveUp(StringBuilder firstSb, List<String> firstBridge, String move) {
        if (move.equals("U")) {
            if (count != 0) {
                firstSb.append(" | ");
                firstSb.append(firstBridge.get(count));
            }
            if (count == 0) {
                firstSb.append(firstBridge.get(count));
            }
        }
    }

    private void firstBridgeMoveDown(StringBuilder firstSb, String move) {
        if (move.equals("D")) {
            if (count != 0) {
                firstSb.append(" | ");
                firstSb.append(" ");
            }
            if (count == 0) {
                firstSb.append(" ");
            }
        }
    }

    private void bridgeSet(List<String> firstBridge, List<String> secondBridge) {
        for (int i = 0; i < firstBridge.size(); i++) {
            if (firstBridge.get(i).equals("U")) {
                firstBridge.set(i, "O");
                secondBridge.set(i, "X");
            }
            if (firstBridge.get(i).equals("D")) {
                firstBridge.set(i, "X");
                secondBridge.set(i, "O");
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
