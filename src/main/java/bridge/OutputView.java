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
    public void printMap(List<String> bridge, List<String> states) {
        System.out.print("[");
        printUpperMap(bridge, states);
        System.out.println(" ]");
        System.out.print("[");
        printBottomMap(bridge, states);
        System.out.println(" ]\n");
    }

    public void printUpperMap(List<String> bridge, List<String> states) {
        for (int i = 0; i < states.size(); i++) {
            printUpperMoving(isUpperMap(bridge, states, i), states, i);
            if (i != states.size() - 1) {
                System.out.print(" |");
            }
        }
    }

    private boolean isUpperMap(List<String> bridge, List<String> states, int i) {
        return (bridge.get(i).equals(Bridge.UP.getStr()) && states.get(i).equals("O")) || (!bridge.get(i).equals(Bridge.UP.getStr()) && !states.get(i).equals("O"));
    }

    private void printUpperMoving(boolean isUpper, List<String> states, int i) {
        if (isUpper) {
            System.out.print(" " + states.get(i));
            return ;
        }
        System.out.print("  ");
    }

    public void printBottomMap(List<String> bridge, List<String> states) {
        for (int i = 0; i < states.size(); i++) {
            printUpperMoving(!isUpperMap(bridge, states, i), states, i);
            if (i != states.size() - 1) {
                System.out.print(" |");
            }
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, List<String> lastStates, String gameCommand, int count) {
        String result = "성공";
        System.out.println("최종 게임 결과");
        printMap(bridge, lastStates);
        if (gameCommand.equals("Q")) {
            result = "실패";
        }
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + count);
    }
}
