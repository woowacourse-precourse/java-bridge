package bridge;

import java.util.List;

public class Bridge {
    private List<String> bridge;
    private List<String> crossed;

    public Bridge(List<String> bridge, List<String> crossed) {
        this.bridge = bridge;
        this.crossed = crossed;
    }

    public List<String> getBridge() {
        return this.bridge;
    }

    public List<String> getCrossed() {
        return this.crossed;
    }
    
}
