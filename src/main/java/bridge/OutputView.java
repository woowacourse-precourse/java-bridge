package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private String getBlankOrX() {
        if (BridgeGame.isCorrect) return " ";
        return "X";
    }

    private void print(String shape, String oppositeShape) {
        int SIZE = BridgeGame.userPicks.size();
        System.out.print("[");
        for (int i = 0; i < SIZE; i++) {
            if (BridgeGame.bridge.get(i).equals(shape) && BridgeGame.userPicks.get(i).equals(shape))
                System.out.print(" O ");
            if (!BridgeGame.userPicks.get(i).equals(shape) && BridgeGame.userPicks.get(i).equals(oppositeShape))
                System.out.print(" " + getBlankOrX() + " ");
            if (i <= SIZE - 2) System.out.print("|");
        }
        System.out.println("]");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        print("U", "D");
        print("D", "U");
    }

    private String getSuccessOfFailure() {
        if (BridgeGame.isCorrect) return "성공";
        return "실패;";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int gameCount) {
        System.out.println("최종 게임 결과");
        printMap();
        System.out.println("\n게임 성공 여부: " + getSuccessOfFailure());
        System.out.println("총 시도한 횟수: " + gameCount);
    }
}
