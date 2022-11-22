package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private List<String> bridge;

    public Bridge() {
        this.bridge = new ArrayList<>();
    }

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getSize() {
        return bridge.size();
    }

    public List<String> getBridge() {
        return bridge;
    }

    public void connect(String side) {
        bridge.add(side);
    }

    public boolean isSameSizeWith(Bridge bridge) {
        return this.getSize() == bridge.getSize();
    }

    public boolean matchWith(Bridge bridge) {
        return this.bridge.get(this.bridge.size()-1)
                .equals(bridge.getBridge().get(this.bridge.size()-1));
    }

    public String getLaneString(String side, List<String> answerBridge) {
        String laneString= "[";

        for (int i = 0 ; i < bridge.size() ; i++) {
            if (bridge.get(i).equals(side) && bridge.get(i).equals(answerBridge.get(i))) laneString += " O ";
            else if (bridge.get(i).equals(side) && !bridge.get(i).equals(answerBridge.get(i))) laneString += " X ";
            else if (!bridge.get(i).equals(side)) laneString += "   ";
            if (i < bridge.size()-1) laneString += "|";
        }
        laneString += "]";
        return laneString;
    }

}
