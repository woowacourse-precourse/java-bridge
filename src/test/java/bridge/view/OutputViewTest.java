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
        bridgeGameResult.addResult("U", "O");
        bridgeGameResult.addResult("D", "O");
        bridgeGameResult.addResult("U", "O");
    }

    @Test
    void 이동_결과_출력_테스트() {
//        String input = outputView.printMap(bridgeGameResult);

//        assertThat(input).isEqualTo("[ O |   | X ]");
//        assertThat(input).isEqualTo("[   | O ]");
    }

    @Test
    void 최종_결과_출력_테스트() {


    }
}