package bridge;

import bridge.domain.BridgeGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeTest {

    @Test
    @DisplayName("다리 건널 때마다 'O' 또는 'X' 결과 확인")
    void 다리_건너기_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(List.of("U", "D", "D"), "U");
        bridgeGame.move(List.of("U", "D", "D"), "D");
        List<String> moveResult = bridgeGame.move(List.of("U", "D", "D"), "U");

        assertThat(moveResult).isEqualTo(List.of("O", " ", " ", "O", "X", " "));
    }

    @Test
    @DisplayName("게임 재시도 할시 이동 결과 초기화")
    void 다리_게임_재시도_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(List.of("U", "D", "D"), "U");
        bridgeGame.move(List.of("U", "D", "D"), "D");
        List<String> moveResult = bridgeGame.retry("R");

        assertThat(moveResult).isEqualTo(List.of());
    }
}
