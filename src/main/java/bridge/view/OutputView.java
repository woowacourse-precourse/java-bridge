package bridge.view;

import bridge.model.GameResult.Result;

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

    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String GAME_RESULT_MESSAGE = "게임 성공 여부: ";
    private static final String TRY_COUNT_MESSAGE = "총 시도한 횟수: ";
    private static final String FINAL_RESULT_MESSAGE = "최종 게임 결과";


    public void printStart() {
        out.println(GAME_START_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> bridges) {
        for (List<String> bridge : bridges) {
            out.print(BRIDGE_START);
            printEachBridge(bridge);
            out.println(BRIDGE_END);
        }
        out.println();
    }

    private void printEachBridge(List<String> bridge) {
        bridge = createSpaceByOutputFormat(bridge);

        boolean isFirst = true;
        for (String round : bridge) {
            printEachRound(isFirst, round);
            isFirst = false;
        }
    }

    private List<String> createSpaceByOutputFormat(List<String> bridge) {
        return bridge.stream()
                .map(i -> SPACE + i + SPACE)
                .collect(Collectors.toList());
    }

    private void printEachRound(Boolean isFirst, String round) {
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
    public void printResult(int tryCount, String scoreMessage) {
        out.println(GAME_RESULT_MESSAGE + scoreMessage);
        out.println(TRY_COUNT_MESSAGE + tryCount);
    }

    public void printFinalRecord(List<List<String>> bridges) {
        System.out.println(FINAL_RESULT_MESSAGE);
        printMap(bridges);
    }
}