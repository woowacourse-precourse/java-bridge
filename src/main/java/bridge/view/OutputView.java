package bridge.view;

import bridge.model.Result;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.out;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final static String BRIDGE_START = "[";
    private final static String BRIDGE_END = "]";
    private final static String SPACE = " ";
    private final static String BAR = "|";

    public static void printStart() {
        out.println("다리 건너기 게임을 시작합니다.\n");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<List<String>> bridges) {
        for (List<String> bridge : bridges) {
            out.print(BRIDGE_START);
            printEachBridge(bridge);
            out.println(BRIDGE_END);
        }
        out.println();
    }

    private static void printEachBridge(List<String> bridge) {
        bridge =createSpace(bridge);

        boolean isFirst = true;
        for (String round : bridge) {
            printEachRound(isFirst, round);
            isFirst = false;
        }
    }

    private static List<String> createSpace(List<String> bridge) {
        return bridge.stream()
                .map(i -> SPACE + i + SPACE)
                .collect(Collectors.toList());
    }

    private static void printEachRound(Boolean isFirst, String round) {
        if (!isFirst) {
            out.print(BAR);
        }
        out.print(round);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(Result result) {
        int tryCount = result.getTryCount();
        String scoreMessage = result.getScoreMessage();

        out.println("게임 성공 여부: " + scoreMessage);
        out.println("총 시도한 횟수: " + tryCount);
    }

    public static void printFinalResult(List<List<String>> bridges) {
        System.out.println("최종 게임 결과");
        printMap(bridges);
    }
}