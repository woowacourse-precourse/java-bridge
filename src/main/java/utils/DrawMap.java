package utils;

import ui.MapImage;

import java.util.ArrayList;
import java.util.List;

public class DrawMap {

    private StringBuilder upperSideOfMap;
    private StringBuilder lowerSideOfMap;
    private List<String> upperLog = new ArrayList<>();
    private List<String> lowerLog = new ArrayList<>();

    public DrawMap() {
        this.upperSideOfMap = new StringBuilder();
        this.lowerSideOfMap = new StringBuilder();
    }

    public void reset() {
        upperLog = new ArrayList<>();
        lowerLog = new ArrayList<>();
    }

    /**
     * 다리 전체를 String 값으로 반환하는 메서드
     */
    public String returnMapToPrint(List<String> bridge, List<String> playerInput) {
        reset();
        setUpperLog(bridge, playerInput);
        setLowerLog(bridge, playerInput);
        setUpperSideOfMap();
        setLowerSideOfMap();
        return upperSideOfMap.toString() + "\n" + lowerSideOfMap.toString();
    }

    /**
     * 다리의 위쪽 부분 결과를 저장하는 메서드
     */
    public void setUpperLog(List<String> bridge, List<String> playerInput) {
        for (int i = 0; i < playerInput.size(); i++) {
            String currentInput = playerInput.get(i);
            if (currentInput.equals(bridge.get(i)) && currentInput.equals("U")) {
                upperLog.add("O");
                continue;
            } else if (!currentInput.equals(bridge.get(i)) && currentInput.equals("U")) {
                upperLog.add("X");
                continue;
            }
            upperLog.add(" ");
        }
    }

    /**
     * 다리의 아래쪽 부분 결과를 저장하는 메서드
     */
    public void setLowerLog(List<String> bridge, List<String> playerInput) {
        for (int i = 0; i < playerInput.size(); i++) {
            String currentInput = playerInput.get(i);
            if (currentInput.equals(bridge.get(i)) && currentInput.equals("D")) {
                lowerLog.add("O");
                continue;
            } else if (!currentInput.equals(bridge.get(i)) && currentInput.equals("D")) {
                lowerLog.add("X");
                continue;
            }
            lowerLog.add(" ");
        }
    }

    /**
     * 다리의 위쪽 부분 결과를 String 값으로 만드는 메서드
     */
    public void setUpperSideOfMap() {
        upperSideOfMap.append(MapImage.prefix);
        for (int i = 0; i < upperLog.size(); i++) {
            upperSideOfMap.append(upperLog.get(i));
            if (i != upperLog.size() - 1) {
                upperSideOfMap.append(MapImage.separation);
            }
        }
        upperSideOfMap.append(MapImage.postfix);
    }

    /**
     * 다리의 아래쪽 부분 결과를 String 값으로 만드는 메서드
     */
    public void setLowerSideOfMap() {
        lowerSideOfMap.append(MapImage.prefix);
        for (int i = 0; i < lowerLog.size(); i++) {
            lowerSideOfMap.append(lowerLog.get(i));
            if (i != lowerLog.size() - 1) {
                lowerSideOfMap.append(MapImage.separation);
            }
        }
        lowerSideOfMap.append(MapImage.postfix);
    }
}
