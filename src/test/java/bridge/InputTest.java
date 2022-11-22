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

    @DisplayName("이동할 칸을 성공적으로 입력받는 케이스 - 입력이 U 또는 D 이다.")
    @Test
    void readMovingSuccess() {
        command("U");
        assertThatCode(() -> inputView.readMoving()).doesNotThrowAnyException();
    }

    @DisplayName("이동한 칸을 잘못 입력한 케이스 - 입력이 U 또는 D가 아니다.")
    @Test
    void readMovingFail() {
        command("A");
        assertThatThrownBy(() -> inputView.readMoving()).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("명령을 성공적으로 입력받는 케이스 - 입력이 R 또는 Q 이다.")
    @Test
    void readGameCommandSuccess() {
        command("R");
        assertThatCode(() -> inputView.readGameCommand()).doesNotThrowAnyException();
    }

    @DisplayName("잘못된 명령을 입력받은 케이스 - 입력이 R 또는 Q가 아니다.")
    @Test
    void readGameCommandFail() {
        command("W");
        assertThatThrownBy(() -> inputView.readGameCommand()).isInstanceOf(IllegalArgumentException.class);
    }

    // 입력에 대한 테스트를 수행하기 위해 사전에 정의된 NsTest 클래스에서 command 메서드 가져옴
    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
