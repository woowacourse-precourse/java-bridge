package bridge.view;

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
    public boolean printMap(List<String> bridge, String moveAnswer, int index) {
        System.out.print("[ ");
        for (int i = 0; i <= index; i++) {
            if(!isCorrect(bridge, moveAnswer, index)) {
                return false;
            }
        }
        System.out.println(" ]");
        return true;
    }

    public boolean isCorrect(List<String> bridge, String moveAnswer, int index) {
        if (!bridge.get(index).equals(moveAnswer)) {
            System.out.print("X \t");
            return false;
        }

        System.out.print("O \t");
        return true;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {

    }
}
