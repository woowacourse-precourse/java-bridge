package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BridgeStateTest {

    @DisplayName("다리 한칸을 성공적으로 지나가면, 'O', ' '가 표시된다.")
    @Test
    void createSuccessMovingBridgeState() {
        // given
        BridgeState bridgeState = new BridgeState();
        String upperExpected = "O";
        String lowerExpected = " ";
        // when
        bridgeState.update(StepResult.getStepResult("U", true));
        // then
        assertThat(bridgeState.getUpperBridge().get(0)).isEqualTo(upperExpected);
        assertThat(bridgeState.getLowerBridge().get(0)).isEqualTo(lowerExpected);
    }

    @DisplayName("다리 한칸을 지나가지 못했다면, 'X', ' '가 표시된다.")
    @Test
    void createFailMovingBridgeState() {
        // given
        BridgeState bridgeState = new BridgeState();
        String upperExpected = " ";
        String lowerExpected = "X";
        // when
        bridgeState.update(StepResult.getStepResult("D", false));
        // then
        assertThat(bridgeState.getUpperBridge().get(0)).isEqualTo(upperExpected);
        assertThat(bridgeState.getLowerBridge().get(0)).isEqualTo(lowerExpected);
    }
}