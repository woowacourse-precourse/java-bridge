package bridge.domain;

import java.util.List;

public class Bridge {
    private List<String> map;

    private Integer size;

    public Bridge(List<String> map, Integer size) {
        this.map = map;
        this.size = size;
    }

    public Bridge(List<String> twoWays) {
        this.map = twoWays;
    }

    public List<String> getMap() {
        return map;
    }

    public Integer getSize() {
        return size;
    }

    public boolean canGo(Integer index, String way){
        return map.get(index).equals(way);
    }
}
