package bridge.View;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {
    InputView inputView;

    @BeforeEach
    void init() {
        inputView = new InputView();
    }

    @DisplayName("정수로 표현할 수 있는 입력이 아닐경우 예외발생")
    @CsvSource(value = {"1000j", "ㄱo"})
    @ParameterizedTest
    void isDigitTest(String input) throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class,
                () -> inputView.isDigit(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"100", "201", "-1"})
    @DisplayName("입력범위를 초과할경우 예외발생")
    void isInputInRange(String input) throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class,
                () -> inputView.isSizeOutOfRange(inputView.isDigit(input)));
    }


}