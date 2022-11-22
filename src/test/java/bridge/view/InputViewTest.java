package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {
    InputView inputView = new InputView();

    @DisplayName("다리 길이 입력이 자연수가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "0", "05", "-1", "a", "1a", "a1", "1 2", " 5", "5 ", " 5 "})
    void ThrowExceptionIfNotNaturalNumber(String input) {
        assertThatThrownBy(() -> {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            inputView.readBridgeSize();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 자연수여야 합니다.");
    }

    @DisplayName("다리 길이 입력이 자연수이면 입력이 그대로 반환된다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "10", "99", "9999999999999999"})
    void PassTestIfNaturalNumber(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(inputView.readBridgeSize()).isEqualTo(input);
    }
}
