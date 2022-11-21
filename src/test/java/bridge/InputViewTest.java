package bridge;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    private static final InputView INPUT_VIEW = new InputView();

    @DisplayName("tryParse 예외 사항 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1000j", "", " ", "1 3", "1a3", "1,2,3", " 1", "1 "})
    void tryParseInt_exception_test(String testInput) {
        assertThatThrownBy(() -> INPUT_VIEW.tryParseInt(testInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}