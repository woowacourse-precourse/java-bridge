package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameTest {

    BridgeGame game;

    @BeforeEach
    void init() {
        Bridge bridge = new Bridge(List.of("U", "D", "D"));
        game = new BridgeGame(bridge);
    }

    @DisplayName("다음 위치로 움직일 수 있는지 확인후 이동한다.")
    @Test
    void move() {
        assertThat(game.move(BridgeCell.UP)).isTrue();
        assertThat(game.move(BridgeCell.DOWN)).isTrue();
        assertThat(game.move(BridgeCell.UP)).isFalse();
    }

    @DisplayName("다리를 넘어서 움직이려하면 예외가 발생한다.")
    @Test
    void moveOver() {
        assertThat(game.move(BridgeCell.UP)).isTrue();
        assertThat(game.move(BridgeCell.DOWN)).isTrue();
        assertThat(game.move(BridgeCell.DOWN)).isTrue();

        assertThatThrownBy(() -> game.move(BridgeCell.DOWN))
                .isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("이동 기록을 통해 현재 다리의 상태를 알 수 있다.")
    @Test
    void getMap() {
        // given
        game.move(BridgeCell.UP);
        game.move(BridgeCell.DOWN);
        game.move(BridgeCell.UP);

        // when
        String map = game.getMap();

        // then
        assertThat(map).isEqualTo(
                "[ O |   | X ]\n" +
                        "[   | O |   ]"
        );
    }

    @DisplayName("재시작 명령이 입력되면 게임을 재시작 한다.")
    @Test
    void retry() {
        // given
        game.move(BridgeCell.UP);
        game.move(BridgeCell.DOWN);

        // when, then
        assertThat(game.retry()).isTrue();
    }

    @DisplayName("다리 끝까지 이동하였고 이동에 성공했다면 게임이 끝났다.")
    @Test
    void gameEnd() {
        // given
        game.move(BridgeCell.UP);
        game.move(BridgeCell.DOWN);
        game.move(BridgeCell.DOWN);

        // when, then
        assertThat(game.isEnd()).isTrue();
    }

    @DisplayName("다리 끝까지 이동하였지만 이동에 실패하면 게임이 끝나지 않았다.")
    @Test
    void gameFail() {
        // given
        game.move(BridgeCell.UP);
        game.move(BridgeCell.DOWN);
        game.move(BridgeCell.UP);

        // when, then
        assertThat(game.isEnd()).isFalse();
    }

    @DisplayName("다리 끝까지 이동하지 않았다면 게임이 끝나지 않았다.")
    @Test
    void gameProgress() {
        // given
        game.move(BridgeCell.UP);
        game.move(BridgeCell.DOWN);

        // when, then
        assertThat(game.isEnd()).isFalse();
    }

    @DisplayName("현재 게임의 최종 결과를 알 수 있다.")
    @Test
    void getResult() {
        // given
        game.move(BridgeCell.UP);
        game.move(BridgeCell.DOWN);
        game.move(BridgeCell.DOWN);

        // when, then
        assertThat(game.getResult()).isEqualTo(
                "게임 성공 여부: 성공\n" +
                        "총 시도한 횟수: 1"
        );
    }
}
