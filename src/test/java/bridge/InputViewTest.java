package bridge;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
    @DisplayName("다리 길이 입력 시 숫자가 아닌 경우 예외처리 한다.")
    @ValueSource(strings = {"hi", "a1f3", "123a", "7,7", "8.0"})
    @ParameterizedTest
    void bridgeSizeNotNumeric(String userInput) {
        InputStream in = mockUserInput(userInput);
        System.setIn(in);

        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력 시 숫자인 경우 정상적으로 변환한다.")
    @ValueSource(strings = {"1", "-500", "20", "40"})
    @ParameterizedTest
    void bridgeSizeNumeric(String userInput) {
        InputStream in = mockUserInput(userInput);
        System.setIn(in);

        InputView inputView = new InputView();
        assertThat(inputView.readBridgeSize()).isEqualTo(Integer.parseInt(userInput));
    }

    @DisplayName("게임 재시도 여부가 'R'나 'Q'가 아닐 경우 예외 처리한다.")
    @ValueSource(strings = {"3", "X", "q"})
    @ParameterizedTest
    void invalidRetryCommandCase(String userInput) {
        InputStream in = mockUserInput(userInput);
        System.setIn(in);

        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.readGameCommand())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재시도 여부가 'R'나 'Q'일 경우 정상 처리 한다.")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void validRetryCommandCase(String userInput) {
        InputStream in = mockUserInput(userInput);
        System.setIn(in);

        InputView inputView = new InputView();
        assertThat(inputView.readGameCommand())
                .isEqualTo(userInput);
    }

    private static InputStream mockUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}
