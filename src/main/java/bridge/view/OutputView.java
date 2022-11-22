package bridge.view;

import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.Statistics;

import static bridge.config.BridgeGameCommand.COMMAND_BRIDGE_DOWN;
import static bridge.config.BridgeGameCommand.COMMAND_BRIDGE_UP;
import static bridge.view.message.io.IOMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridge currentBridge, Bridge answerBridge) {
        int wrongIndex = currentBridge.findWrongIndex(answerBridge);

        System.out.print(MESSAGE_BRIDGE_PREFIX);
        printUpperBridge(currentBridge, wrongIndex);
        System.out.println(MESSAGE_BRIDGE_SUFFIX);

        System.out.print(MESSAGE_BRIDGE_PREFIX);
        printLowerBridge(currentBridge, wrongIndex);
        System.out.println(MESSAGE_BRIDGE_SUFFIX);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
        System.out.println();
        System.out.println(MESSAGE_RESULT);
        printMap(bridgeGame.getCurrentBridge(), bridgeGame.getAnswerBridge());
        System.out.println();
        printStatistics(bridgeGame.getStatistics());
    }

    private void printUpperBridge(Bridge currentBridge, int wrongIndex) {
        for (int index = 0; index < currentBridge.length(); index++) {
            if (currentBridge.position(index).equals(COMMAND_BRIDGE_UP) && index == wrongIndex) {
                System.out.print(MESSAGE_BRIDGE_WRONG);
                return;
            }
            printSubBridge(currentBridge, index, COMMAND_BRIDGE_UP);
        }
    }

    private void printLowerBridge(Bridge currentBridge, int wrongIndex) {
        for (int index = 0; index < currentBridge.length(); index++) {
            if (currentBridge.position(index).equals(COMMAND_BRIDGE_DOWN) && index == wrongIndex) {
                System.out.print(MESSAGE_BRIDGE_WRONG);
                return;
            }
            printSubBridge(currentBridge, index, COMMAND_BRIDGE_DOWN);
        }
    }

    private void printSubBridge(Bridge currentBridge, int index, String position) {
        if (currentBridge.position(index).equals(position)) {
            System.out.print(MESSAGE_BRIDGE_CORRECT);
        }
        if (!currentBridge.position(index).equals(position)) {
            System.out.print(MESSAGE_BRIDGE_EMPTY);
        }
        if (index < currentBridge.length() - 1) {
            System.out.print(MESSAGE_BRIDGE_MIDDLE);
        }
    }

    private void printStatistics(Statistics statistics) {
        boolean clear = statistics.isClear();
        printClear(clear);

        int countRetry = statistics.getCountRetry();
        System.out.println(MESSAGE_RETRY + countRetry);
    }

    private void printClear(boolean clear) {
        if (clear) {
            System.out.println(MESSAGE_CLEAR);
            return;
        }
        System.out.println(MESSAGE_FAIL);
    }

    public void printGameCommand() {
        System.out.println(MESSAGE_INPUT_RETRY);
    }

    public void printStart() {
        System.out.println(MESSAGE_START);
    }

    public void printInputMoving() {
        System.out.println(MESSAGE_INPUT_MOVING);
    }

    public void printInputLength() {
        System.out.println();
        System.out.println(MESSAGE_INPUT_LENGTH);
    }
}
