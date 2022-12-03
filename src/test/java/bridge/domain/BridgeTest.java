package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeTest {

    static Bridge bridge;

    @BeforeAll
    static void init() {
        bridge = new Bridge(List.of("U", "U", "U"));
    }

    @Nested
    @DisplayName("다리의 해당 위치가")
    class If_that_bridge_location {

        @Test
        @DisplayName("건널 수 없다면 false 반환을 테스트")
        void can_not_cross_then_return_false() {
            // given

            // when
            boolean canCross = bridge.canCross(0, "D");

            // then
            assertThat(canCross).isFalse();
        }

        @Test
        @DisplayName("건널 수 있다면 true 반환을 테스트")
        void can_cross_then_return_true() {
            // given

            // when
            boolean canCross = bridge.canCross(0, "U");

            // then
            assertThat(canCross).isTrue();
        }
    }
}