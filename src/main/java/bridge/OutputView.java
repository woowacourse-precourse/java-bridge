package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void startGame() {
        System.out.println(Sentence.START);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int position, boolean available, List<String> bridge) {
        printUp(position, available, bridge);
        printDown(position, available, bridge);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    private void printUp(int position, boolean available, List<String> bridge) {
        System.out.print(Bridge.START);
        for (int i = 0; i < position; i++) {
            printBeforePosition(bridge.get(i), Input.UP);
        }
        printPosition(available, bridge.get(position), Input.UP);
        System.out.print(Bridge.END);
        System.out.println();
    }

    private void printDown(int position, boolean available, List<String> bridge) {
        System.out.print(Bridge.START);
        for (int i = 0; i < position; i++) {
            printBeforePosition(bridge.get(i), Input.DOWN);
        }
        printPosition(available, bridge.get(position), Input.DOWN);
        System.out.print(Bridge.END);
        System.out.println();
    }

    private void printBeforePosition(String actual, Input type) {
        if (actual == type.toString()) {
            System.out.print(Bridge.AVAILABLE);
            System.out.print(Bridge.DIVISION);
            return;
        }
        System.out.print(Bridge.BLANK);
        System.out.print(Bridge.DIVISION);
    }

    private void printPosition(Boolean available, String actual, Input type) {
        boolean equals = actual.equals(type.toString());
        if (available && equals) {
            System.out.print(Bridge.AVAILABLE);
        }
        if (available && !equals) {
            System.out.print(Bridge.BLANK);
        }
        if (!available && equals) {
            System.out.print(Bridge.BLANK);
        }
        if (!available && !equals) {
            System.out.print(Bridge.UNAVAILABLE);
        }
    }
}
