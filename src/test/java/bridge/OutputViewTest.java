package bridge;

import bridge.UI.Output.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
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

    private List<StringBuilder> initializeBridge(){
        List<StringBuilder> bridgePair = new ArrayList();
        StringBuilder top = new StringBuilder().append('O').append('O').append(' ');
        StringBuilder bottom = new StringBuilder().append(' ').append(' ').append('O');
        bridgePair.add(top);
        bridgePair.add(bottom);

        return bridgePair;
    }
    protected final String output() {
        return captor.toString().trim();
    }
    @DisplayName("크기가 3인 다리를 위, 위, 아래 순서로 이동한 경우를 출력한다.")
    @Test
    void printBridgeSize3ToSuccessful() {
        OutputView outputView = new OutputView();
        List<StringBuilder> bridgePair = initializeBridge();
        outputView.printMap(bridgePair);

        assertThat(output()).contains(
                "[ O | O |   ]",
                "[   |   | O ]"
        );
    }

    @DisplayName("크기가 3인 다리를 위, 위, 아래 순서로 성공적으로 이동한 경우의 게임 결과를 출력한다.")
    @Test
    void printResultByBridgeSize3() {
        OutputView outputView = new OutputView();
        List<StringBuilder> bridgePair = initializeBridge();


        outputView.printMap(bridgePair);
        outputView.printResult(true, 1, bridgePair);

        assertThat(output()).contains(
                "최종 게임 결과",
                "[ O | O |   ]",
                "[   |   | O ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
        );
    }
}
