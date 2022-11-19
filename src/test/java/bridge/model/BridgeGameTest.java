package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame();
    }

    @DisplayName("현재 상태가 잘 추가 되었나 확인")
    @Test
    void 현재_건넌_상태_추가() {
        List<String> preStatus = new ArrayList<>();
        bridgeGame.move("U");
        assertThat(preStatus).isEqualTo(Arrays.asList("U"));
    }

}