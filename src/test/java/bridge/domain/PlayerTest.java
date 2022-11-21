package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static util.BridgeUtil.*;

class PlayerTest {

    @DisplayName("Player 클래스의, choice 개수를 가져온다.")
    @Test
    void getNumberOfChoice() {
        Player player = new Player();
        player.addChoice(UP);

        assertThat(player.getNumberOfChoice()).isEqualTo(1);
    }

}