package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.exception.domain.WrongGeneratorException;
import bridge.helper.stub.StubBridgeNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    @Nested
    @DisplayName("makeBridge 메소드는")
    class DescribeMakeBridgeMethodTest {

        private BridgeMaker bridgeMaker;

        @Nested
        @DisplayName("만약 유효한 generator가 초기화된 상태에서 다리의 크기가 주어지면")
        class ContextWithValidGeneratorAndSizeTest {

            @BeforeEach
            void initBridgeMaker() {
                BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
                bridgeMaker = new BridgeMaker(generator);
            }

            @ParameterizedTest
            @ValueSource(ints = {3, 4, 5, 6, 7})
            @DisplayName("주어진 크기만큼 다리를 생성해 반환한다")
            void it_returns_bridge(int input) {
                List<String> bridge = bridgeMaker.makeBridge(input);

                assertThat(bridge.size()).isSameAs(input);
            }
        }

        @Nested
        @DisplayName("만약 유효하지 않은 generator가 초기화된 상태에서 다리의 크기가 주어지면")
        class ContextWithInvalidGeneratorAndSizeTest {

            @BeforeEach
            void initInvalidBridgeMaker() {
                BridgeNumberGenerator generator = new StubBridgeNumberGenerator(List.of(2, 3, 4));
                bridgeMaker = new BridgeMaker(generator);
            }

            @Test
            @DisplayName("WrongGeneratorException 예외가 발생한다")
            void it_throws_exception() {
                assertThatThrownBy(() -> bridgeMaker.makeBridge(3))
                        .isInstanceOf(WrongGeneratorException.class);
            }
        }
    }
}
