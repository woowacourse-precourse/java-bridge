package bridge.view;

import bridge.domain.CurrentBridgeState;
import bridge.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

class OutputViewTest {

    OutputView outputView;
    CurrentBridgeState currentBridgeState;

    @BeforeEach
    void beforeEach() {
        outputView = new OutputView();
        currentBridgeState = new CurrentBridgeState();
    }

    @Test
    @DisplayName("다리를 이동한 결과값 출력 테스트")
    void printMap() {

        String expected = "[ O | O |   | X ]\n[   |   | O |   ]\n\n";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        currentBridgeState.recordBridgeMove("U", true);
        currentBridgeState.recordBridgeMove("U", true);
        currentBridgeState.recordBridgeMove("D", true);
        currentBridgeState.recordBridgeMove("U", false);
        outputView.printMap(currentBridgeState);

        assertThat(out.toString().contains(expected)).isTrue();
    }
}