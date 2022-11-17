package bridge.view;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream captor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Nested
    @DisplayName("게임 시작을 알리는 메시지를 출력하는 printGameStartMessage 메서드")
    class PrintGameStartMessageTest {
        @Test
        @DisplayName("게임 시작을 알리는 메시지를 출력할 수 있다.")
        void whenPrintingGameStartingMessage_thenPrintsGameStartingMessage() {
            //given
            OutputView outputView = new OutputView();

            //when
            outputView.printGameStartMessage();

            //then
            assertThat(captor.toString())
                    .isEqualTo(String.format(OutputView.GAME_STARTING_MESSAGE_FORMAT));
        }
    }

    @Nested
    @DisplayName("다리 길이 입력을 유도하는 메시지를 출력하는 printAskingBridgeSizeMessage 메서드")
    class PrintAskingBridgeSizeMessage {
        @Test
        @DisplayName("다리 길이의 입력을 유도하는 메시지를 출력할 수 있다.")
        void whenAskingBridgeSizeMessage_thenPrintsMessage() {
            //given
            OutputView outputView = new OutputView();

            //when
            outputView.printAskingBridgeSizeMessage();

            //then
            assertThat(captor.toString())
                    .isEqualTo(String.format(OutputView.ASKING_BRIDGE_SIZE_MESSAGE_FORMAT));
        }
    }
}