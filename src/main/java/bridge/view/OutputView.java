package bridge.view;

import java.util.ArrayList;
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
    public void printMap(List<String> result, List<String> user) {
        List<String> upLine = createLine(result, user, UP);
        List<String> downLine = createLine(result, user, DOWN);

        System.out.println(concatenateLine(upLine));
        System.out.println(concatenateLine(downLine));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    private String concatenateLine(List<String> line) {
        return "[ " +
                String.join(" | ", line) +
                " ]";
    }

    private List<String> createLine(List<String> result, List<String> user, String line) {
        List<String> output = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {
            output.add(" ");

            if (user.get(i).equals(line))
                output.set(i, result.get(i));
        }

        return output;
    }
}
