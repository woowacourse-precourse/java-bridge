package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @DisplayName("3 이상 20 이하의 String 타입의 숫자라면 int 타입으로 바꿔준다")
    @Test
    void test() {
        InputView inputView = new InputView();
        InputStream in = new ByteArrayInputStream("20".getBytes());
        System.setIn(in);

        assertThat(inputView.readBridgeSize()).isEqualTo(20);
    }
}