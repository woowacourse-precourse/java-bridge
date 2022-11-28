package bridge.model.bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    public static final int MAX_SIZE = 20;
    public static final int MIN_SIZE = 3;

    /**
     * 게임 시작 시 만들어지는 다리(정답)을 저장해두는 리스트
     */
    private final List<Node> nodes;

    private Bridge(int size) {
        nodes = new ArrayList<>(size);
    }

    /**
     *
     * @param generatedBridge: "U" 또는 "D"를 원소로 가지는 리스트
     * @return 생성된 Bridge 객체
     */
    public static Bridge of(List<String> generatedBridge) {
        Bridge bridge = new Bridge(generatedBridge.size());
        for (String position : generatedBridge) {
            bridge.nodes.add(Node.of(position));
        }
        return bridge;
    }

    public int size() {
        return nodes.size();
    }

    public boolean compareNodeOf(int index, Node other) {
        return nodes.get(index).equals(other);
    }
}
