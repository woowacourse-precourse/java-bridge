package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgePlayer;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    private BridgePlayer player;
    private Bridge bridge;
    private BridgeGame game;

    @BeforeEach
    void initBridgeGame(){
        player = new BridgePlayer();
        bridge = new Bridge(new ArrayList<>(List.of("U", "D", "D")));
        game = new BridgeGame(bridge, player);
    }

    @DisplayName("정답 칸으로 이동했을 시 move 메서드는 true 반환 그리고, 플레이어의 마지막 위치 정보가 업데이트 된다.")
    @Test
    void casePlayerCorrectMove(){
        assertThat(game.move("U")).isTrue();
        assertThat(player.getCurrentBridgePosition()).isEqualTo(0);
    }

    @DisplayName("틀린 칸으로 이동했을 시 move 메서드는 false 반환 그리고, 플레이어의 마지막 위치 정보가 업데이트 된다.")
    @Test
    void casePlayerIncorrectMove(){
        assertThat(game.move("D")).isFalse();
        assertThat(player.getCurrentBridgePosition()).isEqualTo(0);
    }
}
