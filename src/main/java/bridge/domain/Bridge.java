package bridge.domain;

import java.util.List;

public class Bridge {
    private List<String> twoWays;

    public Bridge(List<String> twoWays) {
        this.twoWays = twoWays;
    }

    boolean canGo(Integer index, String way){
        return twoWays.get(index).equals(way);
    }
}
