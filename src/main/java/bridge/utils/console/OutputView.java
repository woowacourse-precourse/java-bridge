package bridge.utils.console;

import static bridge.utils.message.GameMessagesUtil.RESULT;
import static bridge.utils.message.GameMessagesUtil.SHOW_BRIDGE;
import static bridge.utils.message.GameMessagesUtil.SUCCESS_OR_NOT;
import static bridge.utils.message.GameMessagesUtil.TOTAL_TRY;

import bridge.domain.BridgeGame;
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
    public void printMap(MoveResult moveResult) {
        printParamMessage(SHOW_BRIDGE.getMessage(), moveResult.getUpMovesString(), moveResult.getDownMovesString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame game) {
        printMessage(RESULT.getMessage());
        printMap(game.getMoveResult());
        printParamMessage(SUCCESS_OR_NOT.getMessage(), game.getResultText());
        printParamMessage(TOTAL_TRY.getMessage(), game.getTotalCount());
    }

    public void printMessage() {
        System.out.println();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    private void printParamMessage(String message, int param) {
        System.out.println(String.format(message, param));
    }

    private void printParamMessage(String message, String param) {
        System.out.println(String.format(message, param));
    }

    public void printParamMessage(String message, String upMoves, String downMoves) {
        System.out.println(String.format(message, upMoves, downMoves));
    }
}
