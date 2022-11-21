package bridge.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
    private static InputView inputView;

    @BeforeAll
    static void before_test() {
        inputView = new InputView();
    }

    @Test
    void null_input_test() {
        InputStream in = new ByteArrayInputStream("".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-12", "sj", "34gg"})
    void bridge_size_invalid_test(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1232", "1", "0"})
    void bridge_size_valid_test(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatCode(() -> inputView.readBridgeSize())
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-12", "d", "T", "UD"})
    void moving_invalid_test(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void moving_valid_test(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatCode(() -> inputView.readMoving())
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-12", "r", "Q1", "RQ"})
    void game_command_invalid_test(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputView.readGameCommand())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void game_command_valid_test(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatCode(() -> inputView.readGameCommand())
                .doesNotThrowAnyException();
    }

}
