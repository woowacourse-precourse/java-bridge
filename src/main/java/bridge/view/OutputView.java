package bridge.view;

import java.util.Iterator;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String BRIDGE_INIT = "[ ";
    private static final String BRIDGE_END = " ]";
    private static final String BRIDGE_MIDDLE= " | ";

    private static final StringBuilder builder = new StringBuilder();

    public void printInit() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upBridge, List<String> downBridge) {
        printBridgeFormat(upBridge);
        printBridgeFormat(downBridge);
    }

    private void printBridgeFormat(List<String> bridge) {
        builder.append(BRIDGE_INIT);
        formatElements(bridge);
        builder.append(BRIDGE_END);
        System.out.println(builder);
        builder.setLength(0);
    }

    private void formatElements(List<String> bridge) {
        Iterator<String> bridgeList = bridge.iterator();
        while (bridgeList.hasNext()) {
            builder.append(bridgeList.next());

            if(bridgeList.hasNext()) {
                builder.append(BRIDGE_MIDDLE);
            }
        }
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
