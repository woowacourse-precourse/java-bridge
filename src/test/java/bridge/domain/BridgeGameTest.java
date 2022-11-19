package bridge.domain;

import bridge.dto.UserState;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @DisplayName("BridgeGame 유저 이동 기능 테스트")
    @Test
    void Bridge_Game_이동_테스트() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertAll(() -> {
            bridgeGame.move(Direction.U);
            assertThat(bridgeGame).extracting("user").extracting("userPosition").isEqualTo(1);

            bridgeGame.move(Direction.D);
            assertThat(bridgeGame).extracting("user").extracting("userPosition").isEqualTo(2);

            bridgeGame.move(Direction.U);
            assertThat(bridgeGame).extracting("user").extracting("userPosition").isEqualTo(3);
        });
    }

    @DisplayName("유저가 잘못된 방향으로 진행하면 사망한다")
    @Test
    void 잘못된_이동_사망_테스트() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move(Direction.D);
        assertThat(bridgeGame).extracting("user").extracting("aliveUser").isEqualTo(false);
    }

    @DisplayName("유저가 사망하면 게임의 턴은 종료된 것이다.")
    @Test
    void 유저_사망_게임_턴종료_테스트() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertAll(() -> {
            bridgeGame.move(Direction.U);
            assertThat(bridgeGame.isEndGame()).isFalse();

            bridgeGame.move(Direction.D);
            assertThat(bridgeGame.isEndGame()).isFalse();

            bridgeGame.move(Direction.D);
            assertThat(bridgeGame.isEndGame()).isTrue();
        });
    }

    @DisplayName("유저가 다리의 끝에 살아서 도착하면 게임은 끝난 것이다.")
    @Test
    void 다리게임_종료_조건_검증_테스트() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertAll(() -> {
            bridgeGame.move(Direction.U);
            assertThat(bridgeGame.isNeedToQuit()).isFalse();

            bridgeGame.move(Direction.D);
            assertThat(bridgeGame.isNeedToQuit()).isFalse();

            bridgeGame.move(Direction.U);
            assertThat(bridgeGame.isNeedToQuit()).isTrue();
        });
    }

    @DisplayName("유저가 다리의 끝에 도착했지만 죽어있으면 게임은 끝난 것이 아니다")
    @Test
    void 다리게임_종료_조건_거짓_검증_테스트() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertAll(() -> {
            bridgeGame.move(Direction.U);
            assertThat(bridgeGame.isNeedToQuit()).isFalse();

            bridgeGame.move(Direction.D);
            assertThat(bridgeGame.isNeedToQuit()).isFalse();

            bridgeGame.move(Direction.D);
            assertThat(bridgeGame.isNeedToQuit()).isFalse();
        });
    }

    @DisplayName("게임 상황 진행 정보 Map 반환 테스트")
    @Test
    void 게임_상황_진행_정보_반환_테스트() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move(Direction.U);
        bridgeGame.move(Direction.D);

        UserState userState = bridgeGame.getProgressUserState();
        assertAll(() -> {
            assertThat(userState.getBridge()).isEqualTo(bridge);
            assertThat(userState.getUserPosition()).isEqualTo(2);
            assertThat(userState.isAliveUser()).isTrue();
        });
    }

    @DisplayName("게임 재시작 세팅 테스트")
    @Test
    void 게임을_재시작_하기_위해서_게임_진행_변수를_변경해준다() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertAll(() -> {
            bridgeGame.move(Direction.U);
            bridgeGame.move(Direction.U);
            assertThat(bridgeGame.isEndGame()).isTrue();
            assertThat(bridgeGame).extracting("user").extracting("aliveUser").isEqualTo(false);
            assertThat(bridgeGame).extracting("user").extracting("userPosition").isEqualTo(2);
            assertThat(bridgeGame).extracting("numberOfAttempts").isEqualTo(1);

            bridgeGame.retry(Command.Restart);
            assertThat(bridgeGame.isEndGame()).isFalse();
            assertThat(bridgeGame).extracting("user").extracting("aliveUser").isEqualTo(true);
            assertThat(bridgeGame).extracting("user").extracting("userPosition").isEqualTo(0);
            assertThat(bridgeGame).extracting("numberOfAttempts").isEqualTo(2);
        });
    }

    @DisplayName("게임 종료 테스트")
    @Test
    void 게임_종료_커맨드를_입력하면_게임이_종료된다() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        assertAll(() -> {
            bridgeGame.move(Direction.U);
            bridgeGame.move(Direction.U);
            assertThat(bridgeGame.isNeedToQuit()).isFalse();

            bridgeGame.retry(Command.Quit);
            assertThat(bridgeGame.isNeedToQuit()).isTrue();
        });
    }
}