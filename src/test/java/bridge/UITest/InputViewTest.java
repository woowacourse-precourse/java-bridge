package bridge.UITest;

import bridge.UI.InputView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("다리의 길이가 올바른 형식으로 입력되었는지 확인한 후 받는다.")
    @Test
    void readBridgeLengthTest() {
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
    void readBridgeLengthExceptionHandlingTest(String testCase) {
        assertThatThrownBy(() -> inputView.validateBridgeLength(testCase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}
