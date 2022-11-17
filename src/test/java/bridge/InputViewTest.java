package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputViewTest {
    private final String VALIDATE_SIZE = "validateInputSize";
    private static final String ERROR_MSG = "[ERROR]";
    private final InputView inputView = new InputView();

    private Method invokeMethod(String declaredMethod) throws NoSuchMethodException {
        Method method = inputView.getClass().getDeclaredMethod(declaredMethod, String.class);
        method.setAccessible(true);

        return method;
    }

    private boolean isErrOccur(Method method, String input) {
        try {
            method.invoke(inputView, input);
        } catch (InvocationTargetException e) {
            if(e.getTargetException().getMessage().contains(ERROR_MSG)) {
                return true;
            }
        } catch(IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @DisplayName("다리 길이 입력 테스트")
    @ValueSource(strings={"3", "9", "10", "19", "20"})
    @ParameterizedTest(name="{index} {displayName} test={0}")
    void correctBridgeSize(String test) throws Exception {
        Method method = invokeMethod(VALIDATE_SIZE);

        assertThat(method.invoke(inputView, test)).isEqualTo(Integer.parseInt(test));
    }

    @DisplayName("다리 길이 입력 예외 테스트")
    @ValueSource(strings = {"-1", "2", "21", "가", "ab", "@"})
    @ParameterizedTest(name = "{index} {displayName} test={0}")
    void createExceptionBridgeSize(String test) throws Exception {
        Method method = invokeMethod(VALIDATE_SIZE);

        boolean isErrOccur = isErrOccur(method, test);

        assertTrue(isErrOccur);
    }

}
