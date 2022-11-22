package bridge.bridgemaker;


import static org.assertj.core.api.Assertions.assertThat;

import bridge.command.enums.PlayerMove;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlayerMoveTest {
    @DisplayName("1을 입력하면 U를 반환한다.")
    @Test
    void inputUpperBridge() {
        Integer upperNumber = 1;
        String upper = "U";
        assertThat(PlayerMove.findMove(upperNumber)).isEqualTo(upper);
    }

    @DisplayName("0을 입력하면 U를 반환한다.")
    @Test
    void inputLowerBridge() {
        Integer lowerNumber = 0;
        String lower = "D";
        assertThat(PlayerMove.findMove(lowerNumber)).isEqualTo(lower);
    }
}
