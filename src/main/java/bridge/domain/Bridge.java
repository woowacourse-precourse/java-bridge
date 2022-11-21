package bridge.domain;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge){
        this.bridge = bridge;
    }

    public boolean isMoveAble(int position, String route){
        return bridge.get(position).equals(route);
    }
}
