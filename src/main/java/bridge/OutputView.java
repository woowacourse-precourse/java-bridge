package bridge;

import java.util.EnumMap;
import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private OutputView() {
    }

    private static class OutputViewHelper {
        private static final OutputView INSTANCE = new OutputView();
    }

    public static OutputView getInstance() {
        return OutputViewHelper.INSTANCE;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(EnumMap<BridgeLine, List<String>> map) {
        System.out.println(buildString(map.get(BridgeLine.UPPER)));
        System.out.println(buildString(map.get(BridgeLine.LOWER)) + "\n");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(EnumMap<BridgeLine, List<String>> map, GameState gameState, int tryCnt) {
        System.out.println("최종 게임 결과");
        System.out.println(buildString(map.get(BridgeLine.UPPER)));
        System.out.println(buildString(map.get(BridgeLine.LOWER)) + "\n");

        System.out.println("게임 성공 여부: " + gameState.getMessage());
        System.out.println("총 시도한 횟수: " + tryCnt);
    }

    private String buildString(List<String> line) {
        StringJoiner stringJoiner = new StringJoiner(" | ", "[ ", " ]");
        for (var e : line) {
            stringJoiner.add(e);
        }
        return stringJoiner.toString();
    }
}
