package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static String upBridge = "[]";
    private static String downBridge = "[]";
    private static OutputString outputString;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    /**
     * tf가 true이면 한칸 더 앞으로 가야함
     * [ O ]
     * [   ]
     * [ O |   ]
     * [   | X ]
     * [ O |   |   ]
     * [   | O | O ]
     */
    public void start() {
        System.out.println(OutputString.START);
        System.out.println(OutputString.INPUT);
    }

    public void printMap(String input, boolean tf, int idx) {
        System.out.println(OutputString.MOVE);
        if (tf == true) {
            printTrue(input);
            if (idx == 0)
                input.replace("|", "");
            return;
        }
        printFalse(input);
        if (idx == 0)
            input.replace("|", "");
    }

    public void printTrue(String input) {
        if (input.equals("U")) {
            upBridge.replace("]", "| O ]");
            downBridge.replace("]", "|   ]");
            return;
        }
        if (input.equals("D")) {
            upBridge.replace("]", "|   ]");
            downBridge.replace("]", "| O ]");
            return;
        }
    }

    public void printFalse(String input) {
        if (input.equals("U")) {
            upBridge.replace("]", "| O ]");
            downBridge.replace("]", "|   ]");
            return;
        }
        if (input.equals("D")) {
            upBridge.replace("]", "|   ]");
            downBridge.replace("]", "| X ]");
            return;
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println(upBridge);
        System.out.println(downBridge);
    }
}
