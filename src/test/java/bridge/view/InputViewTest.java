package bridge.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    private void input(String string) {
        InputStream in = new ByteArrayInputStream(string.getBytes());
        System.setIn(in);
    }

    @DisplayName("String의 타입의 input을 int 타입으로 반환")
    @Test
    void readBridgeSize() {
        input("10");
        assertThat(inputView.readBridgeSize()).isEqualTo(10);
    }

    @DisplayName("범위 밖의 값이 입력 되었을 때 예외 발생")
    @Test
    void readBridgeSizeByOutOfRange() {
        input("1");
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 숫자가 입력 되었을 때 예외 발생")
    @Test
    void readBridgeSizeByNaN() {
        input("05");
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("U나 D가 아닌 문자가 입력 되었을 때 예외 발생")
    @Test
    void readMovingByNotUNorD() {
        input("A");
        assertThatThrownBy(() -> inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("R이나 Q가 아닌 문자가 입력 되었을 때 예외 발생")
    @Test
    void readGameCommandByNotRNorQ() {
        input("ㅋ");
        assertThatThrownBy(() -> inputView.readGameCommand())
                .isInstanceOf(IllegalArgumentException.class);
    }
}