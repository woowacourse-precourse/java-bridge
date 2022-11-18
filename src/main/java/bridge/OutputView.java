package bridge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final String UP = "U";
    private final String DOWN = "D";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(HashMap<String, List<String>> bridgeGameResult) {
        System.out.println(replaceResult(bridgeGameResult, UP));
        System.out.println(replaceResult(bridgeGameResult, DOWN));
    }

    private String replaceResult(HashMap<String, List<String>> bridgeGameResult, String position) {
        return Arrays.toString(bridgeGameResult.get(position).toArray())
                .replace("[", "[ ")
                .replace("]", " ]")
                .replace(", ", " | ");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(HashMap<String, List<String>> bridgeGameResult) {
        System.out.println(PrintWord.RESULT);
        printMap(bridgeGameResult);
        System.out.println(PrintWord.IS_SUCCESS +
                IsSuccess.isSuccess(bridgeGameResult).getWord());
        System.out.println(PrintWord.COUNT + BridgeGame.getTotalCount());
    }
}
