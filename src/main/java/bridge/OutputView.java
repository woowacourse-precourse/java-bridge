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
    public void printResult(int position, boolean available, BridgeGame bridgeGame) {
        System.out.println(Sentence.OUTPUT_RESULT);
        printMap(position, available, bridgeGame.bridge);

        System.out.println(getSuccessOrFail(available));
        System.out.println(Sentence.OUTPUT_TRY + Integer.toString(bridgeGame.trying));
    }

    private void printUp(int position, boolean available, List<String> bridge) {
        System.out.print(Bridge.START);
        printBeforePosition(position, Input.UP, bridge);
        System.out.print(getPosition(available, bridge.get(position), Input.UP));
        System.out.print(Bridge.END);
        System.out.println();
    }

    private void printDown(int position, boolean available, List<String> bridge) {
        System.out.print(Bridge.START);
        printBeforePosition(position, Input.DOWN, bridge);
        System.out.print(getPosition(available, bridge.get(position), Input.DOWN));
        System.out.print(Bridge.END);
        System.out.println();
    }

    private void printBeforePosition(int position, Input type, List<String> bridge) {
        for (int i = 0; i < position; i++) {
            System.out.print(getBeforePosition(bridge.get(i), type));
            System.out.print(Bridge.DIVISION);
        }
    }

    private String getBeforePosition(String actual, Input type) {
        if (actual.equals(type.toString())) {
            return Bridge.AVAILABLE.toString();
        }
        return Bridge.BLANK.toString();
    }

    private String getPosition(Boolean available, String actual, Input type) {
        boolean equals = actual.equals(type.toString());
        if (available && equals) {
            return Bridge.AVAILABLE.toString();
        }
        if (!available && !equals) {
            return Bridge.UNAVAILABLE.toString();
        }
        return Bridge.BLANK.toString();
    }

    private String getSuccessOrFail(Boolean available) {
        if (available) {
            return Sentence.OUPTUT_SUCCESS.toString();
        }
        return Sentence.OUTPUT_FAIL.toString();
    }
}
