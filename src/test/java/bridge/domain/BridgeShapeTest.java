package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeShapeTest {

    @DisplayName("건널 수 있는 칸의 값을 숫자로 가져오는 테스트")
    @Nested
    class Shape {
        @DisplayName("위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D값으로 나타낸다 0인 경우 아래 칸, 1인 경우 위 칸이 된다")
        @Test
        void shape() {
            assertAll(
                    () -> assertThat(BridgeShape.shape(0)).isEqualTo("D"),
                    () -> assertThat(BridgeShape.shape(1)).isEqualTo("U")
            );
        }

        @ParameterizedTest(name = "건널 수 있는 칸 숫자가 올바른 값이 아닌 경우 예외 처리한다.")
        @ValueSource(ints = {-2, -1, 2, 3, 10})
        void shapeException(int number) {
            assertThatThrownBy(() -> BridgeShape.shape(number)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("BridgeShape를 값으로 생성하는 테스트")
    @Nested
    class Of {
        @ParameterizedTest(name = "올바른 값이 아닌 경우 예외 처리한다.")
        @NullAndEmptySource
        @ValueSource(strings = {" ", "u", "d", "UP", "DOWN", "abc", "cde"})
        void bridgeShapeOfNoSuchValue(String shapeName) {
            assertThatThrownBy(() -> BridgeShape.of(shapeName))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("BridgeShape 값으로 BridgeShape 를 생성한다.")
        @Test
        void bridgeShapeOf() {
            assertAll(
                    () -> assertThat(BridgeShape.of("U")).isEqualTo(BridgeShape.UP),
                    () -> assertThat(BridgeShape.of("D")).isEqualTo(BridgeShape.DOWN)
            );
        }
    }
}
