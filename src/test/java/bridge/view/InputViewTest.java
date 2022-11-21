package bridge.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "-2", "30", "32a"})
    void bridgeSizeException(String input) {
        try {
            Method method = InputView.class.getDeclaredMethod("bridgeSize", String.class);
            method.setAccessible(true);
            method.invoke(new InputView(), input);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            assertThat(e.getCause() instanceof IllegalArgumentException).isTrue();
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "10", "20"})
    void bridgeSize(String input) {
        try {
            Method method = InputView.class.getDeclaredMethod("bridgeSize", String.class);
            method.setAccessible(true);
            int result = (int) method.invoke(new InputView(), input);
            assertThat(result).isEqualTo(Integer.parseInt(input));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}