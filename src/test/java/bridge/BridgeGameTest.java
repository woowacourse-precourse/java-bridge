package bridge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class BridgeGameTest {

    private final InputView inputView = new InputView(new Validator());
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame(inputView, outputView);
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(
                        List.of(castCommand(List.of("U", "U", "D")),
                                "1", "[ O | O |   ]" + "\n" + "[   |   | O ]", "성공"),
                        List.of(castCommand(List.of("U", "U", "U", "R", "U", "U", "D")),
                                "2", "[ O | O |   ]" + "\n" + "[   |   | O ]", "성공"),
                        List.of(castCommand(List.of("U", "U", "U", "Q")),
                                "1", "[ O | O | X ]" + "\n" + "[   |   |   ]", "실패"),
                        List.of(castCommand(List.of("U", "U", "U", "R", "D", "Q")),
                                "2", "[   ]" + "\n" + "[ X ]", "실패"))
        );
    }

    static Stream<Arguments> generateMoves() {
        return Stream.of(
                Arguments.of(
                        List.of("U", "U", "D"),
                        List.of("u", "u", "d")
                )
        );
    }

    @DisplayName("startGame_output 확인")
    @ParameterizedTest
    @MethodSource("generateData")
    public void startGame_Result(List<String> expect) {
        System.out.println(expect);
        assertThatCode(() -> {
            bridgeGame.setBridge(List.of("U", "U", "D"));

            setInput(expect.get(0));
            List<String> result = bridgeGame.startGame();

            assertThat(result).contains(expect.get(1),
                    expect.get(2), expect.get(3));
        }).doesNotThrowAnyException();
    }

    @DisplayName("move() 정상 작동")
    @ParameterizedTest
    @MethodSource("generateMoves")
    public void moveBridge_Success(List<String> inputMoves) {
        assertThatCode(() -> {
            bridgeGame.setBridge(List.of("U", "U", "D"));

            setInput(castCommand(inputMoves));
            boolean move = bridgeGame.move(new StringBuilder(), new StringBuilder());

            assertThat(move).isTrue();

            assertThat(outputStreamCaptor.toString())
                    .contains(
                            "[ O ]", "[   ]", "[ O | O ]", "[   |   ]",
                            "[ O | O |   ]", "[   |   | O ]"
                    );
        }).doesNotThrowAnyException();
    }

    @DisplayName("다리 이동 실패")
    @ParameterizedTest
    @CsvSource(value = {
            "D,'[   ]" + "\n" + "[ X ]'",
            "'U" + "\n" + "D','[ O |   ]" + "\n" + "[   | X ]'"
    })
    public void moveBridge_Take_Fail(String input, String expect) {
        assertThatCode(() -> {
            bridgeGame.setBridge(List.of("U", "U", "D"));

            setInput(input);
            boolean move = bridgeGame.move(new StringBuilder(), new StringBuilder());

            assertThat(move).isFalse();

            assertThat(outputStreamCaptor.toString()).contains(expect);
        }).doesNotThrowAnyException();
    }

    @DisplayName("이동 방향이 U or D가 아닐 경우 예외 처리")
    @ParameterizedTest
    @CsvSource(value = {"R", "r", "1", "C", "uu", "ud", "UU"})
    public void moveBridge_Not_Word(String inputMove) {
        assertThatCode(() -> {
            bridgeGame.setBridge(List.of("U", "U", "D"));

            setInput(inputMove);
            bridgeGame.move(new StringBuilder(), new StringBuilder());

        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.moveByNotUD.getMessage());
    }

    @DisplayName("재시작 성공")
    @ParameterizedTest
    @CsvSource(value = {"R", "r"})
    public void retry_R_Success(String inputCommand) {
        assertThatCode(() -> {
            setInput(inputCommand);
            boolean retry = bridgeGame.retry();

            assertThat(retry).isTrue();

        }).doesNotThrowAnyException();
    }

    @DisplayName("종료 성공")
    @ParameterizedTest
    @CsvSource(value = {"Q", "q"})
    public void retry_Q_Success(String inputCommand) {
        assertThatCode(() -> {
            setInput(inputCommand);
            boolean retry = bridgeGame.retry();

            assertThat(retry).isFalse();

        }).doesNotThrowAnyException();
    }

    @DisplayName("명령이 R or Q가 아닐 경우 예외처리")
    @ParameterizedTest
    @CsvSource(value = {"a", "10", "e", "W", "rr", "Rr", "qQ", "QQ"})
    public void retry_Not_Word(String inputCommand) {
        assertThatCode(() -> {
            setInput(inputCommand);
            bridgeGame.retry();

        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.commandByNotRQ.getMessage());
    }

    private static String castCommand(List<String> commands) {
        StringBuilder inputCommand = new StringBuilder();

        for (String command : commands) {
            if (inputCommand.length() != 0) inputCommand.append("\n");
            inputCommand.append(command);
        }

        return inputCommand.toString();
    }

    private void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

}