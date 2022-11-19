package bridge.View;

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
    private void printMapUntilPosition(List<String> bridge, int position, String upDown) {
        System.out.print("[");
        for (int i = 0; i < position; i++) {
            String answer = bridge.get(i);
            if (answer.equals(upDown)) {
                System.out.print(" O ");
            } else {
                System.out.print("   ");
            }
            System.out.print("|");
        }
    }

    private void printMapNowPosition(boolean print, boolean correct) {
        if (print) {
            if (correct) {
                System.out.print(" O ");
            } else {
                System.out.print(" X ");
            }
        } else {
            System.out.print("   ");
        }
        System.out.println("]");
    }

    public void printMap(List<String> bridge, int position, boolean correct) {
        for (String upDown : new String[]{"U", "D"}) {
            printMapUntilPosition(bridge, position, upDown);
            boolean print = bridge.get(position).equals(upDown);
            printMapNowPosition(print, correct);
        }

    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
