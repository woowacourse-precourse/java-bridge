package domain;

import static org.assertj.core.api.Assertions.*;

import bridge.domain.Bridge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

        assertThat(bridge.getUserRoute().get(0).equals("D")).isTrue();
        assertThat(bridge.getUserRoute().get(1).equals("U")).isTrue();
        assertThat(bridge.getUserRoute().get(2).equals("U")).isTrue();
    }
}