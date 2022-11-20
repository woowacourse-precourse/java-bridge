package bridge.view;

import java.util.List;

public class OutputView {

    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_NEXT_MOVEMENT = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String OPEN_BRIDGE = "[ ";
    private static final String CLOSE_BRIDGE = " ]";
    private static final String BRIDGE_PARTITION = " | ";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printBridgeSizeInputMessage() {
        System.out.println(INPUT_BRIDGE_SIZE);
    }

    public static void printNextMovementInputMessage() {
        System.out.println(INPUT_NEXT_MOVEMENT);
    }

    public static void printMap(List<Character> upperMap, List<Character> lowerMap) {
        printOneLineOfBridge(upperMap);
        printOneLineOfBridge(lowerMap);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult() {
    }

    public static void printBlankLine() {
        System.out.println();
    }

    private static void printOneLineOfBridge(List<Character> line) {
        int lastIndex = line.size() - 1;
        System.out.print(OPEN_BRIDGE);
        for (int i = 0; i < lastIndex; i++) {
            System.out.print(line.get(i));
            System.out.print(BRIDGE_PARTITION);
        }
        System.out.print(line.get(lastIndex));
        System.out.println(CLOSE_BRIDGE);
    }
}
