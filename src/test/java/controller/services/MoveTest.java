package controller.services;

import model.Bridge;
import model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class MoveTest {

    @Test
    @DisplayName("이동한 지점이 접근 가능한 지점이면 false를 반환")
    void moveToAccessiblePosition() {
        User user = new User();
        Bridge bridge = new Bridge(List.of("D", "U", "U"));

        BridgeGame bridgeGame = new BridgeGame(bridge, user);

        assertThat(bridgeGame.move("D")).isFalse();
        assertThat(bridgeGame.move("U")).isFalse();
        assertThat(bridgeGame.move("U")).isFalse();
    }

    @Test
    @DisplayName("이동한 지점이 접근 불가능한 지점이면 true를 반환")
    void moveToInaccessiblePosition() {
        User user = new User();
        Bridge bridge = new Bridge(List.of("D", "U", "U"));

        BridgeGame bridgeGame = new BridgeGame(bridge, user);

        assertThat(bridgeGame.move("U")).isTrue();
    }

}
