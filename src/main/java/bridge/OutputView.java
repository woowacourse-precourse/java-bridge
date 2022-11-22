package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private StringBuilder upperBridge;
    private StringBuilder lowerBridge;

    public OutputView() {
        upperBridge = new StringBuilder();
        lowerBridge = new StringBuilder();
        clear();
    }

    private void clear() {
        upperBridge.setLength(0);
        upperBridge.append(Constants.BRIDGE_BLOCK_START);
        lowerBridge.setLength(0);
        lowerBridge.append(Constants.BRIDGE_BLOCK_START);
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void println() {
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, int position, String status) {
        clear();
        for (int idx = 0; idx <= position - 1; idx++) {
            appendBridgeMiddle(bridge, idx);
        }
        appendUpCorrect(bridge, position, status);
        appendDownCorrect(bridge, position, status);
        appendDownWrong(bridge, position, status);
        appendUpWrong(bridge, position, status);
        printBridge();
    }

    private void appendBridgeMiddle(List<String> bridge, int idx) {
        if (bridge.get(idx).equals(Control.UP.getControlOrder())) {
            upperBridge.append(Constants.CORRECT).append(Constants.BRIDGE_BLOCK_MIDDLE);
            lowerBridge.append(Constants.EMPTY).append(Constants.BRIDGE_BLOCK_MIDDLE);
            return;
        }
        upperBridge.append(Constants.EMPTY).append(Constants.BRIDGE_BLOCK_MIDDLE);
        lowerBridge.append(Constants.CORRECT).append(Constants.BRIDGE_BLOCK_MIDDLE);
    }

    public void printBridge() {
        println(upperBridge.toString());
        println(lowerBridge.toString());
    }

    private void appendUpWrong(List<String> bridge, int position, String status) {
        if (bridge.get(position).equals(Control.DOWN.getControlOrder()) && status.equals(Constants.WRONG)) {
            upperBridge.append(Constants.WRONG).append(Constants.BRIDGE_BLOCK_END);
            lowerBridge.append(Constants.EMPTY).append(Constants.BRIDGE_BLOCK_END);
        }
    }

    private void appendDownWrong(List<String> bridge, int position, String status) {
        if (bridge.get(position).equals(Control.UP.getControlOrder()) && status.equals(Constants.WRONG)) {
            upperBridge.append(Constants.EMPTY).append(Constants.BRIDGE_BLOCK_END);
            lowerBridge.append(Constants.WRONG).append(Constants.BRIDGE_BLOCK_END);
        }
    }

    private void appendDownCorrect(List<String> bridge, int position, String status) {
        if (bridge.get(position).equals(Control.DOWN.getControlOrder()) && status.equals(Constants.CORRECT)) {
            upperBridge.append(Constants.EMPTY).append(Constants.BRIDGE_BLOCK_END);
            lowerBridge.append(Constants.CORRECT).append(Constants.BRIDGE_BLOCK_END);
        }
    }

    private void appendUpCorrect(List<String> bridge, int position, String status) {
        if (bridge.get(position).equals(Control.UP.getControlOrder()) && status.equals(Constants.CORRECT)) {
            upperBridge.append(Constants.CORRECT).append(Constants.BRIDGE_BLOCK_END);
            lowerBridge.append(Constants.EMPTY).append(Constants.BRIDGE_BLOCK_END);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        println();
        println(Constants.MESSAGE_ENDING);
        printBridge();
    }

    public void printInit() {
        println(Constants.MESSAGE_INIT);
        println();
        println(Constants.MESSAGE_INPUT_SIZE);
    }

    public void printMove() {
        println();
        println(Constants.MESSAGE_MOVE);
    }

    public void printRetry() {
        println();
        println(Constants.MESSAGE_INPUT_RETRY);
    }

    public void printStatistic(boolean currentStatus, int numTry) {
        println();
        StringBuilder statistic = new StringBuilder();
        statistic.append(Constants.MESSAGE_RESULT);
        makeResultStatus(statistic, currentStatus);
        statistic.append(Constants.NEXT_LINE).append(Constants.MESSAGE_TOTAL_TRY).append(numTry);
        println(statistic.toString());
    }

    private void makeResultStatus(StringBuilder statistic, boolean currentStatus) {
        if (!currentStatus) {
            statistic.append(Constants.MESSAGE_FAIL);
            return;
        }
        statistic.append(Constants.MESSAGE_SUCCESS);
    }

}
