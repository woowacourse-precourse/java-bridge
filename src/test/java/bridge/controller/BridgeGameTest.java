package bridge.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        bridgeGame = new BridgeGame();
    }

    /*@Test
    @DisplayName("정답 다리 초기화 확인")
    void testInitBridge() {
        bridgeGame.initBridge(new ArrayList<>(List.of("U","D","D")));
        Assertions.assertThat(bridgeGame.bridge.getBridge()).isEqualTo(new ArrayList<>(List.of("U","D","D")));
    }*/
}