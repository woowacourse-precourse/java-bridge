package bridge;

import bridge.domain.BridgeGame;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {
    @Test
    @DisplayName("입력받은 방향으로 이동이 가능하다.")
    void moveWithInputMovement() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");

        assertThat(bridgeGame.getPlayer()).isEqualTo(List.of("U", "D", "D"));
    }

    @Test
    @DisplayName("U와 D이외의 입력으론 움직이지 않는다.")
    void moveWithDigitInput() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));

        assertThatThrownBy(() -> bridgeGame.move("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("브릿지와 플레이어가 같다면, 다리를 다 건넌 것이다.")
    void checkCrossBridgeWithSame() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");

        assertThat(bridgeGame.isEnd()).isEqualTo(true);
    }

    @Test
    @DisplayName("브릿지와 플레이어가 다르다면, 다리를 다 건너지 못했다.")
    void checkCrossBridgeWithNotSame() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));
        bridgeGame.move("U");
        bridgeGame.move("D");

        assertThat(bridgeGame.isEnd()).isEqualTo(false);
    }

    @Test
    @DisplayName("브릿지와 플레이어의 길이가 같더라도, 다르다면 다 건너지 않은 것이다.")
    void checkCrossBridgeWithSameLength() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");


        assertThat(bridgeGame.isEnd()).isEqualTo(false);
    }


    @Test
    @DisplayName("현재 위치가 이동가능한 위치인지 판단할 수 있다.")
    void checkCurrentPositionIsMovable() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));
        bridgeGame.move("U");
        bridgeGame.move("D");

        assertThat(bridgeGame.isMovableArea()).isEqualTo(true);
    }

    @Test
    @DisplayName("현재 위치가 이동가능한 위치인지 판단할 수 있다_2.")
    void checkCurrentPositionIsMovableTwo() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));
        bridgeGame.move("U");
        bridgeGame.move("U");

        assertThat(bridgeGame.isMovableArea()).isEqualTo(false);
    }

    @Test
    @DisplayName("리셋 시, 플레이어가 비워지고 시도 횟수가 올라간다.")
    void resetTest() {
        SoftAssertions softAssertions = new SoftAssertions();
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.retry();

        softAssertions.assertThat(bridgeGame.getPlayer()).as("플레이어 비우기").isEqualTo("");
        softAssertions.assertThat(bridgeGame.getRetryCount()).as("시도 횟수 카운트").isEqualTo(1);
    }
}