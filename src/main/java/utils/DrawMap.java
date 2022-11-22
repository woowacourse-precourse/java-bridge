package utils;

import ui.MapImage;

import java.util.ArrayList;
import java.util.List;

public class DrawMap {

    private StringBuilder upperSideOfMap;
    private StringBuilder downSideOfMap;
    private List<String> bridge;
    private List<String> playerInput;
    private List<String> upperLog = new ArrayList<>();
    private List<String> lowerLog = new ArrayList<>();

    public DrawMap(List<String> bridge, List<String> playerInput) {
        this.upperSideOfMap = new StringBuilder();
        this.downSideOfMap = new StringBuilder();
        this.bridge = bridge;
        this.playerInput = playerInput;
    }

    /**
     * 다리의 위쪽 부분 결과를 저장하는 메서드
     */
    public void setUpperLog() {
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
    public void setLowerLog() {
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
}
