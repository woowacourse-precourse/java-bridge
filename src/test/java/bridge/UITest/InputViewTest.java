package bridge.UITest;

import bridge.UI.InputView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Mock
    // given
    InputView inputView = new InputView();

    @Nested
    @DisplayName("다리 길이 입력값 테스트")
    class BridgeLengthInputTest {

        @Test
        @DisplayName("다리의 길이가 올바른 형식으로 입력되었는지 확인한 후 받는다.")
        void wrightBridgeLengthInput() {
            // when
            String expected = "3";
            InputStream in = new ByteArrayInputStream(expected.getBytes());
            System.setIn(in);

            //then
            assertThat(inputView.readBridgeLength()).isEqualTo(Integer.parseInt(expected));
        }

        @DisplayName("다리의 길이가 올바르지 않은 형식이라면 예외를 던진다.")
        @ParameterizedTest
        @ValueSource(strings = {"2", "21", "", " ", "#", "q"})
        void wrongBridgeLengthInput(String testCase) {
            assertThatThrownBy(() -> inputView.validateBridgeLength(testCase))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }
    }

    @Nested
    @DisplayName("입력할 칸을 입력받을 때")
    class NextStepInputTest {

        @DisplayName("U나 D중 하나의 값을 받는다.")
        @ParameterizedTest
        @ValueSource(strings = {"U", "D"})
        void wrightNextStepInput(String nextStep) {
            InputStream in = new ByteArrayInputStream(nextStep.getBytes());
            System.setIn(in);
            assertThat(inputView.readMoving()).isEqualTo(nextStep);
        }

        @DisplayName("U나 D가 아닌 값을 받으면 예외 처리를 한다.")
        @ParameterizedTest
        @ValueSource(strings = {"q", "r", "", " ", "3"})
        void wrongNextStepInput(String wrongInput) {
            assertThatThrownBy(() -> inputView.validateNextStep(wrongInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ERROR_MESSAGE);
        }
    }
}
