package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeMaker;
import bridge.model.Player;
import bridge.service.BridgeService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    static BridgeGame bridgeGame;

    @BeforeAll
    static void setBridgeGame() {
        bridgeGame = new BridgeGame(new BridgeService(new BridgeMaker(new BridgeRandomNumberGenerator())));
    }

    @ParameterizedTest
    @ValueSource(ints = {3,4,5})
    void setBridgeTest(int bridgeSize) {
        bridgeGame.setBridge(bridgeSize);
        assertThat(bridgeGame.getBridge()).isInstanceOf(Bridge.class);
    }
}
