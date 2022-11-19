package bridge.view;

import static bridge.constant.BridgeMove.*;
import static bridge.constant.BridgeControl.*;
import static bridge.constant.message.InputMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStartMessage() {
        System.out.println(START.getMessage());
        System.out.println(BRIDGE_LENGTH.getMessage());
    }

    public void printPlayerMoveMessage() {
        System.out.printf(SELECT_MOVE.getMessage(), UP.getIdentifier(), DOWN.getIdentifier());
    }

    public void printPlayControlMessage() {
        System.out.printf(PLAY_CONTROL.getMessage(), RESTART.getIdentifier(), QUIT.getIdentifier());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
