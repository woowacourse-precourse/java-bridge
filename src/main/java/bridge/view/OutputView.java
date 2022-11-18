package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_BRIDGE_GAME = "다리 건너기 게임을 시작합니다.";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, int progress, List<String> choices) {
        printUpSideBridge(bridge, progress, choices);
        printDownSideBridge(bridge,progress,choices);
    }

    private void printUpSideBridge(List<String> bridge, int progress, List<String> choices) {
        System.out.print("[ ");
        printBridgeProgress(progress, bridge, choices, "O | ", "  | ");
        if (choices.get(progress - 1).equals("U")){
            printLastSquare(bridge, progress, choices);
            return;
        }
        System.out.println("  ]");
    }

    private void printBridgeProgress(int progress, List<String> bridge, List<String> choices, String s, String s1) {
        for(int i = 0; i < progress - 1; i++){
            if (bridge.get(i).equals(choices.get(i))){
                System.out.print(s);
                continue;
            }
            System.out.print(s1);
        }
    }

    private void printDownSideBridge(List<String> bridge, int progress, List<String> choices) {
        System.out.print("[ ");
        printBridgeProgress(progress, bridge, choices, "  | ", "O | ");
        if (choices.get(progress - 1).equals("D")){
            printLastSquare(bridge, progress, choices);
            return;
        }
        System.out.println("  ]");
    }

    private void printLastSquare(List<String> bridge, int progress, List<String> choices) {
        if (bridge.get(progress - 1).equals(choices.get(progress - 1))){
            System.out.println("O ]");
            return;
        }
        System.out.println("X ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public static void printStartGame(){
        System.out.println(START_BRIDGE_GAME + "\n");
    }
}
