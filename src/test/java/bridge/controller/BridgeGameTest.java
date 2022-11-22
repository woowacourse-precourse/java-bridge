package bridge.controller;

import bridge.Application;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.BridgeMaker;
import bridge.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class BridgeGameTest {
    static BridgeGame bridgeGame;

    @BeforeAll
    static void setBridgeGame() {
        BridgeService bridgeService = Application.getBridgeService();
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);
        bridgeGame = new BridgeGame(bridgeService, inputView, outputView);
    }

    @ParameterizedTest
    @ValueSource(ints = {3,4,5})
    void setBridgeTest(int bridgeSize) {
        bridgeGame.setBridge(bridgeSize);
        assertThat(bridgeGame.getBridge()).isInstanceOf(Bridge.class);
    }
}
