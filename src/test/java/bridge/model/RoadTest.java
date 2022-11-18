package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.constant.message.GameErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RoadTest {
    @DisplayName("존재하지 않은 이동 명령어일 때 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"u", "Q", " ", ""})
    void testNotValidDirection(String direction) {
        assertThatThrownBy(() -> new Road(direction)).hasMessage(GameErrorMessage.NO_SUCH_DIRECTION.getMessage())
                .isInstanceOf(IllegalStateException.class);
    }
}
