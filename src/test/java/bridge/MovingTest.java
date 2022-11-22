package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MovingTest {

    @DisplayName("플레이어 이동 예외 처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "s", "u", "d"})
    void createMovingException(String direction) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Moving.of(direction));
    }
}