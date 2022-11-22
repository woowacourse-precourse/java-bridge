package bridge;

import java.util.List;

public class Bridge {
    private List<String> footholds;
    private List<String> crossed;

    public Bridge(List<String> footholds, List<String> crossed) {
        this.footholds = footholds;
        this.crossed = crossed;
    }

    public List<String> getFootholds() {
        return this.footholds;
    }

    public List<String> getCrossed() {
        return this.crossed;
    }

}
