package bridge;

import java.util.List;

import static bridge.Constants.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private int moveCount;
    private boolean isCorrect;

    public void printStart() {
        System.out.println(START_MESSAGE);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame, List<String> bridge) {
        moveCount = bridgeGame.moveCount - 1;
        isCorrect = bridgeGame.isCorrect;

        printMoving(bridge, UP);
        printMoving(bridge, DOWN);
        System.out.println();
    }

    private void printMoving(List<String> bridge, String upDown) {
        System.out.print(LEFT);
        for (int i = 0; i < moveCount; i++) {
            System.out.printf(isUpOrDown(bridge.get(i), upDown) + MIDDLE);
        }
        if (isCorrect) {
            System.out.printf(isUpOrDown(bridge.get(moveCount), upDown) + RIGHT);
            return;
        }
        if (bridge.get(moveCount).equals(upDown)) {
            System.out.print(SPACE + RIGHT);
            return;
        }
        System.out.print(WRONG + RIGHT);
    }

    private String isUpOrDown(String moving, String upDown) {
        if (moving.equals(upDown)) {
            return CORRECT;
        }
        return SPACE;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, List<String> bridge, int tryCount) {
        System.out.println(RESULT_MESSAGE);
        printMap(bridgeGame, bridge);
        printSuccess();
        System.out.println(TRY_COUNT_MESSAGE + tryCount);
    }

    public void printSuccess() {
        if (isCorrect) {
            System.out.println(SUCCESS_MESSAGE);
            return;
        }
        System.out.println(FAILURE_MESSAGE);
    }
}
