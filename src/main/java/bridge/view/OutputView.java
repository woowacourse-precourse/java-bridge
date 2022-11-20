package bridge.view;

import java.util.List;

import static bridge.util.MapMaker.makeMap;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> userMoves, List<Boolean> results) {
        System.out.println(makeMap(userMoves, results));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int tries, List<String> userMoves, List<Boolean> results) {
        System.out.println("\n최종 게임 결과");
        printMap(userMoves, results);
        String result = "실패";
        if (results.get(results.size() - 1)) {
            result = "성공";
        }
        System.out.printf("게임 성공 여부: %s\n", result);
        System.out.printf("총 시도한 횟수: %d\n", tries);
    }
}
