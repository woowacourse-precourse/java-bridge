package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private List<String> bridge;

    public Bridge(){
        this.bridge = new ArrayList<>();
    }

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public List<String> copyBridge() {
        return new ArrayList<>(bridge);
    }

    public boolean checkTheBridge(String s) {
        return bridge.get(0).equals(s);
    }

    public void passToTheNextSpace() {
        bridge.remove(0);
    }

    public int getSize() {
        return bridge.size();
    }

    public void addString(String s) {
        bridge.add(s);
    }

    public String getDataForOutput(int i) {
        return bridge.get(i);
    }

    @Override
    public String toString() {
        return bridge.toString();
    }
}
