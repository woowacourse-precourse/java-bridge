package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private String upperMap;
    private String lowerMap;

    public String getUpperMap() {
        return upperMap;
    }

    public String getLowerMap() {
        return lowerMap;
    }

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

    public void initializeMap() {
        upperMap = "[";
        lowerMap = "[";
    }

    public void makeMap(List<String> bridge, List<String> bridgeStatus) {
        int size = bridge.size();

        for (int idx = 0; idx < size; idx++) {
            addOToMap(bridge, bridgeStatus, idx);
            continueOrFinishMap(bridgeStatus, size, idx);
            addXAndFinishMap(bridge, bridgeStatus, idx);
        }
    }

    public void addOToMap(List<String> bridge, List<String> bridgeStatus, int idx) {
        if (bridgeStatus.get(idx) == "O") {
            addOWhenBridgeIsUpper(bridge, idx);
            addOWhenBridgeIsLower(bridge, idx);
        }
    }

    private void addOWhenBridgeIsUpper(List<String> bridge, int idx) {
        if (bridge.get(idx) == "U") {
            upperMap += " O";
            lowerMap += "  ";
        }
    }

    private void addOWhenBridgeIsLower(List<String> bridge, int idx) {
        if (bridge.get(idx) == "D") {
            upperMap += "  ";
            lowerMap += " O";
        }
    }

    public void continueOrFinishMap(List<String> bridgeStatus, int size, int idx) {
        if (bridgeStatus.get(idx) == "O") {
            continueMap(size, idx);
            finishMap(size, idx);
        }
    }

    private void continueMap(int size, int idx) {
        if (idx != size - 1) {
            upperMap += " |";
            lowerMap += " |";
        }
    }

    private void finishMap(int size, int idx) {
        if (idx == size - 1) {
            upperMap += " ]";
            lowerMap += " ]";
        }
    }

    public void addXAndFinishMap(List<String> bridge, List<String> bridgeStatus, int idx) {
        if (bridgeStatus.get(idx) == "X") {
            addXAndFinishWhenBridgeIsUpper(bridge, idx);
            addXAndFinishWhenBridgeIsLower(bridge, idx);
        }
    }

    private void addXAndFinishWhenBridgeIsUpper(List<String> bridge, int idx) {
        if (bridge.get(idx) == "U") {
            upperMap += "   ]";
            lowerMap += " X ]";
        }
    }

    private void addXAndFinishWhenBridgeIsLower(List<String> bridge, int idx) {
        if (bridge.get(idx) == "D") {
            upperMap += " X ]";
            lowerMap += "   ]";
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println("최종 게임 결과");
        System.out.println(upperMap);
        System.out.println(lowerMap);
        System.out.println();
    }

    public void printSuccess() {
        System.out.println("게임 성공 여부: 성공");
    }

    public void printFailure() {
        System.out.println("게임 성공 여부: 실패");
    }

    public void printTrialCnt(int trialCnt) {
        System.out.println("총 시도한 횟수: " + trialCnt);
    }
}
