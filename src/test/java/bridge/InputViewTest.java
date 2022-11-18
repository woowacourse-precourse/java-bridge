package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("숫자가 아닐때 예외처리")
    @Test
    void numberValidate() {
        String input = "sdf";
        assertThatThrownBy(() -> inputView.numberValidate(input))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("3과 20사이의 숫자가 아닐때 예외처리")
    @ValueSource(ints = {-3, 0, 21})
    @ParameterizedTest
    void rangeValidate(int size) {
        assertThatThrownBy(() -> inputView.rangeValidate(size))
                .isInstanceOf(IllegalArgumentException.class);
    }


}