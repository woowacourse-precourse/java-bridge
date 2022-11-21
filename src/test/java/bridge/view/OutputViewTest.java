package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import bridge.BridgeGameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private OutputView outputView;
    private BridgeGameResult bridgeGameResult;

    @BeforeEach
    void setOutputView() {
        outputView = new OutputView();
        bridgeGameResult = new BridgeGameResult();
    }

    @Test
    void printMap() {
        bridgeGameResult.addResult("U", "O");
        bridgeGameResult.addResult("D", "O");
        bridgeGameResult.addResult("U", "O");
//        String input = outputView.printMap(bridgeGameResult);

//        assertThat(input).isEqualTo("[ O |   | O ]");
//        assertThat(input).isEqualTo("[   | O |   ]");
    }
}