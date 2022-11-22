package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    private final BridgeGame bridgeGame = new BridgeGame();
    private Player player;

    @BeforeEach
    void beforeEach() {
        player = new Player();
        List<String> bridge = Arrays.asList("U", "D", "D");
        bridgeGame.initBridgeGame(player, bridge);
    }

    @DisplayName("올바른 방향으로 가면 'NEXT'가 리턴되는지 확인")
    @Test
    void move_올바른_방향_이동() {
        assertThat(bridgeGame.move("U")).isEqualTo("NEXT");
    }

    @DisplayName("잘못된 방향으로 가면 'FAIL'이 리턴되는지 확인")
    @Test
    void move_잘못된_방향_이동() {
        assertThat(bridgeGame.move("D")).isEqualTo("FAIL");
        assertThat(bridgeGame.move("D")).isEqualTo("FAIL");
    }

    @DisplayName("다리 끝까지 올바른 방향으로 가면 'SUCCESS'가 리턴되는지 확인")
    @Test
    void move_다리_끝까지_올바른_방향_이동() {
        assertAll(
                () -> assertEquals(bridgeGame.move("U"), "NEXT"),
                () -> assertEquals(bridgeGame.move("D"), "NEXT"),
                () -> assertEquals(bridgeGame.move("D"), "SUCCESS")
        );
    }

    @DisplayName("사용자의 BridgeMap이 정상적으로 반영되는지 확인")
    @Test
    void move_사용자의_BridgeMap_반영되는지_확인() {
        List<String> answer = Arrays.asList("O", "X");
        bridgeGame.move("U");
        bridgeGame.move("U");
        assertThat(player.getBridgeMap()).isEqualTo(answer);
    }

    @DisplayName("사용자의 BridgeRoute가 정상적으로 반영되는지 확인")
    @Test
    void move_사용자의_BridgeRoute_반영되는지_확인() {
        List<String> answer = Arrays.asList("U", "D");
        bridgeGame.move("U");
        bridgeGame.move("D");
        assertThat(player.getBridgeRoute()).isEqualTo(answer);
    }

    @DisplayName("사용자의 정답 횟수가 정상적으로 반영되는지 확인")
    @Test
    void move_사용자의_정답_횟수_반영되는지_확인() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        assertThat(player.getCorrectAnswerCount()).isEqualTo(3);
    }

    @DisplayName("R을 입력하면 true, Q를 입력하면 false가 반환되는지 확인")
    @Test
    void retry_재시작_검증() {
        assertAll(
                () -> assertTrue(bridgeGame.retry("R")),
                () -> assertFalse(bridgeGame.retry("Q"))
        );
    }

    @DisplayName("재시작하면 사용자의 시도 횟수가 증가하는지 확인")
    @ValueSource(strings = {"3", "4", "5", "6", "7", "8", "18", "19", "20"})
    @ParameterizedTest
    void retry_재시작_하면_사용자의_시도_횟수_증가(Integer input) {
        for (int i = 0; i < input; i++) {
            bridgeGame.retry("R");
        }
        assertThat(player.getTryCount()).isEqualTo(input + 1);
    }
}