package bridge;

import java.util.List;

import static bridge.PrintMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static String upBridge;
    private static String downBridge;

    public void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
        System.out.print(ENTER);
    }

    public void printInputBridgeSizeMessage() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
    }

    public void printChooseSpaceToMoveMessage() {
        System.out.print(ENTER);
        System.out.println(CHOOSE_SPACE_TO_MOVE_MESSAGE);
    }

    public void printChooseRestartGameMessage() {
        System.out.print(ENTER);
        System.out.println(CHOOSE_RESTART_GAME_MESSAGE);
    }


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridges) {
        System.out.println(bridges.get(0));
        System.out.println(bridges.get(1));
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
