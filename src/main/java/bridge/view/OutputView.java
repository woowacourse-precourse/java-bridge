package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private String lowerMap;
    private String upperMap;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> bridgeStatus) {
        initializeMap();
        makeMap(bridge, bridgeStatus);

        System.out.println(upperMap);
        System.out.println(lowerMap);
        System.out.println();
    }

    private void initializeMap() {
        upperMap = "[";
        lowerMap = "[";
    }

    public void makeMap(List<String> bridge, List<String> bridgeStatus) {
        int size = bridge.size();

        for (int idx = 0; idx < size; idx++) {
            addOToMap(bridge, bridgeStatus, idx);

            if (bridgeStatus.get(idx) == "O") {
                if (idx != size - 1) {
                    upperMap += " |";
                    lowerMap += " |";
                }

                if (idx == size - 1) {
                    upperMap += " ]";
                    lowerMap += " ]";
                }
            }

            if (bridgeStatus.get(idx) == "X") {
                if (bridge.get(idx) == "U") {
                    upperMap += "   ]";
                    lowerMap += " X ]";
                }

                if (bridge.get(idx) == "D") {
                    upperMap += " X ]";
                    lowerMap += "   ]";
                }
            }
        }
    }

    private void addOToMap(List<String> bridge, List<String> bridgeStatus, int idx) {
        if (bridgeStatus.get(idx) == "O") {
            if (bridge.get(idx) == "U") {
                upperMap += " O";
                lowerMap += "  ";
            }

            if (bridge.get(idx) == "D") {
                upperMap += "  ";
                lowerMap += " O";
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
