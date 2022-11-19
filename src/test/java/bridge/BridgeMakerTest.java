package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("BridgeMaker 클래스")
public class BridgeMakerTest {

    @Nested
    @DisplayName("makeBridge 메서드는")
    class Describe_makdeBridge {

        @Nested
        @DisplayName("0이 주어지면")
        class Context_with_zero {
            private BridgeMaker bridgeMaker = new BridgeMaker(() -> 0);

            @Test
            @DisplayName("D를 가진 List를 반환한다")
            void it_returns_D() {
                Assertions.assertThat(bridgeMaker.makeBridge(1))
                        .isEqualTo(List.of("D"));
            }
        }

        @Nested
        @DisplayName("1이 주어지면")
        class Context_with_one {
            private BridgeMaker bridgeMaker = new BridgeMaker(() -> 1);

            @Test
            @DisplayName("U를 가진 List를 반환한다")
            void it_returns_D() {
                Assertions.assertThat(bridgeMaker.makeBridge(1))
                        .isEqualTo(List.of("U"));
            }
        }

    }
}
