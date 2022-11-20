package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMakerStatic implements IBridgeMaker {
    String bridge;

    public BridgeMakerStatic(String bridge) {
        this.bridge = bridge;
    }

    @Override
    public List<String> makeBridge(int size) {
        List<String> ret = new ArrayList<>();
        for (int iter = 0; iter < size; ++iter)
            ret.add(this.bridge.substring(iter, iter + 1));
        return ret;
    }
}
