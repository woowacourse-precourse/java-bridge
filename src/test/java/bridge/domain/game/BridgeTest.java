package bridge.domain.game;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.exception.domain.WrongGeneratorException;
import bridge.helper.stub.StubBridgeNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeTest {

    @Nested
    @DisplayName("int size, BridgeNumberGenerator generator를 매개변수로 받는 생성자는")
    class DescribeIntGeneratorConstructorTest {

        private final int defaultSize = 3;

        @Nested
        @DisplayName("만약 유효한 다리의 크기와 다리를 생성하는 전략이 주어지면")
        class ContextWithValidSizeAndGenerator {

            @Test
            @DisplayName("다리를 생성해 Bridge를 초기화하고 반환한다.")
            void itReturnsBridge() {
                BridgeNumberGenerator validGenerator = new BridgeRandomNumberGenerator();

                assertThatCode(() -> new Bridge(defaultSize, validGenerator))
                        .doesNotThrowAnyException();
            }
        }

        @Nested
        @DisplayName("만약 유효한 다리의 크기와 유효하지 않은 다리를 생성하는 전략이 주어지면")
        class ContextWithSizeAndInvalidGenerator {

            @Test
            @DisplayName("WrongGeneratorException 예외가 발생한다")
            void itThrowsException() {
                BridgeNumberGenerator invalidGenerator = new StubBridgeNumberGenerator(List.of(2, 3, 4));

                assertThatThrownBy(() -> new Bridge(defaultSize, invalidGenerator))
                        .isInstanceOf(WrongGeneratorException.class);
            }
        }

        @Nested
        @DisplayName("만약 유효하지 않은 다리의 크기와 유효한 다리를 생성하는 전략이 주어지면")
        class ContextWithInvalidSizeAndGenerator {

            @ParameterizedTest
            @ValueSource(ints = {-1, 0, 1, 2, 21})
            @DisplayName("IllegalArgumentException 예외가 발생한다")
            void itThrowsException(int size) {
                BridgeNumberGenerator validGenerator = new BridgeRandomNumberGenerator();

                assertThatThrownBy(() -> new Bridge(size, validGenerator))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }
}