package bridge.game;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(new BridgeRandomNumberGenerator()));
    Bridge bridge = new Bridge(List.of("U", "D", "U", "U"), 4);
    User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.startRound();
    }

    @Test
    void 움직임_테스트() {
        clearCase();
        Assertions.assertThat(user.getPosition()).isEqualTo(4);
        Assertions.assertThat(user.footPrints()).contains(
                "[ O |   | O | O ]\n[   | O |   |   ]"
        );
    }

    @Test
    void 성공_재시도_안해도_됨() {
        clearCase();
        Assertions.assertThat(bridgeGame.retry(bridge, user, () -> "R")).isFalse();
    }

    @Test
    void 실패_재시도() {
        failCase();
        Assertions.assertThat(bridgeGame.retry(bridge, user, () -> "R")).isTrue();

        user.startRound();

        failCase();
        Assertions.assertThat(bridgeGame.retry(bridge, user, () -> "Q")).isFalse();

        Assertions.assertThat(user.getGameCleared()).isFalse();
        Assertions.assertThat(user.getRound()).isEqualTo(2);
    }

    private void clearCase() {
        Iterator<String> iterator = List.of("U", "D", "U", "U").iterator();

        bridgeGame.move(bridge, () -> iterator.next(), (index, way) -> user.move(bridge.getMap(), index, way));
    }

    private void failCase() {
        Iterator<String> iterator = List.of("U", "D", "U", "D").iterator();

        bridgeGame.move(bridge, () -> iterator.next(), (index, way) -> user.move(bridge.getMap(), index, way));
    }
}