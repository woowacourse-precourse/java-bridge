package bridge.view;

import bridge.model.OutputMessage;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printGameStartMsg() {
        System.out.println(OutputMessage.GAME_START_MSG);
        System.out.println();
    }

    public void printInputBridgeSizeMsg() {
        System.out.println(OutputMessage.INPUT_BRIDGE_SIZE_MSG);
    }

    public void printInputMoveCellMsg() {
        System.out.println(OutputMessage.INPUT_MOVE_CELL_MSG);
    }

    public void printRestartMsg() {
        System.out.println(OutputMessage.RESTART_MSG);
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
