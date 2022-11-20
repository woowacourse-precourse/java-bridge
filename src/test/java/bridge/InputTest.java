package bridge;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import bridge.view.InputView;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputTest  {
    InputView inputView = new InputView();

    @DisplayName("사용자의 입력을 성공적으로 받아들이는 테스트 케이스")
    @Test
    void inputValueSuccess() {
        command("테스트");
        assertThatCode(() -> inputView.readValue()).doesNotThrowAnyException();
    }

    @DisplayName("사용자가 입력을 하지 않고 다음 단계로 넘어갈 시 실패하는 테스트 케이스")
    @Test
    void inputValueFail() {
        assertThatThrownBy(() -> inputView.readValue()).isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("인자를 정수형으로 성공적으로 바꾸는 케이스")
    @Test
    void convertToIntegerSuccess() {
        try {
            Method method = inputView.getClass().getDeclaredMethod("convertToInteger", String.class);
            method.setAccessible(true);
            int actual = (int) method.invoke(inputView, "20");
            assertEquals(20, actual);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    @DisplayName("다리 길이를 성공적으로 입력받는 케이스 - 입력이 지정 범위 이내")
    @Test
    void readBridgeSizeSuccess() {
        command("15");
        assertThatCode(() -> inputView.readBridgeSize()).doesNotThrowAnyException();
    }

    @DisplayName("다리 길이를 입력받지 못하는 케이스 - 입력이 지정 범위 밖")
    @Test
    void readBridgeSizeFail() {
        command("21");
        assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
    }

    // 입력에 대한 테스트를 수행하기 위해 사전에 정의된 NsTest 클래스에서 command 메서드 가져옴
    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
