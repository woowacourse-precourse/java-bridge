package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStartGame() {
        System.out.println(ConstString.START_GAME);
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */


    public void printMap(List<String> bridge, List<String> current) {
        System.out.print(ConstString.BRIDGE_LEFT_FORMAT);
        printFirstRow(bridge, current);
        System.out.println(ConstString.BRIDGE_RIGHT_FORMAT);
        System.out.print(ConstString.BRIDGE_LEFT_FORMAT);
        printSecondRow(bridge, current);
        System.out.println(ConstString.BRIDGE_RIGHT_FORMAT);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
    private void printFirstRow(List<String> bridge, List<String> current) {
        for (int i = 0; i < current.size(); i++) {
            if (i != 0) {
                System.out.print(ConstString.BRIDGE_MIDDLE_FORMAT);
            }
            if (current.get(i).equals(ConstString.UP)) {
                printOneStepResult(bridge.get(i), current.get(i));
                continue;
            }
            System.out.print(ConstString.BRIDGE_NOTHING_FORMAT);
        }
    }

    private void printSecondRow(List<String> bridge, List<String> current) {
        for (int i = 0; i < current.size(); i++) {
            if (i != 0) {
                System.out.print(ConstString.BRIDGE_MIDDLE_FORMAT);
            }
            if (current.get(i).equals(ConstString.DOWN)) {
                printOneStepResult(bridge.get(i), current.get(i));
                continue;
            }
            System.out.print(ConstString.BRIDGE_NOTHING_FORMAT);
        }
    }

    private void printOneStepResult(String bridge, String current) {
        if (bridge.equals(current)) {
            System.out.print(ConstString.BRIDGE_CORRECT_FORMAT);
            return;
        }
        System.out.print(ConstString.BRIDGE_WRONG_FORMAT);
    }
}
