package bridge.model;

import bridge.view.InputView;

/**
 * 다리 건너기 게임을 관리하는 클래스, 게임 진행하기
 */
public class BridgeGame {

    private String retry;
    private static int gameCount = 1;

    public static void move() {
//        InputView.moveCount = Console.readLine();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        InputView.readGameCommand();
        gameCount++;
    }
}
