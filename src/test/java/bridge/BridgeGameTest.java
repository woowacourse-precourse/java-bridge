package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    void 이동_테스트() {
        BridgeGame game = new BridgeGame(new BridgeRandomNumberGenerator(), 5);
        game.move(1);
        game.move(1);
        game.move(1);
        game.move(0);
        game.move(1);

        assertThat(game.getUserSelect()).containsExactlyElementsOf(List.of("U", "U", "U", "D", "U"));
    }

    @Test
    void 실패_검사_테스트1() {
        BridgeGame game = new BridgeGame(new ArrayNumberGenerator(List.of(1, 0, 0, 1, 1)), 5);

        game.move(1);
        game.move(0);
        game.move(0);
        game.move(1);
        game.move(1);

        assertThat(game.isFailed()).isEqualTo(false);
    }

    @Test
    void 실패_검사_테스트2() {
        BridgeGame game = new BridgeGame(new ArrayNumberGenerator(List.of(1, 0, 0, 1, 1)), 5);

        game.move(1);
        game.move(0);
        game.move(1);
        game.move(1);
        game.move(1);

        assertThat(game.isFailed()).isEqualTo(true);
    }

    @Test
    void 종료_검사_테스트1() {
        BridgeGame game = new BridgeGame(new ArrayNumberGenerator(List.of(1, 0, 0, 1, 1)), 5);

        game.move(1);
        game.move(0);

        assertThat(game.isEnd()).isEqualTo(false);
    }

    @Test
    void 종료_검사_테스트2() {
        BridgeGame game = new BridgeGame(new ArrayNumberGenerator(List.of(1, 0, 0, 1, 1)), 5);

        game.move(1);
        game.move(0);
        game.move(1);

        assertThat(game.isEnd()).isEqualTo(true);
    }

    @Test
    void 종료_검사_테스트3() {
        BridgeGame game = new BridgeGame(new ArrayNumberGenerator(List.of(1, 0, 0, 1, 1)), 5);

        game.move(1);
        game.move(0);
        game.move(0);
        game.move(1);
        game.move(1);

        assertThat(game.isEnd()).isEqualTo(true);
    }

    @Test
    void 재시도_테스트1() {
        BridgeGame game = new BridgeGame(new ArrayNumberGenerator(List.of(1, 0, 0, 1, 1)), 5);

        game.move(1);
        game.move(0);
        game.move(1);
        game.move(1);
        game.move(1);

        assertThat(game.isFailed()).isEqualTo(true);
        game.retry();
        assertThat(game.isFailed()).isEqualTo(false);
        assertThat(game.getTryCount()).isEqualTo(2);
    }

    @Test
    void 재시도_테스트2() {
        BridgeGame game = new BridgeGame(new ArrayNumberGenerator(List.of(1, 0, 0, 1, 1)), 5);

        game.move(1);
        game.move(0);
        game.move(0);
        game.move(1);
        game.move(1);

        assertThat(game.isEnd()).isEqualTo(true);
        assertThat(game.isFailed()).isEqualTo(false);
        game.retry();
        assertThat(game.isEnd()).isEqualTo(false);
        assertThat(game.getTryCount()).isEqualTo(2);
    }
}
