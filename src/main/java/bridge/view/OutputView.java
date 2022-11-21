package bridge.view;

import bridge.domain.GameResult;

import java.util.List;
import java.util.Stack;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 다리 건너기 게임 시작 문구를 출력한다.
     */
    public void printWelcome() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     */
    public void printMap(List<List<String>> map) {
        List<String> top = map.get(0);
        List<String> bottom = map.get(1);
        System.out.println(parseLine(top));
        System.out.println(parseLine(bottom));
    }

    private String parseLine(List<String> line) {
        Stack<String> buffer = new Stack<>();
        buffer.add("[");
        for (String step : line) {
            buffer.add(step);
            buffer.add("|");
        }
        buffer.pop();
        buffer.add("]");
        return String.join(" ", buffer);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> map, boolean isSuccess, int tryCount) {
        System.out.println("최종 게임 결과");
        printMap(map);
        System.out.println("게임 성공 여부: " + GameResult.valueOf(isSuccess));
        System.out.println("총 시도한 횟수: " + tryCount);
    }
}
