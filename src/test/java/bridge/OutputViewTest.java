package bridge;

import bridge.BridgeMaker.BridgeMaker;
import bridge.BridgeMaker.NumberGenerator.BridgeNumberGenerator;
import bridge.UI.Output.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.*;

public class OutputViewTest {
    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    protected final String output() {
        return captor.toString().trim();
    }
    @DisplayName("크기가 3인 다리를 위, 위, 아래 순서로 이동하는 경우를 출력한다.")
    @Test
    void printBridgeSize3ToSuccessful() {
        BridgeNumberGenerator generator = new TestNumberGenerator(newArrayList(0, 0, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        OutputView outputView = new OutputView(bridge);
        String[] move = {"U", "U", "D"};

        for(int i = 0; i < bridge.size(); i++)
            outputView.printMap(i, move[i]);

        assertThat(output()).contains(
                "[ O ]\n[   ]",
                "[ O | O ]\n[   |   ]",
                "[ O | O |   ]\n[   |   | O ]");
    }

    @DisplayName("크기가 3인 다리를 아래, 아래, 위 순서로 성공적으로 이동한 경우의 게임 결과를 출력한다.")
    @Test
    void printResultByBridgeSize3() {
        BridgeNumberGenerator generator = new TestNumberGenerator(newArrayList(1, 1, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        OutputView outputView = new OutputView(bridge);
        String[] move = {"D", "D", "U"};

        for(int i = 0; i < bridge.size(); i++)
            outputView.printMap(i, move[i]);

        outputView.printResult(true, 1);

        assertThat(output()).contains(
                "최종 게임 결과",
                "[   |   | O ]",
                "[ O | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
        );
    }
}
