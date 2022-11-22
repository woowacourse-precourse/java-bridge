package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.List;

public class InputViewTest {
    @DisplayName("사용자가 입력한 다리 길이에 대한 유효성 검사 테스트")
    @ValueSource(strings = {"a", "1", "21"})
    @ParameterizedTest
    void readBridgeSizeInvalidTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> new InputView().readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 다리 길이에 대한 유효성 검사 테스트")
    @ValueSource(strings = {"3", "15", "20"})
    @ParameterizedTest
    void readBridgeSizeValidTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(new InputView().readBridgeSize()).isBetween(3, 20);
    }

    @DisplayName("사용자가 입력한 이동할 칸에 대한 유효성 검사 테스트")
    @ValueSource(strings = {"u", "d", "0"})
    @ParameterizedTest
    void readMovingInvalidTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(() -> new InputView().readMoving())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 이동할 칸에 대한 유효성 검사 테스트")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void readMovingValidTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(List.of("U", "D")).contains(new InputView().readMoving());
    }
}
