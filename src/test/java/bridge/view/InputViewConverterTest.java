package bridge.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewConverterTest {

    @ParameterizedTest(name = "숫자가 아닌 문자가 입력되면 예외를 발생시킨다. 입력: {0}")
    @ValueSource(strings = {"a", "10j", "하잉"})
    void validateThisIsNumberTest(String inputValue) {
        InputViewConverter inputValueConverter = new InputViewConverter();

        assertThatThrownBy(() -> inputValueConverter.bridgeSize(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력해 주세요.");
    }

}