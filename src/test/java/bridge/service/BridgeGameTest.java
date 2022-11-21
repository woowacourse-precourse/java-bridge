package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.CurrentRoute;
import bridge.domain.GameProgress;
import bridge.service.BridgeGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BridgeGameTest {

    private BridgeGame bridgeGame;
    private CurrentRoute currentRoute;
    private GameProgress gameProgress;

    @BeforeEach
    void setUp() {
        Bridge bridge = new Bridge(List.of("D", "D", "D"));
        currentRoute = new CurrentRoute();
        gameProgress = new GameProgress();
        bridgeGame = new BridgeGame(bridge, currentRoute, gameProgress);
    }

    @DisplayName("이동 작업이 정상적으로 진행되는지 확인")
    @Test
    void checkMoveWorksProperly() {
        move(List.of("D", "D"));

        assertThat(currentRoute.getCurrentLocation()).isEqualTo("D");
        assertThat(currentRoute.getCurrentLocationIndex()).isEqualTo(1);
    }

    @DisplayName("재시작할 때 현재 경로가 초기화되고, 게임 시도 횟수가 증가하는지 확인")
    @Test
    void checkRetrySuccess() {
        move(List.of("D", "U"));
        bridgeGame.retry();

        assertThat(currentRoute.getCurrentLocationIndex()).isEqualTo(-1);
        assertThat(gameProgress.getTrialCount()).isEqualTo(2);
    }

    @DisplayName("이동에 성공했을 때 이동 성공 확인 기능이 제대로 작동하는지 확인")
    @ParameterizedTest
    @CsvSource({
            "D, true",
            "U, false"
    })
    void checkCheckingMovementSuccessProgress(String movement, boolean expected) {
        bridgeGame.move(movement);

        assertEquals(bridgeGame.isMovementSuccess(), expected);
    }

    @DisplayName("다리의 마지막 칸이고 마지막 이동도 성공했을때 게임 성공 상태가 업데이트 되는지 확인")
    @Test
    void checkUpdateGameProgressBySuccess() {
        move(List.of("D", "D", "D"));
        bridgeGame.updateGameProgress();

        assertThat(bridgeGame.isGameSuccess()).isTrue();
    }

    @DisplayName("다리의 마지막 칸이 아닐 때 게임 성공 상태가 업데이트 되면 안됨")
    @Test
    void checkUpdateGameProgressByNotLastSquare() {
        move(List.of("D", "D"));
        bridgeGame.updateGameProgress();

        assertThat(bridgeGame.isGameSuccess()).isFalse();
    }

    @DisplayName("이동에 성공하지 못했을 때 게임 성공 상태가 업데이트 되면 안됨")
    @Test
    void checkUpdateGameProgressByMovementFail() {
        move(List.of("D", "D", "U"));
        bridgeGame.updateGameProgress();

        assertThat(bridgeGame.isGameSuccess()).isFalse();
    }

    @DisplayName("게임 시도 횟수 확인 작업이 정상적인지 확인")
    @Test
    void checkGettingTrialCount() {
        bridgeGame.retry();
        bridgeGame.retry();

        assertThat(bridgeGame.getTrialCount()).isEqualTo(3);
    }

    void move(List<String> moves) {
        for (String movement: moves) {
            bridgeGame.move(movement);
        }
    }
}
