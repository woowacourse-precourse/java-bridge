package bridge.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "-2", "30", "32a"})
    void bridgeSize(String input) {
        try {
            Method method = InputView.class.getDeclaredMethod("bridgeSize", String.class);
            method.setAccessible(true);
            assertThatThrownBy(() -> method.invoke(input))
                    .isInstanceOf(IllegalArgumentException.class);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "10", "20"})
    void inputBridgeSize(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int result = Integer.parseInt(input);
        assertThat(result).isEqualTo(new InputView().readBridgeSize());
    }
}