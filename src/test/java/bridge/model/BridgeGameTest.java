package bridge.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {
    BridgeGame bridgeGame;
    BridgeMaker bridgeMaker;

    @BeforeEach
    void beforEach() {
        bridgeGame = new BridgeGame();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    @DisplayName("길을 못 건너는 경우 테스트")
    void isDiscordTest() {
        List<String> mark = List.of("O", "X");
        String result = "X";
        assertThat(bridgeGame.isX(mark, result)).isTrue();
    }

}