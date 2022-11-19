package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class UserTest {

    User user = new User();
    Bridge bridge = new Bridge(List.of("D", "U", "D", "D"));

    @Test
    void 시도_횟수_테스트() {

        user.startRound();

        user.startRound();

        Assertions.assertThat(user.getRound()).isEqualTo(2);
    }

    @Test
    void 발자취_테스트() {
        user.move(bridge.getMap(), 0, "D");
        Assertions.assertThat(user.footPrints()).contains(
                "[   ]",
                "[ O ]");

        user.move(bridge.getMap(), 1, "U");
        Assertions.assertThat(user.footPrints()).contains(
                "[   | O ]",
                "[ O |   ]");

        user.move(bridge.getMap(), 2, "U");
        Assertions.assertThat(user.footPrints()).contains(
                "[   | O | X ]",
                "[ O |   |   ]");
    }
}