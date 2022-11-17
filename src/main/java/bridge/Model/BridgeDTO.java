package bridge.Model;

import java.util.List;

public class BridgeDTO {
    private List<String> bridge;
    private int size;

    public List<String> getBridge() {
        return this.bridge;
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getSize(){
        return this.size;
    }
    public void setSize(int size) {
        this.size = size;
    }
}
