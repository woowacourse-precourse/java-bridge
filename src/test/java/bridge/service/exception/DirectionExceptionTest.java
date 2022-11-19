package bridge.service.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("[예외처리] 다리 방향 예외")
class DirectionExceptionTest {

    @DisplayName("이동이 U D 중 하나가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"A", "B", "C", "E", "F", "UP", "DOWN"})
    @ParameterizedTest
    void checkMovingIsCorrectFormatTest(String move) {
        assertThatThrownBy(() -> DirectionException.checkMovingIsCorrectFormat(move))
                .isInstanceOf(IllegalArgumentException.class);
    }
}