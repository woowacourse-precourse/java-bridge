package bridge;

import enumCollections.GameStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeGameTest {
    @DisplayName("다음 칸이 이동 가능한 칸인지 확인하는 테스트")
    @Test
    void 아래칸_이동_테스트() {
        BridgeGame bridgeGame = new BridgeGame(List.of("D", "D", "U"));
        assertThat(bridgeGame.tryMoveTo("D"))
                .isEqualTo(GameStatus.CONTINUE);
    }

    @DisplayName("다음 칸이 이동 가능한 칸인지 확인하는 테스트")
    @Test
    void 위칸_이동_테스트() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D"));
        assertThat(bridgeGame.tryMoveTo("U"))
                .isEqualTo(GameStatus.CONTINUE);
    }

    @DisplayName("다음칸 이동 불가능으로 게임 실패 케이스 테스트")
    @Test
    void 위칸_이동_실패_테스트() {
        BridgeGame bridgeGame = new BridgeGame(List.of("D"));
        assertThat(bridgeGame.tryMoveTo("U"))
                .isEqualTo(GameStatus.FAILURE);
    }

    @DisplayName("다음칸 이동 불가능으로 게임 실패 케이스 테스트")
    @Test
    void 아래칸_이동_실패_테스트() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U"));
        assertThat(bridgeGame.tryMoveTo("D"))
                .isEqualTo(GameStatus.FAILURE);
    }

    @DisplayName("다음 칸이 이동 가능한 칸인지 확인하는 테스트")
    @Test
    void 게임_성공_테스트() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U"));
        assertThat(bridgeGame.tryMoveTo("U"))
                .isEqualTo(GameStatus.SUCCESS);
    }
}
