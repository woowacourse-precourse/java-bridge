package bridge.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    private static List<String> bridge;
    private static BridgeGame bridgeGame = new BridgeGame();


    @DisplayName("사용자의 이동 위치 저장 테스트")
    @ValueSource(strings = {"D", "U"})
    @ParameterizedTest
    void move_테스트(String userMoveDirection) {
        bridgeGame.move(userMoveDirection);
        assertThat(bridgeGame.getBridge_userMove()).contains(userMoveDirection);
    }

}
