package bridge.Domain;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {
    private Bridge bridge;

    @BeforeEach
    void beforeEach() {
        List<String> bridge = List.of("U", "U", "D", "D", "U", "U", "D");
        this.bridge = new Bridge(bridge);
    }

    @Nested
    @DisplayName("isValidDistance 메소드 테스트")
    class TestIsValidDistance {

        @Test
        @DisplayName("유효한 길이인 경우 true 리턴")
        void isValidDistance_distanceIsLessThanLastPoint_returnTrue() {
            final int distance = 1;
            boolean result = bridge.isValidDistance(distance);
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("유효하지 않은 길이인 경우 false 리턴")
        void isValidDistance_distanceIsLongerThanLastPoint_returnFalse() {
            final int distance = 7;
            boolean result = bridge.isValidDistance(distance);
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("canCrossBridge 메소드 테스트")
    class TestCanCrossBridge {

        @Test
        @DisplayName("건널 수 있는 위치인 경우 true 리턴")
        void canCrossBridge_positionIsEqualWithBridge_returnTrue() {
            final int distance = 1;
            final String position = "U";
            boolean result = bridge.canCrossBridge(distance, position);
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("건널 수 없는 위치인 경우 false 리턴")
        void canCrossBridge_positionIsNotEqualWithBridge_returnFalse() {
            final int distance = 1;
            final String position = "D";
            boolean result = bridge.canCrossBridge(distance, position);
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("isBridgeEnd 메소드 테스트")
    class TestIsBridgeEnd {

        @Test
        @DisplayName("사용자가 다리 끝에 위치한 경우 true 리턴")
        void isBridgeEnd_distanceIsEqualWithEndOfBridge_returnTrue() {
            final int distance = 6;
            boolean result = bridge.isBridgeEnd(distance);
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("사용자가 다리 끝이 아닌 다른 곳에 위치한 경우 false 리턴")
        void isBridgeEnd_distanceIsNotEqualWithEndOfBridge_returnFalse() {
            final int distance = 0;
            boolean result = bridge.isBridgeEnd(distance);
            assertThat(result).isFalse();
        }
    }

}