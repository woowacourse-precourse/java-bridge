package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge){
        this.bridge=bridge;
    }

    public boolean canGo(int index, String ud){
        return bridge.get(index).equals(ud);
    }
}
