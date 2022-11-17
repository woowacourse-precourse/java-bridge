package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FunctionTest {
    @Nested
    class BridgeLength {
        InputView inputView = new InputView();
        @ParameterizedTest
        @DisplayName("다리 길이가 숫자가 아니거나, 공백이거나, 지정된 범위를 넘으면 예외가 발생")
        @ValueSource(strings = {"ab","", "90"})
        void isLengthValid(String input) {
            assertThatThrownBy(() ->
                    inputView.readBridgeSize(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining("[ERROR] 다리 길이는 3~20 중 하나인 숫자입니다.");
        }
        @DisplayName("다리 길이가 3-20 사이의 숫자이면 통과")
        @Test
        void isLengthCorrectPrint() {
            String input = "10";
           Assertions.assertThat(inputView.readBridgeSize(input)).isEqualTo(10);
        }
    }
}
