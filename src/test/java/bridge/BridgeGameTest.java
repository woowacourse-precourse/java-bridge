package bridge;

import bridge.views.InputView;
import bridge.views.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest extends NsTest {

    InputView inputView;
    OutputView outputView;
    BridgeNumberGenerator numberGenerator;
    BridgeMaker bridgeMaker;
    List<String> bridge;
    BridgeGame bridgeGame;

    @BeforeEach
    void initialize() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame(inputView, outputView);
        numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        bridgeMaker = new BridgeMaker(numberGenerator);
        bridge = bridgeMaker.makeBridge(3);
    }

    @Test
    @DisplayName("clear at once")
    void clearAtOnce() {
        String[] inputs = { "U", "D", "D" };
        setInputs(inputs);
        assertThat(bridgeGame.play(3, bridge, new ArrayList<>())).isTrue();
        assertThat(bridgeGame.getTryCount()).isEqualTo(1);
    }

//    @Test
//    @DisplayName("fail")
//    void fail() {
//        String[] inputs = { "U", "D", "U", "Q" };
//        setInputs(inputs);
//        assertThat(bridgeGame.play(3, bridge, new ArrayList<>())).isFalse();
//        OutputStream out = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(out));
//        assertThat(bridgeGame.getTryCount()).isEqualTo(1);
//        assertThat(out.toString()).contains("실패");
//    }

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
