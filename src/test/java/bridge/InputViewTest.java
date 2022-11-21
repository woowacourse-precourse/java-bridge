package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

public class InputViewTest {
    @DisplayName("사용자가 입력한 다리 길이에 대한 유효성 검사 테스트")
    @ValueSource(strings = {"a", "1", "21"})
    @ParameterizedTest
    void readBridgeSizeTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> new InputView().readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
