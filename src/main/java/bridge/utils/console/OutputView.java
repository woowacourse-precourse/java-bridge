package bridge.utils.console;

import static bridge.utils.message.GameMessagesUtil.SHOW_BRIDGE;

import bridge.domain.MoveResult;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MoveResult moveResults) {
        printParamMessage(SHOW_BRIDGE.getMessage(), moveResults.getUpMovesString(), moveResults.getDownMovesString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printMessage() {
        System.out.println();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printParamMessage(String message, String upMoves, String downMoves) {
        System.out.println(String.format(message, upMoves, downMoves));
    }
}
