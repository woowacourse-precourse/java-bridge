package bridge;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    @DisplayName("다리 길이 입력에 대한 예외 처리")
    @ValueSource(strings = {"2", "21"})
    @ParameterizedTest
    void checkBridgeSizeTest(Integer input) {
        assertThatThrownBy(() -> new InputView().checkBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸 입력에 대한 예외 처리")
    @Test
    void checkMovingTest() {
        assertThatThrownBy(() -> new InputView().checkMoving("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시도 여부 입력에 대한 예외 처리")
    @Test
    void checkGameCommandTest() {
        assertThatThrownBy(() -> new InputView().checkGameCommand("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
