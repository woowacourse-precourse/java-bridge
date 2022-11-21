package bridge.view;

import bridge.engine.BridgeReporter;

import java.util.List;

import static bridge.view.Message.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private BridgeReporter reporter;

    public OutputView() {
        this.reporter = new BridgeReporter("|");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap(List<String> bridge, List<String> userDirection) {
        System.out.println(reporter.reportBridge(bridge, userDirection));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    public void printResult() {
    }

    public void printStartMessage() {System.out.println(START);}

    public void printInputBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printInputBridge() {
        System.out.println(INPUT_BRIDGE);
    }

    public void printRetryMessage() {System.out.println(RETRY);}
}
