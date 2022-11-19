package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> currentPath) {
        for (int i = 0; i < 2; i++) {
            printOneRow(currentPath.get(i));
        }
    }

    private void printOneRow(String rowOfBridge) {
        printStartOfRow();
        printNodesWithSeparator(rowOfBridge);
        printEndOfRow();
    }

    private void printNodesWithSeparator(String rowOfBridge) {
        char[] row = rowOfBridge.toCharArray();
        System.out.print(row[0]);
        for (int j = 1; j < row.length; j++) {
            System.out.printf(" | %c", row[j]);
        }
    }

    private void printEndOfRow() {
        System.out.println(" ]");
    }

    private void printStartOfRow() {
        System.out.print("[ ");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
