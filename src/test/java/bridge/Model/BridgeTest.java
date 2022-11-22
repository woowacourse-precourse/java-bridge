package bridge.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;



class BridgeTest {
    private static final String ERROR = "[ERROR]";
    private static final int MIN_RANGE = 3;
    private static final int MAX_RANGE = 20;


    @DisplayName("범위 외의 숫자 입력 시 예외 throw")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 55, 101})
    void 예외_범위를_벗어난_숫자(int size) {
        assertThatThrownBy(() -> assertThat(new Bridge(size)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위 외의 숫자 입력 시 예외 메세지 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 55, 101})
    void 에러_범위를_벗어난_숫자(int size) {
        assertThatThrownBy(() -> assertThat(new Bridge(size)))
                .hasMessageContaining(ERROR);
    }

    @DisplayName("범위 내의 숫자가 예외를 발생하지 않는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {MIN_RANGE, 5, MAX_RANGE})
    void 입력_범위_내의_숫자(int size) {
        assertDoesNotThrow(() -> new Bridge(size));

    }
}