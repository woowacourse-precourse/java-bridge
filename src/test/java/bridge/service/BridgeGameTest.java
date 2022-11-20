package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.User;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class BridgeGameTest {

    @DisplayName("게임을 진행하며 건널 수 있는 다리인 경우 true를 반환한다.")
    @Test
    void createSuccessMoveInBridgeGame() {
        // given
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        User user = new User();
        BridgeGame bridgeGame = new BridgeGame(bridge, user);
        boolean expectedFlag = true;

        // when
        List<String> movings = List.of("U", "D", "U");

        //then
        movings.forEach(moving -> assertThat(bridgeGame.move(moving)).isEqualTo(expectedFlag));
    }

    @DisplayName("게임을 진행하며 건널 수 있는 다리인 경우 false를 반환한다.")
    @Test
    void createFailMoveInBridgeGame() {
        // given
        Bridge bridge = new Bridge(List.of("U", "U", "U"));
        User user = new User();
        BridgeGame bridgeGame = new BridgeGame(bridge, user);
        boolean expectedFlag = false;

        // when
        List<String> movings = List.of("D", "D", "D");

        //then
        movings.forEach(moving -> assertThat(bridgeGame.move(moving)).isEqualTo(expectedFlag));
    }
}