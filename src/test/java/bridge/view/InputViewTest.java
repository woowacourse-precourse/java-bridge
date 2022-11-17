package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    static InputView inputView;

    @BeforeAll
    static void initAll() {
        inputView = new InputView();
    }

    @DisplayName("bridge 크기로 3을 넣으면 readBridgeSize 메서드는 숫자 3을 리턴한다.")
    @Test
    void readBridgeSizeTest1() {
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(inputView.readBridgeSize()).isEqualTo(3);
    }

    @DisplayName("bridge 크기로 20을 넣으면 readBridgeSize 메서드는 숫자 20을 리턴한다.")
    @Test
    void readBridgeSizeTest2() {
        String input = "20";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(inputView.readBridgeSize()).isEqualTo(20);
    }

    @DisplayName("bridge 크기로 2를 (3 미만) 넣으면 IllegalArgumentException 가 발생한다.")
    @Test
    void readBridgeSizeErrorTest1() {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatIllegalArgumentException().isThrownBy(() -> inputView.readBridgeSize());
    }

    @DisplayName("bridge 크기로 21을 (20 초과) 넣으면 IllegalArgumentException 가 발생한다.")
    @Test
    void readBridgeSizeErrorTest2() {
        String input = "21";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatIllegalArgumentException().isThrownBy(() -> inputView.readBridgeSize());
    }

    @DisplayName("bridge 크기로 숫자 이외의 것을 넣으면 IllegalArgumentException 가 발생한다.")
    @Test
    void readBridgeSizeErrorTest3() {
        String input = "s";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatIllegalArgumentException().isThrownBy(() -> inputView.readBridgeSize());
    }

    @DisplayName("bridge 크기로 숫자 이외의 것을 넣으면 IllegalArgumentException 가 발생한다.")
    @Test
    void readBridgeSizeErrorTest4() {
        String input = " ";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatIllegalArgumentException().isThrownBy(() -> inputView.readBridgeSize());
    }
}