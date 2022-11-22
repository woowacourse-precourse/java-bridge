package bridge;


import bridge.controller.GameController;
import bridge.model.Moving;
import bridge.model.ReEnter;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final static String RE_START = "R";

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static boolean move(String computer, String userInput) {
        return computer.equals(userInput);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static boolean retry() {
        if (ReEnter.reGetExitOrRestart().equals(RE_START)) {
            Moving.clearMoving();
            return true;
        }
        GameController.printMovingAndResult();
        return false;
    }
}
