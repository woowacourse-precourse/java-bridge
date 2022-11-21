package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("게임 결과 반환 기능 검증")
class GameResultTest {
    private static BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        bridgeGame = new BridgeGame(new Bridge(List.of("U", "D", "U", "D")));
        bridgeGame.move(0, "U");
        bridgeGame.move(1, "U");
        bridgeGame.retry("R");
        bridgeGame.move(0, "U");
        bridgeGame.move(1, "D");
        bridgeGame.move(2, "U");
        bridgeGame.move(3, "D");
    }

    @DisplayName("위쪽 다리에 대한 결과를 올바르게 반환하는지")
    @Test
    void top결과_반환() {
        GameResult gameResult = new GameResult(bridgeGame);
        Assertions.assertThat(gameResult.getTopResult()).isEqualTo("O |   | O |  ");
    }

    @DisplayName("아래쪽 다리에 대한 결과를 올바르게 반환하는지")
    @Test
    void bottom결과_반환() {
        GameResult gameResult = new GameResult(bridgeGame);
        Assertions.assertThat(gameResult.getBottomResult()).isEqualTo("  | O |   | O");
    }

    @DisplayName("총 시도 횟수 검증 - 1번")
    @Test
    void 시도_횟수가_1번인_경우() {
        GameResult gameResult = new GameResult(bridgeGame);
        Assertions.assertThat(gameResult.totalPlayCount()).isEqualTo(1);
    }

    @DisplayName("총 시도 횟수 검증 - 2번")
    @Test
    void 시도_횟수가_2번인_경우() {
        GameResult gameResult = new GameResult(bridgeGame);
        bridgeGame.retry("R");
        Assertions.assertThat(gameResult.totalPlayCount()).isEqualTo(2);
    }

    @DisplayName("성공 여부를 정상적으로 반환하는지 - 성공")
    @Test
    void 성공인_경우() {
        GameResult gameResult = new GameResult(bridgeGame);
        Assertions.assertThat(gameResult.successOrFailure()).isEqualTo("성공");
    }

    @DisplayName("성공 여부를 정상적으로 반환하는지 - 실패")
    @Test
    void 실패인_경우() {
        BridgeGame bridgeGame2 = new BridgeGame(new Bridge(List.of("U", "U", "U", "U")));
        bridgeGame.move(0, "D");
        GameResult gameResult = new GameResult(bridgeGame2);
        Assertions.assertThat(gameResult.successOrFailure()).isEqualTo("실패");
    }

}