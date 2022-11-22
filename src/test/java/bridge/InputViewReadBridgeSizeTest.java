package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewReadBridgeSizeTest {

    InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("입력 받은 다리 길이가 숫자가 아닌 경우 에러 발생")
    @ValueSource(strings = {"abc", "test", "한글"})
    @ParameterizedTest
    void readBridgeSizeValidErrorTest(String input) {
        assertThatThrownBy(() -> inputView.sizeValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다");
    }

    @DisplayName("입력 받은 다리 길이가 숫자가 3보다 작은 경우")
    @ValueSource(strings = {"-2", "0", "2.0"})
    @ParameterizedTest
    void readBridgeSizeValidErrorTest2(String input) {
        assertThatThrownBy(() -> inputView.sizeValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다");
    }

    @DisplayName("입력 받은 다리 길이가 숫자가 20보다 큰 경우")
    @ValueSource(strings = {"20.5", "1000", "20.1"})
    @ParameterizedTest
    void readBridgeSizeValidErrorTest3(String input) {
        assertThatThrownBy(() -> inputView.sizeValidation(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다");
    }

    @DisplayName("입력 받은 다리 길이가 3~20 사이인 경우")
    @ValueSource(strings = {"3", "10", "20"})
    @ParameterizedTest
    void movingValidErrorTestU(String input) {
        inputView.sizeValidation(input);

        assertThatNoException();
    }
}