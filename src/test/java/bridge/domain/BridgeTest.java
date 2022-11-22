package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class BridgeTest {

    @DisplayName("다리 길이가 범위에 맞지 않으면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "21", "99999999999999"})
    void ThrowExceptionIfSizeIsIncorrect(String size) {
        assertThatThrownBy(() -> new Bridge(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
}
