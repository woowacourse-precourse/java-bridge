package bridge.view;

import bridge.domain.GameStatus;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> result, List<String> user) {
        List<String> upLine = createLine(result, user, GameCommand.UP);
        List<String> downLine = createLine(result, user, GameCommand.DOWN);

        System.out.println(concatenateLine(upLine));
        System.out.println(concatenateLine(downLine)+"\n");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int attempts, List<List<String>> result, GameStatus gameStatus) {
        System.out.println("최종 게임 결과");
        printMap(result.get(0), result.get(1));

        System.out.println("게임 성공 여부: " + gameStatus.getMessage());
        System.out.print("총 시도한 횟수: " + attempts);
    }

    private String concatenateLine(List<String> line) {
        return "[ " +
                String.join(" | ", line) +
                " ]";
    }

    private List<String> createLine(List<String> result, List<String> user, GameCommand line) {
        return IntStream.range(0, result.size())
                .mapToObj(o -> {
                    if (line.equals(user.get(o)))
                        return result.get(o);
                    return " ";})
                .collect(Collectors.toList());
    }
}
