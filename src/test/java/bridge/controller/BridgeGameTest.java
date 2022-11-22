package bridge.controller;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    @Test
    void 게임초기화(){
        BridgeGame bridgeGame = new BridgeGame();

        bridgeGame.initGame("4");

        assertThat(4).isEqualTo(bridgeGame.getBridge().getResultBridge().size());
    }

}