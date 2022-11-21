package bridge.domain;

import static bridge.domain.MovingMapState.FAIL;
import static bridge.domain.MovingMapState.NOT_GOING;
import static bridge.domain.MovingMapState.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @DisplayName("움직임 여부")
    @Nested
    class MoveTest {

        @DisplayName("움직임")
        @Test
        void move() {
            Player player = new Player();
            BridgeGame bridgeGame = new BridgeGame(
                    List.of("U", "D", "D"), player);

            bridgeGame.move("U");

            int position = player.getPosition();
            assertThat(position).isEqualTo(0);
        }
    }

    @DisplayName("게임 종료 여부")
    @Nested
    class IsGameEndTest {

        @DisplayName("게임이 끝나지 않은 경우 종료가 아니여야 한다.")
        @Test
        void notFinished() {
            BridgeGame bridgeGame = new BridgeGame(
                    List.of("U", "D", "D"), new Player());

            boolean isEnd = bridgeGame.isGameEnd();
            assertThat(isEnd).isEqualTo(false);
        }

        @DisplayName("게임이 클리어 되면 종료여야 한다.")
        @Test
        void gameClear() {
            BridgeGame bridgeGame = new BridgeGame(
                    List.of("U"), new Player());

            bridgeGame.move("U");

            boolean isEnd = bridgeGame.isGameEnd();
            assertThat(isEnd).isEqualTo(true);
        }

        @DisplayName("게임을 종료시키면 종료여야 한다.")
        @Test
        void isGameEnd() {
            BridgeGame bridgeGame = new BridgeGame(
                    List.of("U"), new Player());

            bridgeGame.finishGame();

            boolean isEnd = bridgeGame.isGameEnd();
            assertThat(isEnd).isEqualTo(true);
        }
    }


    @DisplayName("게임 클리어 여부")
    @Nested
    class IsGameClearTest {

        @DisplayName("게임 클리어가 되어야 한다")
        @Test
        void gameClear() {
            BridgeGame bridgeGame = new BridgeGame(
                    List.of("U"), new Player());

            bridgeGame.move("U");

            boolean isClear = bridgeGame.isGameClear();
            assertThat(isClear).isEqualTo(true);
        }

        @DisplayName("게임이 끝나지 않은 경우 클리어되지 않음")
        @Test
        void notFinished() {
            BridgeGame bridgeGame = new BridgeGame(
                    List.of("U"), new Player());

            boolean isClear = bridgeGame.isGameClear();
            assertThat(isClear).isEqualTo(false);
        }
    }

    @DisplayName("게임 실패 여부")
    @Nested
    class IsGameFailedTest {

        @DisplayName("실패하지 않음")
        @Test
        void notFailed() {
            BridgeGame bridgeGame = new BridgeGame(
                    List.of("U"), new Player());

            bridgeGame.move("U");

            boolean isFailed = bridgeGame.isGameFailed();
            assertThat(isFailed).isEqualTo(false);
        }

        @DisplayName("실패함")
        @Test
        void failed() {
            BridgeGame bridgeGame = new BridgeGame(
                    List.of("U"), new Player());

            bridgeGame.move("D");

            boolean isFailed = bridgeGame.isGameFailed();
            assertThat(isFailed).isEqualTo(true);
        }
    }

    @DisplayName("게임 재시도")
    @Nested
    class RetryTest {

        @DisplayName("실패함 에서 게임 재시도를 하면 실패 아님")
        @Test
        void retryWhenFail() {
            BridgeGame bridgeGame = new BridgeGame(
                    List.of("U"), new Player());
            bridgeGame.move("D");

            bridgeGame.retry();

            boolean isFailed = bridgeGame.isGameFailed();
            assertThat(isFailed).isEqualTo(false);
        }

        @DisplayName("종료됨 에서 게임 재시도를 하면 종료 아님")
        @Test
        void retryWhenEnd() {
            BridgeGame bridgeGame = new BridgeGame(
                    List.of("U"), new Player());
            bridgeGame.finishGame();

            bridgeGame.retry();

            boolean isEnd = bridgeGame.isGameEnd();
            assertThat(isEnd).isEqualTo(false);
        }
    }

    @DisplayName("게임 종료")
    @Nested
    class IsFinishGameTest {

        @DisplayName("게임이 종료되면 종료 여부가 참 이여야 한다.")
        @Test
        void finish() {
            BridgeGame bridgeGame = new BridgeGame(
                    List.of("U"), new Player());

            bridgeGame.finishGame();
            boolean isEnd = bridgeGame.isGameEnd();

            assertThat(isEnd).isEqualTo(true);
        }
    }

    @DisplayName("게임 시도 횟수 구하기")
    @Nested
    class GetTryCountTest {

        @DisplayName("게임 3번 리트라이 하면 4가 나와야 한다.")
        @Test
        void retryThird() {
            BridgeGame bridgeGame = new BridgeGame(
                    List.of("U"), new Player());
            final int retryCount = 3;

            for (int i = 0; i < retryCount; i++) {
                bridgeGame.retry();
            }

            int tryCount = bridgeGame.getTryCount();
            assertThat(tryCount).isEqualTo(retryCount + 1);
        }
    }

    @DisplayName("게임 이동 맵 구하기")
    @Nested
    class GetMovingMapTest {

        @DisplayName("알맞은 방향으로 움직이기")
        @Test
        void moveClear() {
            BridgeGame bridgeGame = new BridgeGame(
                    List.of("U", "U", "U"), new Player());
            bridgeGame.move("U");
            bridgeGame.move("U");
            bridgeGame.move("U");

            MovingMap movingMap = bridgeGame.getMovingMap();
            List<MovingMapState> upStates = movingMap.getStateList("U");
            List<MovingMapState> downStates = movingMap.getStateList("D");

            assertThat(upStates).isEqualTo(List.of(SUCCESS, SUCCESS, SUCCESS));
            assertThat(downStates).isEqualTo(List.of(NOT_GOING, NOT_GOING, NOT_GOING));
        }

        @DisplayName("틀린 방향으로 움직이기")
        @Test
        void moveWrong() {
            BridgeGame bridgeGame = new BridgeGame(
                    List.of("U", "U", "U"), new Player());
            bridgeGame.move("U");
            bridgeGame.move("D");

            MovingMap movingMap = bridgeGame.getMovingMap();
            List<MovingMapState> upStates = movingMap.getStateList("U");
            List<MovingMapState> downStates = movingMap.getStateList("D");

            assertThat(upStates).isEqualTo(List.of(SUCCESS, NOT_GOING));
            assertThat(downStates).isEqualTo(List.of(NOT_GOING, FAIL));
        }
    }
}