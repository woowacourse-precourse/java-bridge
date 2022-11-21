package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, int currentUserPosition, boolean isFail) {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    private List<String> getUpperBridgeResult(List<String> bridge, int currentUserPosition, boolean isFail) {
        List<String> upperBridgeResult = new ArrayList<>();
        for (int bridgeIndex = 0; bridgeIndex < currentUserPosition - 1; bridgeIndex++) {
            upperBridgeResult.add(compareBridgeBlock(bridge.get(bridgeIndex), "U"));
        }
        upperBridgeResult.add(compareFailBridgeBlock(bridge.get(currentUserPosition - 1), "U", isFail));
        return upperBridgeResult;
    }

    private List<String> getLowerBridgeResult(List<String> bridge, int currentUserPosition, boolean isFail) {
        List<String> lowerBridgeResult = new ArrayList<>();
        for (int bridgeIndex = 0; bridgeIndex < currentUserPosition - 1; bridgeIndex++) {
            lowerBridgeResult.add(compareBridgeBlock(bridge.get(bridgeIndex), "D"));
        }
        lowerBridgeResult.add(compareFailBridgeBlock(bridge.get(currentUserPosition - 1), "D", isFail));
        return lowerBridgeResult;
    }

    private String compareBridgeBlock(String bridgeBlock, String comparatorBridgeBlock) {
        if (bridgeBlock.equals(comparatorBridgeBlock)) {
            return "O";
        }
        return " ";
    }

    private String compareFailBridgeBlock(String bridgeBlock, String comparatorBridgeBlock, boolean isFail) {
        if (bridgeBlock.equals(comparatorBridgeBlock) && isFail) {
            return "X";
        }
        return " ";
    }
}
