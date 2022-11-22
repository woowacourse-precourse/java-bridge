package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

@DisplayName("BridgeMaker 클래스")
public class BridgeMakerTest {

    @Nested
    @DisplayName("makeBridge 메서드는")
    class Describe_makdeBridge {

        @Nested
        @DisplayName("3 이하 20 이상에 해당하지 않는 값이 주어지면")
        class Context_not_in_range_input {
            private BridgeMaker bridgeMaker = new BridgeMaker(() -> 0);

            @ParameterizedTest
            @ValueSource(ints = {0, 1, 2, 21, 50})
            @DisplayName("오류를 반환한다")
            void it_returns_error(Integer input) {
                Assertions.assertThatThrownBy(() -> bridgeMaker.makeBridge(input))
                        .isInstanceOf(IllegalArgumentException.class);

            }

        }

        @Nested
        @DisplayName("0, 0, 0이 주어지면")
        class Context_with_zero {
            private BridgeMaker bridgeMaker = new BridgeMaker(() -> 0);

            @Test
            @DisplayName("D, D, D를 가진 List를 반환한다")
            void it_returns_D() {
                Assertions.assertThat(bridgeMaker.makeBridge(3))
                        .isEqualTo(List.of("D", "D", "D"));
            }
        }

        @Nested
        @DisplayName("1, 1, 1이 주어지면")
        class Context_with_one {
            private BridgeMaker bridgeMaker = new BridgeMaker(() -> 1);

            @Test
            @DisplayName("U, U, U를 가진 List를 반환한다")
            void it_returns_D() {
                Assertions.assertThat(bridgeMaker.makeBridge(3))
                        .isEqualTo(List.of("U", "U", "U"));
            }
        }

    }
}
