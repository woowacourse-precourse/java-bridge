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
        StringBuilder upSide = new StringBuilder("[");
        StringBuilder printDown = new StringBuilder("[");
        makeUpSide(result, bridge, upSide);
        makeDownSide(result, bridge, printDown);
        upSide.append("]");
        printDown.append("]");

        System.out.println(upSide);
        System.out.println(printDown);
    }

    private void makeUpSide(List<String> result, List<String> bridge, StringBuilder upSide) {
        for (int i = 0; i < result.size(); i++) {
            if (bridge.get(i).equals("U")) {
                upSide.append(" ".concat(result.get(i)).concat(" "));
            } else if (bridge.get(i).equals("D")) {
                upSide.append("   ");
            }
            if (i != result.size() - 1) {
                upSide.append("|");
            }
        }
    }

    private void makeDownSide(List<String> result, List<String> bridge, StringBuilder downSide) {
        for (int i = 0; i < result.size(); i++) {
            if (bridge.get(i).equals("D")) {
                downSide.append(" ".concat(result.get(i)).concat(" "));
            } else if (bridge.get(i).equals("U")) {
                downSide.append("   ");
            }
            if (i != result.size() - 1) {
                downSide.append("|");
            }
        }
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

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
}
