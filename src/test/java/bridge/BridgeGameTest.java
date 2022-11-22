package bridge;

import bridge.views.InputView;
import bridge.views.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest extends NsTest {

    InputView inputView;
    OutputView outputView;
    BridgeNumberGenerator numberGenerator;
    BridgeMaker bridgeMaker;
    BridgeGame bridgeGame;
    OutputStream outputStream;

    @BeforeEach
    void initialize() {
        inputView = new InputView();
        outputView = new OutputView();
        numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        bridgeGame = new BridgeGame(inputView, outputView, numberGenerator);
        bridgeMaker = new BridgeMaker(numberGenerator);
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    @DisplayName("clear at once")
    void clearAtOnce() {
        String[] inputs = { "3", "U", "D", "D" };
        setInputs(inputs);
        bridgeGame.start();
        assertThat(outputStream.toString()).contains("성공");
        assertThat(bridgeGame.getTryCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("fail and not retry")
    void failAndNotRetry() {
        String[] inputs = { "3", "U", "D", "U", "Q" };
        setInputs(inputs);
        bridgeGame.start();
        assertThat(outputStream.toString()).contains("실패");
        assertThat(bridgeGame.getTryCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("clear at the second chance")
    void clearAtRetry() {
        String[] inputs = { "3", "U", "D", "U", "R", "U", "D", "D" };
        setInputs(inputs);
        bridgeGame.start();
        assertThat(outputStream.toString()).contains("성공");
        assertThat(bridgeGame.getTryCount()).isEqualTo(2);
    }

    private void setInputs(String[] inputs) {
        final byte[] buffers = String.join("\n", inputs).getBytes();
        System.setIn(new ByteArrayInputStream(buffers));
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
