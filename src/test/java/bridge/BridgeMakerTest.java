package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMakerTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    static BridgeMaker maker;

    @BeforeAll
    static void init() {
        maker = new BridgeMaker(() -> 1);
    }

    @DisplayName("길이에 맞는 다리를 생성한다.")
    @Test
    void makeBridge() {
        // given
        int size = 6;

        // when, then
        assertThat(maker.makeBridge(size).size()).isEqualTo(size);
    }

    @DisplayName("다리의 사이즈가 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -3, 30})
    void invalidBridgeSize(int size) {
        assertThatThrownBy(() -> maker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
