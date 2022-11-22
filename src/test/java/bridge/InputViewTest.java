package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputViewTest {
    InputView inputView = new InputView();

    @DisplayName("다리 길이 입력이 자연수가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "a", "1a", "a1", "1 2", " 5", "5 ", " 5 "})
    void ThrowExceptionIfNotNaturalNumber(String input) {
        assertThatThrownBy(() -> {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            inputView.readBridgeSize();
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 자연수여야 합니다.");
    }
}
