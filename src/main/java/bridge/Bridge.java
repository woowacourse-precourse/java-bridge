package bridge;

import java.util.List;

public class Bridge {
    private List<String> footholds;
    private List<String> crossed;
    private int tried;

    public Bridge(List<String> footholds, List<String> crossed) {
        this.footholds = footholds;
        this.crossed = crossed;
        tried = 1;
    }

    public List<String> getFootholds() {
        return this.footholds;
    }

    public List<String> getCrossed() {
        return this.crossed;
    }

    public int getTried() {
        return this.tried;
    }

    public void setCrossed(List<String> crossed) {
        this.crossed = crossed;
    }

    public void setTried(int tried) {
        this.tried = tried;
    }

}
