package bridge.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Nested
    @DisplayName("다리 길이 입력 시")
    class BridgeSizeInputTest {

        @Test
        @DisplayName("숫자외의 다른 것을 입력하면 에러가 발생한다.")
        void case1() {
            //given
            String bridgeSizeInput = "3a";
            InputStream in = new ByteArrayInputStream(bridgeSizeInput.getBytes());
            System.setIn(in);

            InputView inputView = new InputView();

            //when //then
            assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("3~20을 벗어난 숫자를 입력하면 에러가 발생한다.")
        void case2() {
            //given
            String bridgeSizeInput = "23";
            InputStream in = new ByteArrayInputStream(bridgeSizeInput.getBytes());
            System.setIn(in);

            InputView inputView = new InputView();

            //when //then
            assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("3~20사이의 숫자를 입력해야 한다..")
        void case3() {
            //given
            String bridgeSizeInput = "7";
            InputStream in = new ByteArrayInputStream(bridgeSizeInput.getBytes());
            System.setIn(in);

            InputView inputView = new InputView();

            //when
            int bridgeSize = inputView.readBridgeSize();

            // then
            assertThat(bridgeSize).isEqualTo(Integer.parseInt(bridgeSizeInput));
        }
    }
}
