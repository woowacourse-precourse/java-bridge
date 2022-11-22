package bridge.domain;

import java.util.List;

public class Bridge {
    private List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public String getCommandAt(int index){
        return bridge.get(index);
    }
    public int getSize(){
        return bridge.size();
    }

}
