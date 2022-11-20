package bridge.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    private static BridgeGame bridgeGame = new BridgeGame();
    private static List<String> bridge;

    @DisplayName("사용자의 이동 위치 저장 테스트 - 아래 칸")
    @Test
    void move_down_테스트() {
        bridgeGame.move(BridgeGame.BridgeShape.DOWN.getStringValue());
        assertThat(bridgeGame.getBridge_userMove()).contains("D");
    }

    @DisplayName("사용자의 이동 위치 저장 테스트 - 위 칸")
    @Test
    void move_up_테스트() {
        bridgeGame.move(BridgeGame.BridgeShape.UP.getStringValue());
        assertThat(bridgeGame.getBridge_userMove()).contains("U");
    }

}
