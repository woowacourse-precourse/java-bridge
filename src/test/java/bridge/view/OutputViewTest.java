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

    @Nested
    @DisplayName("다음으로 이동할 칸을 입력하도록 유도하는 메시지를 출력하는 printAskingNextStepMessage 메서드")
    class PrintAskingNextStepMessage {
        @Test
        @DisplayName("다음으로 이동할 칸을 입력하도록 유도하는 메시지를 출력할 수 있다.")
        void whenAskingNextStep_thenPrintsMessage() {
            //given
            OutputView outputView = new OutputView();

            //when
            outputView.printAskingNextStepMessage();

            //then
            assertThat(captor.toString())
                    .isEqualTo(String.format("이동할 칸을 선택해주세요. (위: U, 아래: D)%n"));
        }
    }

    @Nested
    @DisplayName("현재까지 이동한 다리의 상태를 출력하는 printMap 매서드")
    class PrintMapTest {
        @Test
        @DisplayName("현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.")
        void givenMap_whenPrintingMap_thenPrintsMessage() {
            //given
            OutputView outputView = new OutputView();
            String map = "[ O |   |   ]" + System.lineSeparator() + "[   | X | O ]";

            //when
            outputView.printMap(map);

            //then
            assertThat(captor.toString())
                    .isEqualTo(map + System.lineSeparator());
        }
    }
}