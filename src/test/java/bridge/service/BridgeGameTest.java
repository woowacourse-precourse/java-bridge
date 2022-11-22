package bridge.service;

import static bridge.Constants.DOWN;
import static bridge.Constants.UP;
import static bridge.domain.GameSituation.FAIL;
import static bridge.domain.GameSituation.ON_GOING;
import static bridge.domain.GameSituation.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.Bridge;
import bridge.domain.GameSituation;
import bridge.domain.Player;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        List<String> bridgeInput = Arrays.asList(UP, DOWN, UP);
        bridgeGame = new BridgeGame(bridgeInput);
    }

    @Test
    @DisplayName("플레이어를 이동시킨면 위치가 변한다.")
    void 플레이어_이동_테스트() {
        //given
        Player player = bridgeGame.getPlayer();
        int currentLocation = player.getCurrentLocation();
        //when
        bridgeGame.move(UP);
        int nextLocation = currentLocation + 1;
        //then
        assertThat(bridgeGame.getPlayer().getCurrentLocation()).isEqualTo(nextLocation);
    }

    @Test
    @DisplayName("게임 재시작시 플레이어는 초기화된다.")
    void 재시작_플레이어_초기화_테스트() {
        //given
        Player currentPlayer = bridgeGame.getPlayer();
        //when
        bridgeGame.retry();
        Player nextPlayer = bridgeGame.getPlayer();
        //then
        assertThat(currentPlayer).isNotEqualTo(nextPlayer);
    }

    @Test
    @DisplayName("게임 재시작시 다리는 그대로여야한다.")
    void 재시작_다리_유지_테스트() {
        //given
        Bridge currentBridge = bridgeGame.getBridge();
        //when
        bridgeGame.retry();
        Bridge nextBridge = bridgeGame.getBridge();
        //then
        assertThat(currentBridge).isEqualTo(nextBridge);
    }

    @Test
    @DisplayName("게임을 시작하면 상황은 '진행중'이다.")
    void 게임_상황_진행중_테스트() {
        GameSituation currentSituation = bridgeGame.checkSituation();
        assertThat(currentSituation).isEqualTo(ON_GOING);
    }

    @Test
    @DisplayName("게임을 종료하고 플레이어가 죽으면 상황은 '실패'이다.")
    void 게임_상황_실패_테스트() {
        //when
        bridgeGame.move(UP);
        bridgeGame.move(DOWN);
        bridgeGame.move(DOWN);
        //then
        GameSituation currentSituation = bridgeGame.checkSituation();
        assertThat(currentSituation).isEqualTo(FAIL);
    }

    @Test
    @DisplayName("게임을 종료하고 플레이어가 죽으면 상황은 '성공'이다.")
    void 게임_상황_성공_테스트() {
        //when
        bridgeGame.move(UP);
        bridgeGame.move(DOWN);
        bridgeGame.move(UP);
        //then
        GameSituation currentSituation = bridgeGame.checkSituation();
        assertThat(currentSituation).isEqualTo(SUCCESS);
    }
}
