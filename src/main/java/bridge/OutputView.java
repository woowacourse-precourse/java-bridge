package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private int moveCount;
    private boolean isCorrect;

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame, List<String> bridge) {
        moveCount = bridgeGame.moveCount;
        isCorrect = bridgeGame.isCorrect;

        System.out.print("[ ");
        printMoving(bridge, "U");
        printMoving(bridge, "D");
        System.out.println();
    }

    private void printMoving(List<String> bridge, String upDown) {
        for (int i = 0; i < moveCount - 1; i++) {
            System.out.printf(isUpOrDown(bridge.get(i), upDown) + " | ");
        }
        if (isCorrect) {
            System.out.printf(isUpOrDown(bridge.get(moveCount), upDown) + " ]\n");
            return;
        }
        if (bridge.get(moveCount).equals(upDown)) {
            System.out.print("X ]\n");
            return;
        }
        System.out.print(" ]\n");
    }

    private String isUpOrDown(String moving, String upDown) {
        if (moving.equals(upDown)) {
            return "O";
        }
        return " ";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
