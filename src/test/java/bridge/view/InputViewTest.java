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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

        @ParameterizedTest
        @ValueSource(strings = {"3a\n3", "23\n19"})
        @DisplayName("숫자외의 다른 것, 3~20 외의 다른 숫자를 입력하면 에러가 발생한다.")
        void case1(String bridgeSizeInput) {
            //given
            InputStream in = new ByteArrayInputStream(bridgeSizeInput.getBytes());
            System.setIn(in);

            //when
            inputView.readBridgeSize();

            //then
            assertThat(output.toString().trim()).isEqualTo(ErrorMessage.BRIDGE_SIZE);
        }

        @ParameterizedTest
        @ValueSource(strings = {"3", "10", "17", "20"})
        @DisplayName("3~20사이의 숫자를 입력해야 한다.")
        void case3(String bridgeSizeInput) {
            //given
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

        @ParameterizedTest
        @ValueSource(strings = {"D1\nD", "UU\nU"})
        @DisplayName("'D', 'U' 한 문자 외의 다른 것을 입력하면 에러가 발생한다.")
        void case1(String movingInput) {
            //given
            InputStream in = new ByteArrayInputStream(movingInput.getBytes());
            System.setIn(in);

            //when
            inputView.readMoving();

            //then
            assertThat(output.toString().trim()).isEqualTo(ErrorMessage.MOVING);
        }

        @ParameterizedTest
        @ValueSource(strings = {"D", "U"})
        @DisplayName("'D', 'U' 중 한 문자만 입력해야 한다. ")
        void case3(String movingInput) {
            //given
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

        @ParameterizedTest
        @ValueSource(strings = {"R1\nQ", "QQ\nQ"})
        @DisplayName("'R', 'Q' 한 문자 외의 다른 것을 입력하면 에러가 발생한다.")
        void case1(String gameCommandInput) {
            //given
            InputStream in = new ByteArrayInputStream(gameCommandInput.getBytes());
            System.setIn(in);

            //when
            inputView.readGameCommand();

            //then
            assertThat(output.toString().trim()).isEqualTo(ErrorMessage.GAME_COMMAND);
        }

        @ParameterizedTest
        @ValueSource(strings = {"R", "Q"})
        @DisplayName("'R', 'Q' 중 한 문자만 입력해야 한다. ")
        void case3(String gameCommandInput) {
            //given
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
