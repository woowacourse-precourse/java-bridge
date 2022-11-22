package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    @DisplayName("입력된 번호가 숫자가 아니거나 다리 크기 범위 밖일 경우에 대한 예외 처리")
    @ValueSource(strings = {"0", "100", "12A"})
    @ParameterizedTest
    void tryNumInput_numberIsFault_exception() {

        assertThatThrownBy(() -> InputView.tryNumInput()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 칸이 U, D가 아닌 이외의 경우에 대한 예외 처리")
    @ValueSource(strings = {"0", "A"})
    @ParameterizedTest
    void tryForwardInput_inputIsFault_exception() {

        assertThatThrownBy(() -> InputView.tryForwardInput()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 명령이 R, Q가 아닌 이외의 경우에 대한 예외 처리")
    @ValueSource(strings = {"0", "A"})
    @ParameterizedTest
    void tryRetryInput_inputIsFault_exception() {

        assertThatThrownBy(() -> InputView.tryRetryInput()
        ).isInstanceOf(IllegalArgumentException.class);
    }
}