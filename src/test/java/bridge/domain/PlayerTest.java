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

    @DisplayName("지정한 인덱스의 choice 를 가져온다.")
    @Test
    void getChoiceByPosition() {
        Player player = new Player();
        player.addChoice(UP);
        player.addChoice(DOWN);
        player.addChoice(UP);

        assertThat(player.getChoiceIndex(1)).isEqualTo(DOWN);
    }

}