package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<String> bridge = new ArrayList<>();
    private List<String> moveTrace = new ArrayList<>();

    void setBridge(List<String> bridge){
        this.bridge = bridge;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public List<String> getMoveTrace() {
        return this.moveTrace;
    }
}
