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

    @Test
    @DisplayName("재시작일 경우 다리 상태 초기화하는 메소드 테스트")
    void makeBridgeSectionsTest() {
        List<String[]> actual = bridgeGame.makeBridgeSections(List.of("U", "D"), List.of("O", "X"));
        String[] section1 = {" ", "O"};
        String[] section2 = {"X", " "};
        assertThat(actual).contains(section1, section2);
    }
}