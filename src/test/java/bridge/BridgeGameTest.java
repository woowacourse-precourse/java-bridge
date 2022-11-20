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
    private  final BridgeGame bridgeGame = new BridgeGame(inputView, outputView);
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

    @DisplayName("정상 작동 - 대문자")
    @Test
    public void moveBridge_Upper_success() {
        assertThatCode(() -> {
            bridgeGame.startGame(List.of("U", "U", "D"));

            setInput("U" + "\n" + "U" + "\n" + "D");
            bridgeGame.move(new StringBuilder(), new StringBuilder());

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
            bridgeGame.startGame(List.of("U", "U", "D"));

            setInput("u" + "\n" + "u" + "\n" + "d");
            bridgeGame.move(new StringBuilder(), new StringBuilder());

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
            bridgeGame.startGame(List.of("U", "U", "D"));

            setInput("D");
            bridgeGame.move(new StringBuilder(), new StringBuilder());

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
            bridgeGame.startGame(List.of("U", "U", "D"));

            setInput("U"+"\n"+"D");
            bridgeGame.move(new StringBuilder(), new StringBuilder());

            assertThat(outputStreamCaptor.toString())
                    .contains(
                            "[ O ]", "[   ]",
                            "[ O |   ]","[   | X ]"
                    );
        }).doesNotThrowAnyException();
    }

    @DisplayName("이동 방향이 U or D가 아닐 경우 예외 처리")
    @Test
    public void moveBridge_not_word() {
        assertThatCode(() -> {
            bridgeGame.startGame(List.of("U", "U", "D"));

            setInput("K");
            bridgeGame.move(new StringBuilder(), new StringBuilder());

        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.moveByNotUD.getMessage());
    }

    private void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

}