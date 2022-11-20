package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    static final String YES = "O";
    static final String NO = "X";
    static final String EMPTY = " ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame, Boolean correct) {
        printUp(bridgeGame, correct);
        printDown(bridgeGame, correct);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, boolean correct) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame, correct);
        System.out.println();
        gameSuccess(correct);
        printRetries(bridgeGame);
    }

    private void gameSuccess(boolean correct) {
        if (correct) {
            System.out.println("게임 성공 여부: 성공");
            return;
        }
        System.out.println("게임 성공 여부: 실패");
    }

    private void printRetries(BridgeGame bridgeGame) {
        System.out.printf("총 시도한 횟수: %d", bridgeGame.getTryCnt());
    }

    public void printUp(BridgeGame bridgeGame, Boolean correct) {
        System.out.print("[ ");
        for (int i = 0; i < bridgeGame.getNextIndex(); i++) {
            boolean match = bridgeGame.getBridge().get(i).equals(InputView.UP);
            drawMapContent(bridgeGame, correct, i, match);
        }
        System.out.println(" ]");
    }

    public void printDown(BridgeGame bridgeGame, Boolean correct) {
        System.out.print("[ ");
        for (int i = 0; i < bridgeGame.getNextIndex(); i++) {
            boolean match = bridgeGame.getBridge().get(i).equals(InputView.DOWN);
            drawMapContent(bridgeGame, correct, i, match);
        }
        System.out.println(" ]");
    }

    private void drawMapContent(BridgeGame bridgeGame, Boolean correct, int i, boolean match) {
        if (i == bridgeGame.getNextIndex() - 1 && !correct) {
            if (!match) System.out.print(NO);
            if (match) System.out.print(EMPTY);
            return;
        }
        if (match) System.out.print(YES);
        if (!match) System.out.print(EMPTY);
        if (i < bridgeGame.getNextIndex() - 1) System.out.print(" | ");
    }

    public void startGame() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }
}
