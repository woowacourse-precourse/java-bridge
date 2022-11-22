package bridge;

import static bridge.Constant.MOVE_DOWN;
import static bridge.Constant.MOVE_UP;

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
    public void printMap(List<String> movement, int idx, boolean moved) {
        if (moved) {
            printSuccess(movement, idx, MOVE_UP);
            printSuccess(movement, idx, MOVE_DOWN);
        }
        if (!moved) {
            printFailure(movement, idx, MOVE_UP);
            printFailure(movement, idx, MOVE_DOWN);
        }
    }

    private void printSuccess(List<String> movement, int idx, String pivot) {
        System.out.print("[ ");
        for (int i = 0; i <= idx; i++) {
            if (i != 0) {
                System.out.print("| ");
            }
            if (movement.get(i).equals(pivot)) {
                System.out.print("O ");
            }
            if (!movement.get(i).equals(pivot)) {
                System.out.print("  ");
            }
        }
        System.out.println("]");
    }

    private void printFailure(List<String> movement, int idx, String pivot) {
        System.out.print("[ ");
        for (int i = 0; i < idx; i++) {
            if (i != 0) {
                System.out.print("| ");
            }
            if (movement.get(i).equals(pivot)) {
                System.out.print("O ");
            }
            if (!movement.get(i).equals(pivot)) {
                System.out.print("  ");
            }
        }
        if (idx != 0) {
            System.out.print("| ");
        }
        if (movement.get(idx).equals(pivot)) {
            System.out.print("X ");
        }
        if (!movement.get(idx).equals(pivot)) {
            System.out.print("  ");
        }
        System.out.println("]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> movement, int idx, boolean succeed) {
        if (succeed) {
            printSuccess(movement, idx, MOVE_UP);
            printSuccess(movement, idx, MOVE_DOWN);
        }
        if (!succeed) {
            printFailure(movement, idx, MOVE_UP);
            printFailure(movement, idx, MOVE_DOWN);
        }
    }
}
