package bridge.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.bridge.Bridge;
import bridge.model.bridge.Node;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class PlayerStepsTest {
    @Nested
    class CompareWithLastNode {
        @Test
        @DisplayName("브릿지와 마지막 노드의 위치가 일치할 경우 true를 반환한다.")
        public void returnTrueWhenTheNodeMatches() {
            Bridge mockBridge = Bridge.of(List.of("D", "U"));
            PlayerSteps steps = new PlayerSteps(2);
            steps.add(Node.DOWN);
            steps.add(Node.UP);
            assertTrue(steps.isLastStepSameWithBridge(mockBridge));
        }

        @Test
        @DisplayName("브릿지와 마지막 노드의 위치가 일치하지 않는 경우 false를 반환한다.")
        public void returnFalseWhenTheNodeDoesNotMatche() {
            Bridge mockBridge = Bridge.of(List.of("D", "U"));
            PlayerSteps steps = new PlayerSteps(2);
            steps.add(Node.DOWN);
            steps.add(Node.DOWN);
            assertFalse(steps.isLastStepSameWithBridge(mockBridge));
        }
    }

    @Nested
    @DisplayName("isLastNodeUp() 테스트")
    class GetLastNodeTest {
        BridgeNumberGenerator bridgeNumberGenerator;

        @BeforeEach
        public void setUp() {
            bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        }

        @ParameterizedTest
        @EnumSource(Node.class)
        @DisplayName("마지막으로 추가한 노드와 steps의 마지막 노드가 같은지 확인할 수 있다.")
        public void returnUp(Node node) {
            PlayerSteps playerSteps = new PlayerSteps(5);
            for (int i = 0; i < 4; i++) {
                int randomPosition = bridgeNumberGenerator.generate();
                Node randomNode = Node.of(randomPosition);
                playerSteps.add(randomNode);
            }
            playerSteps.add(node);

            assertTrue(playerSteps.lastStepEquals(node));
        }
    }

    @Nested
    @DisplayName("getSteps() 테스트")
    class GetNodes {
        PlayerSteps playerSteps;

        @BeforeEach
        public void setUp() {
            playerSteps = new PlayerSteps(10);
        }

        @Test
        @DisplayName("추가한 순서대로 노드를 읽어온다")
        public void getNodes() {
            List<Node> willBeAdded = List.of(Node.UP, Node.DOWN, Node.DOWN, Node.UP);
            for (Node node : willBeAdded) {
                playerSteps.add(node);
            }
            List<Node> steps = playerSteps.getSteps();

            assertEquals(steps, willBeAdded);
        }
    }
}