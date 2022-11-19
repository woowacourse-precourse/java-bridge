package bridge.domain;

import java.util.List;

public class Bridge {
    private List<String> map;

    public Bridge(List<String> twoWays) {
        this.map = twoWays;
    }

    public List<String> getMap() {
        return map;
    }

    public boolean canGo(Integer index, String way){
        return map.get(index).equals(way);
    }
}
