package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    @DisplayName("입력 받은 다리 길이에 대한 유효성 검사 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "12ab", "ab12", "ab", "-ab", "-1ab", "0", "-12", "25", "1"})
    void createBridgeLengthWrongInput(String input) {
        assertThatThrownBy(() -> InputView.validateBridgeLength(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}