package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> result, List<String> bridge) {
        StringBuilder printUp = new StringBuilder("[");
        StringBuilder printDown = new StringBuilder("[");
        for (int i = 0; i < result.size(); i++) {
            if (bridge.get(i).equals("U")) {
                printUp.append(" ".concat(result.get(i)).concat(" "));
                printDown.append("   ");
            }else if (bridge.get(i).equals("D")) {
                printDown.append(" ".concat(result.get(i)).concat(" "));
                printUp.append("   ");
            }
            if (i != result.size() - 1) {
                printUp.append("|");
                printDown.append("|");
            }
        }
        printUp.append("]");
        printDown.append("]");

        System.out.println(printUp);
        System.out.println(printDown);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String gameStatus, int cnt, List<String> result, List<String> bridge) {
        System.out.println("최종 게임 결과");
        this.printMap(result, bridge);
        System.out.printf("게임 성공 여부: %s\n", gameStatus);
        System.out.printf("총 시도한 횟수: %d", cnt);
    }
}
