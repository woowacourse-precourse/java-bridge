package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeGameTest {
    @DisplayName("성공 시 현재 이동한 다리의 상태를 잘 반환한다.")
    @Test
    void 다리_이동_성공_테스트() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","D","U"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");

        assertThat(bridgeGame.getMapLines()).contains("[ O |   | O ]","[   | O |   ]");
    }

    @DisplayName("실패 시 현재 이동한 다리의 상태를 잘 반환한다.")
    @Test
    void 다리_이동_실패_테스트() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","D","U"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");

        assertThat(bridgeGame.getMapLines()).contains("[ O |   |   ]","[   | O | X ]");
    }

    @DisplayName("현재까지의 사용자 이동이 bridge와 일치하지 않으면 round가 종료된다.")
    @Test
    void 라운드_종료_테스트() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","D","U"));
        bridgeGame.move("D");
        bridgeGame.move("U");

        assertThat(bridgeGame.roundOver()).isTrue();
    }

    @DisplayName("사용자 입력이 잘못되어 bridge가 생성되지 않으면 게임을 실패한다.")
    @Test
    void 게임_실패_테스트() {
        BridgeGame bridgeGame = new BridgeGame(Collections.emptyList());

        assertThat(bridgeGame.winTheGame()).isFalse();
    }

    @DisplayName("라운드가 종료되지 않았는데 게임에서 승리할 수 없다.")
    @Test
    void 라운드_진행중_게임승리_불가능_테스트() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","D","U"));
        bridgeGame.move("U");

        assertThat(!bridgeGame.roundOver() && bridgeGame.winTheGame()).isFalse();
    }

    @DisplayName("게임을 재시작하면 Bridge는 유지하고, movement만 초기화된다.")
    @Test
    void 게임_재시작_테스트() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U","D","U"));
        bridgeGame.move("U");
        bridgeGame.move("U");

        assertThat(bridgeGame.getMapLines()).contains("[ O | X ]","[   |   ]");

        bridgeGame.retry("R");
        bridgeGame.move("U");

        assertThat(bridgeGame.getMapLines()).contains("[ O ]","[   ]");
    }
}
