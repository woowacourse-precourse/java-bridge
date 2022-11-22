package bridge.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.BridgeNumberGenerator;
import bridge.BridgeMaker;
import bridge.domain.Result;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private static BridgeMaker lowerBridgeMaker;

    @BeforeAll
    static void init() {
        BridgeNumberGenerator zeroGenerator = () -> 0;
        lowerBridgeMaker = new BridgeMaker(zeroGenerator);
    }

    @Nested
    @DisplayName("정상 동작 테스트")
    class NormalTest {

        @Test
        @DisplayName("올바른 길을 선택하면 살아남는다")
        void survive() {
            BridgeGame bridgeGame = BridgeGame.createInstance(lowerBridgeMaker);
            bridgeGame.initBridge(3);

            Result nextResult = Result.of(bridgeGame, true, false);
            Result result = bridgeGame.move("D");

            assertThat(result).usingRecursiveComparison().isEqualTo(nextResult);
        }

        @Test
        @DisplayName("다리를 전부 건너면 승리한다")
        void victoryGame() {
            BridgeGame bridgeGame = BridgeGame.createInstance(lowerBridgeMaker);
            bridgeGame.initBridge(3);

            bridgeGame.move("D");
            bridgeGame.move("D");

            Result nextResult = Result.of(bridgeGame, true, true);
            Result result = bridgeGame.move("D");

            assertThat(result).usingRecursiveComparison().isEqualTo(nextResult);
        }

        @Test
        @DisplayName("틀린 경로를 선택해 실패된 결과가 반환된다.")
        void defeatGame() {
            BridgeGame bridgeGame = BridgeGame.createInstance(lowerBridgeMaker);
            bridgeGame.initBridge(3);

            bridgeGame.move("D");

            Result nextResult = Result.of(bridgeGame, false, false);
            Result result = bridgeGame.move("U");

            assertThat(result).usingRecursiveComparison().isEqualTo(nextResult);
        }

        @Test
        @DisplayName("실패 시 카운트를 증가시키고 게임을 재시도 할 수 있다.")
        void retryTerminatedGame() {
            BridgeGame bridgeGame = BridgeGame.createInstance(lowerBridgeMaker);
            bridgeGame.initBridge(3);

            bridgeGame.move("U");
            bridgeGame.retry();

            Result nextResult = Result.of(bridgeGame, true, false);
            Result result = bridgeGame.move("D");

            assertThat(result).usingRecursiveComparison().isEqualTo(nextResult);
            assertThat(result.getGameCount()).isEqualTo(2);
        }

        @Test
        @DisplayName("진행중이던 게임을 카운트를 증가시키고 초기화 할 수 있다.")
        void retryInProgressGame() {
            BridgeGame bridgeGame = BridgeGame.createInstance(lowerBridgeMaker);
            bridgeGame.initBridge(3);

            bridgeGame.retry();

            Result nextResult = Result.of(bridgeGame, true, false);
            Result result = bridgeGame.move("D");

            assertThat(result).usingRecursiveComparison().isEqualTo(nextResult);
            assertThat(result.getGameCount()).isEqualTo(2);
        }

        @Test
        @DisplayName("승리한 게임을 카운트를 증가시키고 초기화 할 수 있다.")
        void retryVictoryGame() {
            BridgeGame bridgeGame = BridgeGame.createInstance(lowerBridgeMaker);
            bridgeGame.initBridge(3);

            bridgeGame.move("D");
            bridgeGame.move("D");
            Result victoryResult = bridgeGame.move("D");

            bridgeGame.retry();

            Result nextResult = Result.of(bridgeGame, true, false);
            Result result = bridgeGame.move("D");

            assertThat(victoryResult.isVictory()).isTrue();
            assertThat(result).usingRecursiveComparison().isEqualTo(nextResult);
            assertThat(result.getGameCount()).isEqualTo(2);
        }
    }

    @Nested
    @DisplayName("예외 테스트")
    class ExceptionTest {

        @Test
        @DisplayName("다리를 중복 생성하면 예외가 발생한다.")
        void alreadyExistBridge() {
            BridgeGame bridgeGame = BridgeGame.createInstance(lowerBridgeMaker);
            bridgeGame.initBridge(3);

            assertThatThrownBy(() -> bridgeGame.initBridge(3))
                .isInstanceOf(IllegalStateException.class);
        }

        @Test
        @DisplayName("이미 종료된 게임은 더 이상 진행할 수 없다.")
        void alreadyTerminatedGame() {
            BridgeGame bridgeGame = BridgeGame.createInstance(lowerBridgeMaker);
            bridgeGame.initBridge(3);

            bridgeGame.move("U");

            assertThatThrownBy(() -> bridgeGame.move("U"))
                .isInstanceOf(IllegalStateException.class);
        }

        @Test
        @DisplayName("유효하지 않은 커맨드는 입력될 수 없다.")
        void inputInvalidCommand() {
            BridgeGame bridgeGame = BridgeGame.createInstance(lowerBridgeMaker);
            bridgeGame.initBridge(3);

            assertThatThrownBy(() -> bridgeGame.move("C"))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
