package bridge.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import bridge.domain.errorenum.ErrorMessage;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {
    private final String ERROR_HEAD = "[ERROR]";
    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame(new Bridge(List.of("U", "D", "U")));
    }

    @Nested
    @DisplayName("플레이어의 이동을 테스트한다")
    class MoveTest {
        @DisplayName("플레이어가 U, D 외의 값을 입력할 경우 예외가 발생한다")
        @Test
        void createInputWithWrongString() {
            String wrongInput = "R";

            assertThatThrownBy(() -> bridgeGame.move(wrongInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.NOT_IN_MOVE_POSITION.printMessage())
                    .hasMessageStartingWith(ERROR_HEAD);
        }

        @DisplayName("플레이어가 게임 진행 중 이동에 성공할 경우 및 실패할 경우의 - 게임 진행 여부, 게임 오버 여부, 게임 성공 여부를 테스트한다")
        @ParameterizedTest
        @CsvSource(value = {"U:true:false:false", "D:false:true:false"}, delimiter = ':')
        void testPlayerMoveResult(String movePosition, boolean isPlaying, boolean isGameOver, boolean isGamePass) {
            bridgeGame.move(movePosition);

            assertAll(
                    () -> assertThat(bridgeGame.isGameOver()).isEqualTo(isGameOver),
                    () -> assertThat(bridgeGame.isGamePlaying()).isEqualTo(isPlaying),
                    () -> assertThat(bridgeGame.isGamePass()).isEqualTo(isGamePass)
            );
        }
    }

    @Nested
    @DisplayName("플레이어의 재시작, 종료 입력을 테스트한다")
    class RetryTest {
        @DisplayName("플레이어가 R, Q 외의 값을 입력하면 예외가 발생한다")
        @Test
        void createInputWithWrongValueForRestart() {
            String wrongInput = "U";

            assertThatThrownBy(() -> bridgeGame.retry(wrongInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.NOT_IN_RESTART.printMessage())
                    .hasMessageStartingWith(ERROR_HEAD);
        }

        @DisplayName("게임 실패 후 플레이어가 재시작을 선택할 경우 - 게임 진행 여부, 게임 오버 여부, 게임 성공 여부, 이동 내역 초기화, 시도횟수 증가를 테스트한다")
        @Test
        void testPlayerRetry() {
            int tryCountBeforeRetry = bridgeGame.getTryCount();

            bridgeGame.move("D");
            bridgeGame.retry("R");

            assertAll(
                    () -> assertThat(bridgeGame.isGameOver()).isFalse(),
                    () -> assertThat(bridgeGame.isGamePlaying()).isTrue(),
                    () -> assertThat(bridgeGame.isGamePass()).isFalse(),
                    () -> assertThat(bridgeGame.getCurrentMap()).containsOnly(Collections.emptyList()),
                    () -> assertThat(bridgeGame.getTryCount()).isEqualTo(tryCountBeforeRetry + 1)
            );
        }

        @DisplayName("게임 실패 후 플레이어가 종료를 선택할 경우 - 게임 진행 여부, 게임 오버 여부, 게임 성공 여부를 테스트한다")
        @Test
        void testPlayerExit() {
            bridgeGame.move("D");
            bridgeGame.retry("Q");

            assertAll(
                    () -> assertThat(bridgeGame.isGameOver()).isTrue(),
                    () -> assertThat(bridgeGame.isGamePlaying()).isFalse(),
                    () -> assertThat(bridgeGame.isGamePass()).isFalse()
            );
        }
    }

    @Nested
    @DisplayName("플레이어가 다리의 마지막 칸을 이동한 경우를 테스트한다")
    class MoveLastBridgeTest {
        @DisplayName("플레이어가 다리의 마지막 칸 이동을 성공한 경우 및 실패한 경우 - 게임 진행 여부, 게임 오버 여부, 게임 성공 여부를 테스트한다")
        @ParameterizedTest
        @CsvSource(value = {"U:false:false:true", "D:false:true:false"}, delimiter = ':')
        void testPlayerMoveResult(String movePosition, boolean isPlaying, boolean isGameOver, boolean isGamePass) {
            bridgeGame.move("U");
            bridgeGame.move("D");

            bridgeGame.move(movePosition);

            assertAll(
                    () -> assertThat(bridgeGame.isGameOver()).isEqualTo(isGameOver),
                    () -> assertThat(bridgeGame.isGamePlaying()).isEqualTo(isPlaying),
                    () -> assertThat(bridgeGame.isGamePass()).isEqualTo(isGamePass)
            );
        }
    }
}
