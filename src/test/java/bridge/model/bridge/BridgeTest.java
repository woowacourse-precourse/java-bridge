package bridge.model.bridge;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeTest {
    List<String> positionOfNodes = List.of("U", "D", "D", "U", "D");
    Bridge bridge = Bridge.of(positionOfNodes);

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    @DisplayName("마지막 노드를 비교 했을 때 올바른 결과가 나온다.")
    public void compareNodeOf(int index) {
        List<Node> answer = List.of(Node.UP, Node.DOWN, Node.DOWN, Node.UP, Node.DOWN);
        boolean same = bridge.compareNodeOf(index, answer.get(index));
        assertTrue(same);
    }
}