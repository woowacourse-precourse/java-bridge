package bridge.Domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;



class BridgeTest {
    @DisplayName("범위 외의 숫자 예외 throw")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 55, 101})
    void 예외_범위를_벗어난_숫자(int size) {
        assertThatThrownBy(() -> assertThat(new Bridge(size)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}