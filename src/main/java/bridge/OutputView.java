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
    public void printMap(BridgeGame bridgeGame) {
        for(int row = 0; row < 2; row++) {
            printMapPrefix();
            if (row == 0)
                printBridgeRow("U", bridgeGame.getBridges(), bridgeGame.getUserMoves());
            else if (row == 1)
                printBridgeRow("D", bridgeGame.getBridges(), bridgeGame.getUserMoves());
            printMapPostfix();
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean successed, int tries) {
        System.out.print("\n게임 성공 여부: ");
        if (successed)
            System.out.println("성공");
        else if (!successed)
            System.out.println("실패");
        System.out.printf("총 시도한 횟수: %d", tries);

    }

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printReadBridgeLength() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printReadNextBridgeStep() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRestart() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }

    private void printMapPrefix() {
        System.out.print("[");
    }

    private void printMapPostfix() {
        System.out.println("]");
    }

    private void printBridgeRow(String target, List<String> bridges, List<String> userMoves) {
        for(int order = 0; order < userMoves.size(); order++) {
            boolean matched = bridges.get(order).equals(userMoves.get(order));
            if (!userMoves.get(order).equals(target)) printSpace();
            else if (matched) printMatched();
            else if (!matched) printUnMatched();
            if (order != userMoves.size() - 1) printBar();
        }
    }

    private void printBar() {
        System.out.print("|");
    }

    private void printUnMatched() {
        System.out.print(" X ");
    }

    private void printMatched() {
        System.out.print(" O ");
    }

    private void printSpace() {
        System.out.print("   ");
    }

    public void printTotalMap(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame);
    }
}
