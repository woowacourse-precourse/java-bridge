package bridge.view;

import static org.assertj.core.api.Assertions.*;

import bridge.utils.ErrorMessage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private static final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private static final InputView inputView = new InputView();


    @BeforeEach
    void setUpOutputStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void resetOutputStream() {
        System.setOut(System.out);
        output.reset();
    }

    @Nested
    @DisplayName("다리 길이 입력 시")
    class BridgeSizeInputTest {

        @Test
        @DisplayName("숫자외의 다른 것을 입력하면 에러가 발생한다.")
        void case1() {
            //given
            String bridgeSizeInput = "3a\n3";
            InputStream in = new ByteArrayInputStream(bridgeSizeInput.getBytes());
            System.setIn(in);

            //when
            inputView.readBridgeSize();

            //then
            assertThat(output.toString().trim()).isEqualTo(ErrorMessage.BRIDGE_SIZE);
        }

        @Test
        @DisplayName("3~20을 벗어난 숫자를 입력하면 에러가 발생한다.")
        void case2() {
            //given
            String bridgeSizeInput = "23\n19";
            InputStream in = new ByteArrayInputStream(bridgeSizeInput.getBytes());
            System.setIn(in);

            //when
            inputView.readBridgeSize();

            //then
            assertThat(output.toString().trim()).isEqualTo(ErrorMessage.BRIDGE_SIZE);
        }

        @Test
        @DisplayName("3~20사이의 숫자를 입력해야 한다..")
        void case3() {
            //given
            String bridgeSizeInput = "7";
            InputStream in = new ByteArrayInputStream(bridgeSizeInput.getBytes());
            System.setIn(in);

            //when
            int bridgeSize = inputView.readBridgeSize();

            //then
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
            String movingInput = "D1\nD";
            InputStream in = new ByteArrayInputStream(movingInput.getBytes());
            System.setIn(in);

            //when
            inputView.readMoving();

            //then
            assertThat(output.toString().trim()).isEqualTo(ErrorMessage.MOVING);
        }

        @Test
        @DisplayName("문자의 길이가 2자 이상이면 에러가 발생한다.")
        void case2() {
            //given
            String movingInput = "UU\nU";
            InputStream in = new ByteArrayInputStream(movingInput.getBytes());
            System.setIn(in);

            //when
            inputView.readMoving();

            //then
            assertThat(output.toString().trim()).isEqualTo(ErrorMessage.MOVING);
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
            String gameCommandInput = "R1\nQ";
            InputStream in = new ByteArrayInputStream(gameCommandInput.getBytes());
            System.setIn(in);

            //when
            inputView.readGameCommand();

            //then
            assertThat(output.toString().trim()).isEqualTo(ErrorMessage.GAME_COMMAND);
        }

        @Test
        @DisplayName("문자의 길이가 2자 이상이면 에러가 발생한다.")
        void case2() {
            //given
            String gameCommandInput = "QQ\nQ";
            InputStream in = new ByteArrayInputStream(gameCommandInput.getBytes());
            System.setIn(in);

            //when
            inputView.readGameCommand();

            //then
            assertThat(output.toString().trim()).isEqualTo(ErrorMessage.GAME_COMMAND);
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
