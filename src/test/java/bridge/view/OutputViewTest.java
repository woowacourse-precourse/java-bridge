package bridge.view;

import bridge.system.util.BridgeMessageMaker;
import bridge.view.outputview.OutputView;
import bridge.vo.GameResult;
import bridge.vo.Step;
import bridge.vo.StepResult;
import bridge.vo.TryCount;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream captor = new ByteArrayOutputStream();
    private final OutputView outputView = new OutputView(new BridgeMessageMaker());

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
            //when
            outputView.printMap(List.of(
                    new StepResult(Step.D, true),
                    new StepResult(Step.U, true),
                    new StepResult(Step.U, false)
            ));

            //then
            assertThat(captor.toString())
                    .isEqualTo("[   | O | X ]" + System.lineSeparator() + "[ O |   |   ]" +
                            System.lineSeparator());
        }
    }

    @Nested
    @DisplayName("게임 재시도/종료 여부를 입력하도록 유도하는 메시지를 출력하는 printAskingGameCommandMessage 메서드")
    class PrintAskingGameCommandMessage {
        @Test
        @DisplayName("게임 재시도/종료 여부를 입력하도록 유도하는 메시지를 출력할 수 있다.")
        void whenAskingGameCommandMessage_thenPrintsMessage() {
            //when
            outputView.printAskingGameCommandMessage();

            //then
            assertThat(captor.toString())
                    .isEqualTo(String.format("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)%n"));
        }
    }

    @Nested
    @DisplayName("게임의 최종 결과를 출력하는 printResult 메서드")
    class PrintResultTest {
        @Test
        @DisplayName("최종 게임 결과를 안내하는 메시지와, 마지막으로 이동한 다리의 결과를 출력한다.")
        void givenGameResult_whenPrintingResult_thenPrintsMessage() {
            //given
            GameResult gameResult = getGameResult();

            //when
            outputView.printResult(gameResult, false);

            //then
            assertThat(captor.toString())
                    .contains("최종 게임 결과",
                            "[ O |   | X ]",
                            "[   | O |   ]");
        }

        @ParameterizedTest(name = "입력값 -> isFinished: {0}")
        @CsvSource(value = {"true:성공", "false:실패"}, delimiter = ':')
        @DisplayName("게임 성공 여부를 출력한다.")
        void givenGameResult_whenPrintingResult_thenPrintsGamePassingMessage(boolean isFinished, String description) {
            //given
            GameResult gameResult = getGameResult();

            //when
            outputView.printResult(gameResult, isFinished);

            //then
            assertThat(captor.toString())
                    .contains(String.format("게임 성공 여부: %s", description));
        }

        @Test
        @DisplayName("재도전을 포함하여 총 게임 시도 횟수를 출력한다.")
        void givenGameResult_whenPrintingResult_thenPrintsGamePassingMessage() {
            //given
            GameResult gameResult = getGameResult();

            //when
            outputView.printResult(gameResult, true);

            //then
            assertThat(captor.toString())
                    .contains("총 시도한 횟수: 2");
        }

        private GameResult getGameResult() {
            List<StepResult> stepResults = List.of(
                    new StepResult(Step.U, true),
                    new StepResult(Step.D, true),
                    new StepResult(Step.U, false)
            );
            TryCount tryCount = new TryCount();
            tryCount.addCount();
            tryCount.addCount();

            return new GameResult(stepResults, tryCount);
        }
    }

    @Nested
    @DisplayName("예외 발생시 [ERROR]로 시작하는 메시지를 출력하는 printErrorMessage 메서드")
    class PrintErrorMessageTest {
        @Test
        @DisplayName("예외에서 메시지를 뽑은 후 [ERROR] 로 시작하는 메시지 포맷에 담아 출력한다.")
        void givenException_whenPrintingErrorMessage_thenPrintMessage() {
            //given
            IllegalArgumentException exception = new IllegalArgumentException("테스트 예외입니다.");

            //when
            outputView.printErrorMessage(exception);

            //then
            assertThat(captor.toString())
                    .isEqualTo("[ERROR] 테스트 예외입니다." + System.lineSeparator());
        }
    }
}