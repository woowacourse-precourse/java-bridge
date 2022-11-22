package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    Player player;

    @BeforeEach
    void init() {
        player = new Player();
    }

    @DisplayName("한칸 이동하면 현재 밟고있는 블록을 반환한다.")
    @Test
    public void moveUp() {
        assertThat(player.move(Direction.U)).isEqualTo(new BridgeBlock(Direction.U, 0));
    }

    @DisplayName("플레이어의 위치가 다리의 길이와 같다면 TRUE를 반환한다.")
    @Test
    public void crossComplete() {
        Bridge bridge = new Bridge(List.of("U", "U", "U"));
        player.move(Direction.U);
        player.move(Direction.U);
        player.move(Direction.U);
        assertThat(player.isCrossComplete(bridge)).isTrue();
    }
}
