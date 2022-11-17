package bridge.view.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.constant.Constants.*;
import static org.assertj.core.api.Assertions.*;

class ValidatorTest {

    @DisplayName("범위 테스트 - 범위를 벗어났을 때")
    @ValueSource(strings = {"-1", "2", "21"})
    @ParameterizedTest
    void validateForRangeException1(Integer input) {
        assertThatThrownBy(() -> {
            if (input < MIN_BRIDGE_SIZE || input > MAX_BRIDGE_SIZE) {
                throw new IllegalArgumentException(ERROR_MESSAGE + OUT_OF_RANGE_ERROR_MESSAGE);
            }
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + OUT_OF_RANGE_ERROR_MESSAGE);
    }

    @DisplayName("범위 테스트 - 범위를 벗어나지 않았을 때")
    @ValueSource(strings = {"3", "10", "20"})
    @ParameterizedTest
    void validateForRangeException2(Integer input) {
        Throwable t = catchThrowable(() -> {
            if (input < MIN_BRIDGE_SIZE || input > MAX_BRIDGE_SIZE) {
                throw new IllegalArgumentException(ERROR_MESSAGE + OUT_OF_RANGE_ERROR_MESSAGE);
            }
        });
        assertThat(t).doesNotThrowAnyException();
    }
}