package bridge.view;

import bridge.BridgeMaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @ParameterizedTest
    @CsvSource(value = {"5,5", "7,7"})
    void readBridgeSizeSuccessTest(String input, int expected) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThat(inputView.readBridgeSize(BridgeMaker.BRIDGE_MIN_SIZE, BridgeMaker.BRIDGE_MAX_SIZE))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "22", "A"})
    void readBridgeSizeFailureTest(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> inputView.readBridgeSize(BridgeMaker.BRIDGE_MIN_SIZE, BridgeMaker.BRIDGE_MAX_SIZE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"U,U", "D,D"})
    void readMovingSuccessTest(String input, String expected) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThat(inputView.readMoving())
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"u", "d", "A"})
    void readMovingSuccessTest(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"R,R", "Q,Q"})
    void readGameCommandSuccessTest(String input, String expected) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThat(inputView.readGameCommand())
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "A"})
    void readGameCommandSuccessTest(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        assertThatThrownBy(() -> inputView.readGameCommand())
                .isInstanceOf(IllegalArgumentException.class);
    }
}