package bridge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

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

    @DisplayName("성공시 결과 확인_1번 시도")
    @Test
    public void startGame_result_success_try1() {
        assertThatCode(() -> {
            bridgeGame.setBridge(List.of("U", "U", "D"));

            setInput("U" + "\n" + "U" + "\n" + "D");
            List<String> result = bridgeGame.startGame();

            assertThat(result).contains("1",
                    "[ O | O |   ]" + "\n" + "[   |   | O ]",
                    "성공");
        }).doesNotThrowAnyException();
    }

    @DisplayName("성공시 결과 확인_2번 시도")
    @Test
    public void startGame_result_success_try2() {
        assertThatCode(() -> {
            bridgeGame.setBridge(List.of("U", "U", "D"));

            setInput("U" + "\n" + "U" + "\n" + "U"
                    + "\n" + "R"
                    + "\n" + "U" + "\n" + "U" + "\n" + "D");
            List<String> result = bridgeGame.startGame();

            assertThat(result).contains("2",
                    "[ O | O |   ]" + "\n" + "[   |   | O ]",
                    "성공");
        }).doesNotThrowAnyException();
    }

    @DisplayName("종료(실패) 결과 확인_1번 시도")
    @Test
    public void startGame_result_fail_try1() {
        assertThatCode(() -> {
            bridgeGame.setBridge(List.of("U", "U", "D"));

            setInput("U" + "\n" + "U" + "\n" + "U"
                    + "\n" + "Q");
            List<String> result = bridgeGame.startGame();

            assertThat(result).contains("1",
                    "[ O | O | X ]" + "\n" + "[   |   |   ]",
                    "실패");
        }).doesNotThrowAnyException();
    }

    @DisplayName("종료(실패) 결과 확인_2번 시도")
    @Test
    public void startGame_result_fail_try2() {
        assertThatCode(() -> {
            bridgeGame.setBridge(List.of("U", "U", "D"));

            setInput("U" + "\n" + "U" + "\n" + "U"
                    + "\n" + "R"
                    + "\n" + "D"
                    + "\n" + "Q");
            List<String> result = bridgeGame.startGame();

            assertThat(result).contains("2",
                    "[   ]" + "\n" + "[ X ]",
                    "실패");
        }).doesNotThrowAnyException();
    }

    @DisplayName("정상 작동 - 대문자")
    @Test
    public void moveBridge_Upper_success() {
        assertThatCode(() -> {
            bridgeGame.setBridge(List.of("U", "U", "D"));

            setInput("U" + "\n" + "U" + "\n" + "D");
            boolean move = bridgeGame.move(new StringBuilder(), new StringBuilder());

            assertThat(move).isTrue();

            assertThat(outputStreamCaptor.toString())
                    .contains(
                            "[ O ]", "[   ]", "[ O | O ]", "[   |   ]",
                            "[ O | O |   ]", "[   |   | O ]"
                    );
        }).doesNotThrowAnyException();
    }

    @DisplayName("정상 작동 - 소문자")
    @Test
    public void moveBridge_Lower_success() {
        assertThatCode(() -> {
            bridgeGame.setBridge(List.of("U", "U", "D"));

            setInput("u" + "\n" + "u" + "\n" + "d");
            boolean move = bridgeGame.move(new StringBuilder(), new StringBuilder());

            assertThat(move).isTrue();

            assertThat(outputStreamCaptor.toString())
                    .contains(
                            "[ O ]", "[   ]", "[ O | O ]", "[   |   ]",
                            "[ O | O |   ]", "[   |   | O ]"
                    );
        }).doesNotThrowAnyException();
    }

    @DisplayName("1번에서 실패")
    @Test
    public void moveBridge_take_1() {
        assertThatCode(() -> {
            bridgeGame.setBridge(List.of("U", "U", "D"));

            setInput("D");
            boolean move = bridgeGame.move(new StringBuilder(), new StringBuilder());

            assertThat(move).isFalse();

            assertThat(outputStreamCaptor.toString())
                    .contains(
                            "[   ]", "[ X ]"
                    );
        }).doesNotThrowAnyException();
    }

    @DisplayName("2번에서 실패")
    @Test
    public void moveBridge_take_2() {
        assertThatCode(() -> {
            bridgeGame.setBridge(List.of("U", "U", "D"));

            setInput("U" + "\n" + "D");
            bridgeGame.move(new StringBuilder(), new StringBuilder());

            assertThat(outputStreamCaptor.toString())
                    .contains(
                            "[ O ]", "[   ]",
                            "[ O |   ]", "[   | X ]"
                    );
        }).doesNotThrowAnyException();
    }

    @DisplayName("이동 방향이 U or D가 아닐 경우 예외 처리")
    @Test
    public void moveBridge_not_word() {
        assertThatCode(() -> {
            bridgeGame.setBridge(List.of("U", "U", "D"));

            setInput("K");
            bridgeGame.move(new StringBuilder(), new StringBuilder());

        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.moveByNotUD.getMessage());
    }

    @DisplayName("재시작 성공_대문자")
    @Test
    public void retry_upper_success_R() {
        assertThatCode(() -> {
            setInput("R");
            boolean retry = bridgeGame.retry();

            assertThat(retry).isTrue();

        }).doesNotThrowAnyException();
    }

    @DisplayName("재시작 성공_소문자")
    @Test
    public void retry_Lower_success_R() {
        assertThatCode(() -> {
            setInput("r");
            boolean retry = bridgeGame.retry();

            assertThat(retry).isTrue();

        }).doesNotThrowAnyException();
    }

    @DisplayName("종료 성공_대문자")
    @Test
    public void retry_upper_success_Q() {
        assertThatCode(() -> {
            setInput("Q");
            boolean retry = bridgeGame.retry();

            assertThat(retry).isFalse();

        }).doesNotThrowAnyException();
    }

    @DisplayName("종료 성공_대문자")
    @Test
    public void retry_lower_success_Q() {
        assertThatCode(() -> {
            setInput("q");
            bridgeGame.retry();

        }).doesNotThrowAnyException();
    }

    @DisplayName("명령이 R or Q가 아닐 경우 예외처리")
    @Test
    public void retry_not_word() {
        assertThatCode(() -> {
            setInput("x");
            bridgeGame.retry();

        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.commandByNotRQ.getMessage());
    }

    private void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

}