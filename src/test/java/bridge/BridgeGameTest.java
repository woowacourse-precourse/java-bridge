package bridge;

import static bridge.BridgeMaker.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    @DisplayName("[move] 유저의 입력값을 기준으로 이동할때 성공케이스")
    void moveSuccess() {
        //given
        Bridge bridge = new Bridge(3, Arrays.asList(UP_STAIRS, DOWN_STAIRS, DOWN_STAIRS));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        User user = new User();
        //when
        bridgeGame.move(user, UP_STAIRS);
        //then
        Assertions.assertThat(user.getUserInputs().get(0)).isEqualTo(UP_STAIRS);
        Assertions.assertThat(user.getUsersStatus().get(0)).isEqualTo(User.CROSS_STATUS);
    }

    @Test
    @DisplayName("[move] 유저의 입력값을 기준으로 이동할때 실패 케이스")
    void moveFail() {
        //given
        Bridge bridge = new Bridge(3, Arrays.asList(UP_STAIRS, DOWN_STAIRS, DOWN_STAIRS));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        User user = new User();
        //when
        bridgeGame.move(user, DOWN_STAIRS);
        //then
        Assertions.assertThat(user.getUserInputs().get(0)).isEqualTo(DOWN_STAIRS);
        Assertions.assertThat(user.getUsersStatus().get(0)).isEqualTo(User.NOT_CROSS_STATUS);
    }
}