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

    @Nested
    @DisplayName("사용자가 이동할 칸 입력 시")
    class MovingInputTest {

        @Test
        @DisplayName("'D', 'U' 외의 문자가 있으면 에러가 발생한다.")
        void case1() {
            //given
            String movingInput = "D1";
            InputStream in = new ByteArrayInputStream(movingInput.getBytes());
            System.setIn(in);

            InputView inputView = new InputView();

            //when //then
            assertThatThrownBy(inputView::readMoving).isInstanceOf(IllegalArgumentException.class);

        }

        @Test
        @DisplayName("문자의 길이가 2자 이상이면 에러가 발생한다.")
        void case2() {
            //given
            String movingInput = "UU";
            InputStream in = new ByteArrayInputStream(movingInput.getBytes());
            System.setIn(in);

            InputView inputView = new InputView();

            //when //then
            assertThatThrownBy(inputView::readMoving).isInstanceOf(IllegalArgumentException.class);

        }

        @Test
        @DisplayName("'D', 'U' 중 한 문자만 입력해야 한다. ")
        void case3() {
            //given
            String movingInput = "D";
            InputStream in = new ByteArrayInputStream(movingInput.getBytes());
            System.setIn(in);

            InputView inputView = new InputView();

            //when
            String moving = inputView.readMoving();

            //then
            assertThat(moving).isEqualTo(movingInput);

        }
    }

    @Nested
    @DisplayName("게임 재시작 여부 입력 시")
    class GameCommandInputTest {

        @Test
        @DisplayName("'R', 'Q' 외의 문자가 있으면 에러가 발생한다.")
        void case1() {
            //given
            String gameCommandInput = "R1";
            InputStream in = new ByteArrayInputStream(gameCommandInput.getBytes());
            System.setIn(in);

            InputView inputView = new InputView();

            //when //then
            assertThatThrownBy(inputView::readGameCommand).isInstanceOf(IllegalArgumentException.class);

        }

        @Test
        @DisplayName("문자의 길이가 2자 이상이면 에러가 발생한다.")
        void case2() {
            //given
            String gameCommandInput = "QQ";
            InputStream in = new ByteArrayInputStream(gameCommandInput.getBytes());
            System.setIn(in);

            InputView inputView = new InputView();

            //when //then
            assertThatThrownBy(inputView::readGameCommand).isInstanceOf(IllegalArgumentException.class);

        }

        @Test
        @DisplayName("'R', 'Q' 중 한 문자만 입력해야 한다. ")
        void case3() {
            //given
            String gameCommandInput = "R";
            InputStream in = new ByteArrayInputStream(gameCommandInput.getBytes());
            System.setIn(in);

            InputView inputView = new InputView();

            //when
            String gameCommand = inputView.readGameCommand();

            //then
            assertThat(gameCommand).isEqualTo(gameCommandInput);

        }
    }
}
