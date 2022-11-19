package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_BRIDGE_GAME = "다리 건너기 게임을 시작합니다.";
    private static final String BRIDGE_START ="[ ";
    private static final String BRIDGE_END =" ]";
    private static final String CORRECT = " O ";
    private static final String WRONG = " X ";
    private static final String BLANK = "  ";
    private static final String BAR = " | ";
    private StringBuilder sb = new StringBuilder();
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upSideBridge, List<String> downSideBridge) {
        printUpSideBridge(upSideBridge);
        printDownSideBridge(downSideBridge);
    }

    private void printUpSideBridge(List<String> upSideBridge) {
        System.out.print(BRIDGE_START);
        for(int i = 0; i < upSideBridge.size() - 1; i++){
            System.out.print(upSideBridge.get(i) + " | ");
        }
        System.out.print(upSideBridge.get(upSideBridge.size() - 1));
        System.out.println(BRIDGE_END);
    }

    private void printDownSideBridge(List<String> downSideBridge) {
        System.out.print(BRIDGE_START);
        for(int i = 0; i < downSideBridge.size() - 1; i++){
            System.out.print(downSideBridge.get(i) + " | ");
        }
        System.out.print(downSideBridge.get(downSideBridge.size() - 1));
        System.out.println(BRIDGE_END);
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
