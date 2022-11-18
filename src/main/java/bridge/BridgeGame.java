package bridge;

import java.sql.SQLOutput;
import java.util.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final HashMap<String, List<String>> bridgeGameResult = new HashMap<>();
    private static int totalCount = 0;

    public void setBridgeGameResult() {
        bridgeGameResult.put("U", new ArrayList<String>());
        bridgeGameResult.put("D", new ArrayList<String>());
        totalCount++;
    }

    public void clear() {
        bridgeGameResult.clear();
    }

    public HashMap<String, List<String>> getBridgeGameResult() {
        return bridgeGameResult;
    }

    public static int getTotalCount() {
        return totalCount;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(Bridge player, Bridge answer, int index) {
        String paintGame = getPaintGame(player, answer, index);
        String position = player.getBridge().get(index);
        String otherPosition = getOtherPosition(position);
        paintBridgeGameResult(position, otherPosition, paintGame);

        return bridgeGameResult.get(position).contains("X");
    }

    private String getPaintGame(Bridge player, Bridge answer, int index) {
        if (answer.isSamePosition(player, index)) {
            return "O";
        }
        return "X";
    }

    private String getOtherPosition(String position) {
        if ("U".equals(position)) {
            return "D";
        }
        return "U";
    }

    private void paintBridgeGameResult(String position, String otherPosition, String paintGame) {
        List<String> positionResult = bridgeGameResult.get(position);
        List<String> otherResult = bridgeGameResult.get(otherPosition);
        positionResult.add(paintGame);
        otherResult.add(" ");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String answer) {
        return "R".equals(answer);
    }
}
