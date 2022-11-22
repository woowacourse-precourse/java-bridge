package model;

import static bridge.model.constant.MoveDirection.DOWN;
import static bridge.model.constant.MoveDirection.UP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.GameStatus;
import bridge.model.constant.MoveDirection;
import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BridgeGameTest {

    private final int SIZE = 3;

    private BridgeGame bridgeGame;

    @BeforeEach
    private void initialize() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(SIZE));
    }


    @Nested
    @DisplayName("retry 메서드는 게임 상태를 초기화하는데,")
    class describe_retry {

        @Test
        @DisplayName("시도 횟수는 1증가하고, 이동 기록은 초기화된다.")
        void increaseTryCountAndResetMoveHistory() {
            bridgeGame.move(UP);
            bridgeGame.retry();
            GameStatus gameStatus = bridgeGame.getGameStatus();
            assertThat(gameStatus.tryCount()).isEqualTo(2);
            assertThat(bridgeGame.inProcess()).isEqualTo(true);

            assertThat(gameStatus.getMoveDirections()).isEmpty();
        }
    }

    @Nested
    @DisplayName("move 메서드는 MoveDirection을 입력받아 1회 이동을 수행하는데,")
    class describe_move {

        @Test
        @DisplayName("이동 방향을 내부 리스트에 업데이트한다.")
        void test() {
            assertThat(bridgeGame.getSimpleGameStatus().getMoveDirections()).isEmpty();
            bridgeGame.move(UP);
            assertThat(bridgeGame.getSimpleGameStatus().getMoveDirections().size()).isEqualTo(1);
        }
    }

    @Nested
    @DisplayName("succeed() 메서드는 게임 클리어 여부를 반환한다.")
    class describe_succeed {

        @Test
        @DisplayName("게임을 실패한 경우 false 반환한다.")
        void returnFalseWhenFailGame() {
            bridgeGame.move(DOWN);
            assertThat(bridgeGame.succeed()).isEqualTo(false);
        }

        @Test
        @DisplayName("게임을 클리어한 경우 true 반환한다.")
        void returnTrueWhenSucceedGame() {
            bridgeGame.move(UP);
            bridgeGame.move(DOWN);
            bridgeGame.move(DOWN);

            assertThat(bridgeGame.succeed()).isEqualTo(true);
        }

        @Test
        @DisplayName("게임이 진행중인 경우 false 반환한다.")
        void returnFalseWhenGameInProcess() {
            bridgeGame.move(UP);
            assertThat(bridgeGame.succeed()).isEqualTo(false);
        }
    }

    @Nested
    @DisplayName("gameOver() 메서드는 게임 오버 여부를 반환한다.")
    class describe_gameOver {

        @Test
        @DisplayName("게임을 실패한 경우 true 반환한다.")
        void returnTrueWhenFailGame() {
            bridgeGame.move(DOWN);
            assertThat(bridgeGame.gameOver()).isEqualTo(true);
        }

        @Test
        @DisplayName("게임을 클리어한 경우 false 반환한다.")
        void returnFalseWhenSucceedGame() {
            bridgeGame.move(UP);
            bridgeGame.move(DOWN);
            bridgeGame.move(DOWN);

            assertThat(bridgeGame.gameOver()).isEqualTo(false);
        }

        @Test
        @DisplayName("게임이 진행중인 경우 false 반환한다.")
        void returnFalseWhenGameInProcess() {
            bridgeGame.move(UP);
            assertThat(bridgeGame.gameOver()).isEqualTo(false);
        }
    }

    @Nested
    @DisplayName("inProcess() 메서드는 게임 진행중 여부를 반환한다.")
    class describe_inProcess {

        @Test
        @DisplayName("게임을 실패한 경우 false 반환한다.")
        void returnFalseWhenFailGame() {
            bridgeGame.move(DOWN);
            assertThat(bridgeGame.inProcess()).isEqualTo(false);
        }

        @Test
        @DisplayName("게임을 클리어한 경우 false 반환한다.")
        void returnFalseWhenSucceedGame() {
            bridgeGame.move(UP);
            bridgeGame.move(DOWN);
            bridgeGame.move(DOWN);

            assertThat(bridgeGame.inProcess()).isEqualTo(false);
        }

        @Test
        @DisplayName("게임이 진행중인 경우 true 반환한다.")
        void returnTrueWhenGameInProcess() {
            bridgeGame.move(UP);
            assertThat(bridgeGame.inProcess()).isEqualTo(true);
        }
    }

    @Nested
    @DisplayName("getGameStatus 메서드는 현재 게임 상태를 반환하는데,")
    class describe_getGameStatus {

        @Test
        @DisplayName("gameStatus에 필요한 모든 정보를 담는다.")
        void containsAllInformationNeedToGameStatus() {
            bridgeGame.move(DOWN);
            GameStatus gameStatus = bridgeGame.getGameStatus();

            assertThat(gameStatus.getMoveDirections()).isEqualTo(List.of(DOWN));
            assertThat(gameStatus.getMoveDirections().size()).isEqualTo(1);
            assertThat(gameStatus.fail()).isEqualTo(true);
            assertThat(gameStatus.tryCount()).isEqualTo(1);
        }
    }

    @Nested
    @DisplayName("getSimpleGameStatus 메서드는 현재 게임 상태를 반환하는데,")
    class describe_getSimpleGameStatus {

        @Test
        @DisplayName("tryCount를 제외한 정보를 담아 반환한다.")
        void containsAllInformationNeedToGameStatus() {
            bridgeGame.move(DOWN);
            GameStatus gameStatus = bridgeGame.getSimpleGameStatus();

            assertThat(gameStatus.getMoveDirections()).isEqualTo(List.of(DOWN));
            assertThat(gameStatus.getMoveDirections().size()).isEqualTo(1);
            assertThat(gameStatus.fail()).isEqualTo(true);
            assertThatThrownBy(() -> gameStatus.tryCount()).isInstanceOf(NoSuchElementException.class);
        }
    }
    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
