package bridge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest {

    private BridgeGame bridgeGame;

    private PrintStream standardOut;
    private OutputStream captor;

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    private String output() {
        return captor.toString().trim();
    }

    @BeforeEach
    void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        bridgeGame = new BridgeGame(new InputView(), new OutputView());
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        bridgeGame.setAnswers(numberGenerator, 3);
    }

    @AfterEach
    private final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    @Test
    void play_테스트1() {
        bridgeGame.reset();
        command("U", "D", "D");
        bridgeGame.play();

        assertThat((output())).contains(
                "[ O ]",
                "[   ]",
                "[ O |   ]",
                "[   | O ]",
                "[ O |   |   ]",
                "[   | O | O ]"
        );
    }

    @Test
    void play_테스트2() {
        bridgeGame.reset();
        command("U", "U");
        bridgeGame.play();

        assertThat((output())).contains(
                "[ O ]",
                "[   ]",
                "[ O |   ]",
                "[   | X ]"
        );
    }

    @Test
    void retry_테스트1() {
        bridgeGame.reset();
        command("U", "U", "Q");
        bridgeGame.play();
        boolean result = bridgeGame.retry();

        assertThat(false).isEqualTo(result);

        assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   ]\n[   | X ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 1"
        );
    }

    @Test
    void retry_테스트2() {
        bridgeGame.reset();
        command("U", "D", "D");
        bridgeGame.play();
        boolean result = bridgeGame.retry();

        assertThat(false).isEqualTo(result);

        assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   |   ]\n[   | O | O ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
        );
    }
}
