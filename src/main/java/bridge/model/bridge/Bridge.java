package bridge.model.bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<Node> nodes;

    private Bridge(int size) {
        nodes = new ArrayList<>(size);
    }

    public static Bridge of(List<String> generatedBridge) {
        Bridge bridge = new Bridge(generatedBridge.size());
        for (String position : generatedBridge) {
            bridge.nodes.add(Node.valueOf(position));
        }
        return bridge;
    }
}
