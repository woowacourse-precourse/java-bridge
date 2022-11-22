package bridge.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("재시작과 종료에 관한 테스트")
    @ParameterizedTest
    @CsvSource({"R,true", "Q,false"})
    public void quitTest(String cmd, boolean expected) {
        assertThat(bridgeGame.retry(cmd)).isEqualTo(expected);
    }
}