package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.status.UserStatus;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    void 게임_승리_테스트() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(new BridgeRandomNumberGenerator()));
        UserStatus userStatus = new UserStatus(new ArrayList<>());
        List<String> answers = List.of("U", "U", "U");

        userStatus.addDirection("U");
        bridgeGame.move(answers, userStatus);

        assertThat(userStatus.isAvailable()).isTrue();

        userStatus.addDirection("U");
        bridgeGame.move(answers, userStatus);

        assertThat(userStatus.isAvailable()).isTrue();

        userStatus.addDirection("U");
        bridgeGame.move(answers, userStatus);

        assertThat(userStatus.isAvailable()).isTrue();
    }

    @Test
    void 게임_패배_테스트() {
        BridgeGame bridgeGame = new BridgeGame(new BridgeMaker(new BridgeRandomNumberGenerator()));
        UserStatus userStatus = new UserStatus(new ArrayList<>());

        userStatus.addDirection("U");
        bridgeGame.move(List.of("U", "U", "U"), userStatus);

        assertThat(userStatus.isAvailable()).isTrue();

        userStatus.addDirection("D");
        bridgeGame.move(List.of("U", "U", "U"), userStatus);

        assertThat(userStatus.isAvailable()).isFalse();
    }
}