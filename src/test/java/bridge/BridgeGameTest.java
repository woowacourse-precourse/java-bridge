package bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BridgeGameTest {
    @Test
    void BridgeGame을_생성한다() {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 0, 0)));

        assertDoesNotThrow(() -> new BridgeGame(bridgeMaker, 3));
    }

    @CsvSource(value = {"U:true", "D:false"}, delimiter = ':')
    @ParameterizedTest
    void move(String moving, boolean result) {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 0, 0)));
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, 3);

        bridgeGame.move(moving);

        assertThat(bridgeGame.inProgress()).isEqualTo(result);
    }

    @Test
    void 게임을_재시작한다() {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 0, 0, 1, 0, 0)));
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, 3);
        bridgeGame.move("U");
        bridgeGame.move("U");

        bridgeGame.retry();

        assertThat(bridgeGame.attemptCount()).isEqualTo(2);
    }

    @Test
    void 게임_진행_중에는_재시작할_수_없다() {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 0, 0)));
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, 3);
        bridgeGame.move("U");

        assertThatThrownBy(bridgeGame::retry)
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 성공한_경우_재시작할_수_없다() {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 0, 0)));
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, 3);
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");

        assertThatThrownBy(bridgeGame::retry)
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 진행_여부를_반환한다_true() {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 0, 0)));
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, 3);
        bridgeGame.move("U");

        assertThat(bridgeGame.inProgress()).isTrue();
    }

    @Test
    void 진행_여부를_반환한다_false() {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 0, 0)));
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, 3);
        bridgeGame.move("D");

        assertThat(bridgeGame.inProgress()).isFalse();
    }

    @Test
    void 성공한_경우_진행_여부는_false다() {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 0, 0)));
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, 3);
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");

        assertThat(bridgeGame.inProgress()).isFalse();
    }

    @Test
    void 성공한_경우_성공여부는_true다() {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 0, 0)));
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, 3);
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");

        assertThat(bridgeGame.isSuccess()).isTrue();
    }

    @Test
    void 실패한_경우_성공여부는_false다() {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 0, 0)));
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, 3);
        bridgeGame.move("D");

        assertThat(bridgeGame.isSuccess()).isFalse();
    }

    @Test
    void 진행중인_경우_성공여부는_false다() {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 0, 0)));
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, 3);
        bridgeGame.move("U");

        assertThat(bridgeGame.isSuccess()).isFalse();
    }

    @Test
    void 게임_시도_회수를_반환한다() {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 0, 0, 1, 0, 0)));
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, 3);
        bridgeGame.move("D");
        int count = bridgeGame.attemptCount();

        bridgeGame.retry();

        assertAll(
                () -> assertThat(count).isEqualTo(1),
                () -> assertThat(bridgeGame.attemptCount()).isEqualTo(2));
    }
}
