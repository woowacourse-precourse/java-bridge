package domain;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.Bridge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeTest {
    private Bridge bridge;

    @BeforeEach
    void setUp() {
        this.bridge = new Bridge(3);
    }

    @DisplayName("다리 이동 시 이동 경로가 올바르게 갱신되는지 확인한다.")
    @Test
    void 다리_이동_테스트() {
        bridge.updateUserRoute("D");
        bridge.updateUserRoute("U");
        bridge.updateUserRoute("U");

        assertThat(bridge.getUserRoute()).containsExactly("D", "U", "U");
    }

    @DisplayName("한 다리에서의 이동 결과가 올바르게 반환되는지 확인한다.")
    @Test
    void 다리_내_이동_결과_반환_테스트() {
        List<String> testResult = new ArrayList<>();
        List<String> correctResult = new ArrayList<>(Arrays.asList( "O", " ", "X") );

        testResult.add(
                bridge.getMovingResultInTargetBridge("D", "D", "D")
        );
        testResult.add(
                bridge.getMovingResultInTargetBridge("U", "D", "D")
        );
        testResult.add(
                bridge.getMovingResultInTargetBridge("D", "U", "D")
        );

        assertThat(testResult.equals(correctResult));
    }
}