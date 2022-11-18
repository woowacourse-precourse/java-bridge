package bridge;

import java.util.List;
import java.util.StringJoiner;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String printMap(List<BridgeLocation> bridgeLocations) {
        StringJoiner upBridge = new StringJoiner(" | ", "[ ", " ]");
        StringJoiner downBridge = new StringJoiner(" | ", "[ ", " ]");
        for (BridgeLocation bridgeLocation : bridgeLocations) {
            if ("U".equals(bridgeLocation.getLocation())) {
                upBridge.add(bridgeLocation.getStateLocation());
                downBridge.add(" ");
            }
            if ("D".equals(bridgeLocation.getLocation())) {
                upBridge.add(" ");
                downBridge.add(bridgeLocation.getStateLocation());
            }
        }
        return new StringJoiner("\n").add(upBridge.toString()).add(downBridge.toString()).toString();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
