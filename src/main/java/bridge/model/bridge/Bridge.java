package bridge.model.bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    public static final int MAX_SIZE = 20;
    public static final int MIN_SIZE = 3;
    private List<Node> nodes;

    private Bridge(int size) {
        nodes = new ArrayList<>(size);
    }

    public static Bridge of(List<String> generatedBridge) {
        Bridge bridge = new Bridge(generatedBridge.size());
        for (String position : generatedBridge) {
            bridge.nodes.add(Node.of(position));
        }
        return bridge;
    }

    public boolean compareNodeOf(int index, Node other) {
        return nodes.get(index).equals(other);
    }
}
