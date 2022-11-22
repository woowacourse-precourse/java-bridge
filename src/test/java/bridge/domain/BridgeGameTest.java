package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BridgeGameTest {
    private Bridge bridge;
    private BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        this.bridge = new Bridge(List.of("U", "D", "U", "D"));
        this.bridgeGame = new BridgeGame(bridge);
    }

    @Test
    @DisplayName("이동한 자리가 일치했는지_일치")
    void move_true() {
        MatchResult result = bridgeGame.move("U");
        assertThat(result).isEqualTo(MatchResult.SUCCESS);
    }

    @Test
    @DisplayName("이동한 자리가 일치했는지_불일치")
    void move_false() {
        MatchResult result = bridgeGame.move("D");
        assertThat(result).isEqualTo(MatchResult.FAILURE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"U", "D", "U", "D"})
    @DisplayName("이동한 자리가 일치했는지_연속 확인")
    void move(String input) {
        assertDoesNotThrow(() -> bridgeGame.move(input));
    }

    @Test
    @DisplayName("최근 선택한 다리의 결과를 반환한다_이동 가능한 다리일 때")
    void matchRecentInput_Correct() {
        bridgeGame.move("U");
        BridgeState result = bridgeGame.matchRecentInput();
        assertThat(result).isEqualTo(BridgeState.CORRECT);
    }

    @Test
    @DisplayName("최근 선택한 다리의 결과를 반환한다_이동 불가능한 다리일 때")
    void matchRecentInput_Wrong() {
        bridgeGame.move("D");
        BridgeState result = bridgeGame.matchRecentInput();
        assertThat(result).isEqualTo(BridgeState.WRONG);
    }
}