package bridge.controller;

import org.assertj.core.api.AssertionInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        bridgeGame = new BridgeGame();
    }

    @Test
    @DisplayName("정답 다리 초기화 확인")
    void testInitBridge() {
        bridgeGame.makeBridge(3);
        assertThat(bridgeGame.bridge.getBridge().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("이동 가능 확인")
    void testCanMove() {
        bridgeGame.makeBridge(3);
        assertThat(bridgeGame.move(bridgeGame.bridge.getBridge())).isEqualTo(true);
    }

    @Test
    @DisplayName("게임이 성공으로 끝난 경우")
    void checkGameEnd_Success() {
        assertThat(bridgeGame.checkGameFinish(bridgeGame.bridge.getBridge())).isEqualTo(true);
    }

    @Test
    @DisplayName("게임이 실패로 끝난 경우")
    void checkGameEnd_Fail() {
        List<String> user = new ArrayList<>(List.of("U","D"));
        bridgeGame.makeBridge(3);
        assertThat(bridgeGame.checkGameFinish(user)).isEqualTo(false);
    }

    @Test
    @DisplayName("게임 계속 진행 여부 확인")
    void checkRetry(){
        assertThat(bridgeGame.retry("R")).isEqualTo(true);
    }
}