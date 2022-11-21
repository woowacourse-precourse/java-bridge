package bridge.domain;

import java.util.List;

public class Bridge {
    private List<String> birdge;

    public Bridge(List<String> birdge) {
        this.birdge = birdge;
    }

    public boolean contain(int index, String movement) {
        if (birdge.get(index).equals(movement)) {
            return true;
        }
        return false;
    }

    public boolean isSame(List<String> birdge) {
        if (this.birdge.equals(birdge)) {
            return true;
        }
        return false;
    }
}
