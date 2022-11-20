package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ViewTest {
    private static final InputView inputView = new InputView();

    @DisplayName("사용자가 입력한 다리 크기가 3이상 20이하가 아니면 예외를 발생시킨다.")
    @Test
    void 다리_크기_입력_테스트() {
        InputStream in = new ByteArrayInputStream("21".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isExactlyInstanceOf(IllegalArgumentException.class);

        in = new ByteArrayInputStream("a1c2".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 움직임이 U 또는 D가 아니면 예외를 발생시킨다.")
    @Test
    void 움직임_입력_테스트() {
        InputStream in = new ByteArrayInputStream("A".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isExactlyInstanceOf(IllegalArgumentException.class);

        in = new ByteArrayInputStream("123".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 입력한 재시작/종료 옵션이 R 또는 Q가 아니면 예외를 발생시킨다")
    @Test
    void 옵션_입력_테스트() {
        InputStream in = new ByteArrayInputStream("U".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isExactlyInstanceOf(IllegalArgumentException.class);

        in = new ByteArrayInputStream("123".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
