package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    private final static InputView inputView = new InputView();

    @DisplayName("다리 크기 입력 테스트")
    @Nested
    class readBridgeSizeTest {

        @DisplayName("성공 케이스")
        @CsvSource(value = {"1:1", "23:23", "12321412:12321412", "012:12"}, delimiter = ':')
        @ParameterizedTest
        void successCase(String inputSize, int outputSize) {
            assertThat(inputView.readBridgeSize(inputSize)).isEqualTo(outputSize);
        }

        @DisplayName("예외 케이스: 실수가 입력되는 경우")
        @ValueSource(strings = {"1.1", "-1.23", "3.0"})
        @ParameterizedTest
        void failCaseRealNumber(String inputSize) {
            assertThatThrownBy(() -> inputView.readBridgeSize(inputSize))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("예외 케이스: 1보다 작은 수가 입력되는 경우")
        @ValueSource(strings = {"0", "-1", "-123"})
        @ParameterizedTest
        void failCaseLowerThanOne(String inputSize) {
            assertThatThrownBy(() -> inputView.readBridgeSize(inputSize))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("예외 케이스: 문자가 입력되는 경우")
        @ValueSource(strings = {"123d", "-='", "ewew", "0-12"})
        @ParameterizedTest
        void failCaseString(String input) {
            assertThatThrownBy(() -> inputView.readBridgeSize(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("이동 방향 입력 테스트")
    @Nested
    class readMovingTest {

        @DisplayName("성공 케이스")
        @CsvSource(value = {"U:U", "D:D"}, delimiter = ':')
        @ParameterizedTest
        void success(String inputDirection, String outputDirection) {
            assertThat(inputView.readMoving(inputDirection)).isEqualTo(outputDirection);
        }

        @DisplayName("예외 케이스: U 또는 D가 입력되지 않은 경우")
        @ValueSource(strings = {"21342", "O", "I", "["})
        @ParameterizedTest
        void failCaseNotUD(String inputDirection) {
            assertThatThrownBy(() -> inputView.readMoving(inputDirection))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("게임 재개 입력 테스트")
    @Nested
    class readGameCommand {

        @DisplayName("성공 케이스")
        @CsvSource(value = {"R:R", "Q:Q"}, delimiter = ':')
        @ParameterizedTest
        void successCase(String inputRetry, String outputRetry) {
            assertThat(inputView.readGameCommand(inputRetry))
                    .isEqualTo(outputRetry);
        }

        @DisplayName("예외 케이스: R 또는 Q가 입력되지 않은 경우")
        @ValueSource(strings = {"1", "E", "y", "-"})
        @ParameterizedTest
        void failCaseNotRQ(String inputRetry) {
            assertThatThrownBy(() -> inputView.readGameCommand(inputRetry))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
