package bridge.model;

import static org.junit.jupiter.api.Assertions.*;

import bridge.model.bridge.Bridge;
import bridge.model.bridge.Node;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
            assertTrue(steps.compareLastStepWithBridge(mockBridge));
        }

        @Test
        @DisplayName("브릿지와 마지막 노드의 위치가 일치하지 않는 경우 false를 반환한다.")
        public void returnFalseWhenTheNodeDoesNotMatche() {
            Bridge mockBridge = Bridge.of(List.of("D", "U"));
            PlayerSteps steps = new PlayerSteps(2);
            steps.add(Node.DOWN);
            steps.add(Node.DOWN);
            assertFalse(steps.compareLastStepWithBridge(mockBridge));
        }
    }

}