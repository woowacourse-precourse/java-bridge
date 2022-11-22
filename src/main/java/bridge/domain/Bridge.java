package bridge.domain;

import bridge.setting.Setting;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        System.out.println(bridge);
        this.bridge = bridge;
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public boolean isCorrect(int index, char settingCode) {
        return bridge.get(index-1).equals(String.valueOf(settingCode));
    }

    public List<String> myBridge(int nth, boolean isWin) {
        List<String> ox = new ArrayList<>();

        for (int i = 0; i < Setting.BRIDGE_COUNT; i++) {
            List<String> tmpOX = new ArrayList<>();

            tmpOX.addAll(oxBeforeLast(nth, i));
            System.out.println(tmpOX);
            tmpOX.add(getCanvas(isWin, nth-1, i));
            System.out.println(tmpOX);

            ox.add(String.join(" | ", tmpOX));
        }

        return ox;
    }

    private List<String> oxBeforeLast(int nth, int row) {
        List<String> line = new ArrayList<>();

        for (int j = 0; j < nth-1; j++) {
            line.add(getCanvas(true, j, row));
        }

        return line;
    }

    private String getCanvas(boolean isRight, int index, int row) {
        if (isRight) {
            if (index == row)
                return "O";
            return " ";
        }

        if (index != row)
            return "X";
        return " ";
    }
}
