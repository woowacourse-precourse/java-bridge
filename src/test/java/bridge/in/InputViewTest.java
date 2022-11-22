package bridge.in;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    InputView inputView;

    @BeforeEach
    void init() {
        inputView = new InputView();
    }

    @ParameterizedTest
    @DisplayName("다리 사이즈 예외 테스트")
    @ValueSource(strings = {"22", "-1", "0", "A", "\n", " ", "\\"})
    void validateBridgeSizeInputTest(String inputBridgeSize) {
        assertThatThrownBy(() -> inputView.validateBridgeSizeInput(inputBridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }
}