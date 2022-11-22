package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BridgeMakerTest {

    private static final String UP_SYMBOL = "U";
    private static final String DOWN_SYMBOL = "D";

    private final BridgeNumberGenerator generator = mock(BridgeNumberGenerator.class);
    private final BridgeMaker bridgeMaker = new BridgeMaker(generator);

    @ParameterizedTest(name = "[{index}] 입력받은 길이({arguments})에 대하여 다리를 생성할 수 있다.")
    @ValueSource(ints = {3, 10, 20, 21})
    void createBridgeByNumber(final int length) {
        // given
        when(generator.generate()).thenReturn(1);

        // when
        List<String> bridge = bridgeMaker.makeBridge(length);

        // then
        assertThat(bridge.size()).isEqualTo(length);
    }

    @ParameterizedTest(name = "[{index}] 0과 1이 아닌 다른 숫자({arguments})로 생성되는 경우 예외가 발생한다.")
    @ValueSource(ints = {-1, 2, 10})
    void createBridgeByNot0Or1(final int generatedNumber) {
        // given
        int length = 5;
        when(generator.generate()).thenReturn(generatedNumber);

        // when, then
        assertThatThrownBy(() -> bridgeMaker.makeBridge(length))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("생성된 다리는 U와 D로만 이루어져야 한다.")
    @Test
    void createdBridgeOnlyConsistByUAndD() {
        // given
        int length = 5;
        when(generator.generate()).thenReturn(1, 1, 1, 0, 0);

        // when
        List<String> bridge = bridgeMaker.makeBridge(length);

        // then
        for (String symbol : bridge) {
            assertThat(symbol.equals(UP_SYMBOL)
                    || symbol.equals(DOWN_SYMBOL))
                    .isTrue();
        }
    }
}