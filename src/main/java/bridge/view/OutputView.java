package bridge;

import java.util.List;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static BridgeGame bridgeGame;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> bridge, String position, int level) {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(printUp(bridge, level))
                .append(printOX(bridge.get(level), position)).append("]\n[")
                .append(printDown(bridge, level))
                .append(printOX(bridge.get(level), position)).append("]\n");
        System.out.println(sb);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<String> bridge, List<String> positions) {
        int level = positions.size();

        StringBuilder sb = new StringBuilder();
        sb.append("최종 게임 결과\n");
        sb.append("[").append(printUp(bridge, level))
                .append(printOX(bridge.get(level), positions.get(level))).append("]\n[")
                .append(printDown(bridge, level))
                .append(printOX(bridge.get(level), positions.get(level))).append("]\n");
        System.out.println(sb);
    }

    public static void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    private String printOX(String bridgeItem, String position) {
        StringBuilder sb = new StringBuilder();
        if (Objects.equals(bridgeItem, position)) {
            return sb.append(" O ").toString();
        }
        return sb.append(" X ").toString();
    }

    private String printUp(List<String> bridge, int level) {
        StringBuilder sb = new StringBuilder();
        for (int lev = 1; lev < level; lev++) {
            if (Objects.equals(bridge.get(lev), "U")) {
                sb.append(" O |");
                continue;
            }
            sb.append("   |");
        }
        return sb.toString();
    }

    private StringBuilder printDown(List<String> bridge, int level) {
        StringBuilder sb = new StringBuilder();
        for (int lev = 1; lev < level; lev++) {
            if (Objects.equals(bridge.get(lev), "D")) {
                sb.append(" O |");
                continue;
            }
            sb.append("   |");
        }
        return sb;
    }
}
