package bridge.domain.model;
import java.util.List;

public class Bridge {
    protected List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public String getBridge(int index) {
        return bridge.get(index);
    }

    public Integer bridgeLength(){return bridge.size();}
}
