package bridge.domain;

import static bridge.constant.GameCommand.QUIT;
import static bridge.constant.GameCommand.RETRY;
import static bridge.constant.Moving.LOWER_SIDE;
import static bridge.constant.Moving.UPPER_SIDE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void initBridgeGame() {
        bridgeGame = new BridgeGame(List.of(UPPER_SIDE, LOWER_SIDE, UPPER_SIDE));
    }

    @DisplayName("입력 받은 이동 방향으로 1칸 이동한다.")
    @Nested
    class Move {

        @DisplayName("이동에 1회 성공한 경우")
        @Test
        void should_ReturnBridgePicture_When_SuccessToMove() {
            String moving = UPPER_SIDE;
            String bridgePicture = bridgeGame.move(moving);
            assertThat(bridgePicture).isEqualTo("[ O ]" + "\n" + "[   ]");
        }

        @DisplayName("이동에 1회 실패한 경우")
        @Test
        void should_ReturnBridgePicture_When_FailToMove() {
            String moving = LOWER_SIDE;
            String bridgePicture = bridgeGame.move(moving);
            assertThat(bridgePicture).isEqualTo("[   ]" + "\n" + "[ X ]");
        }

        @DisplayName("올바르지 않은 이동 방향 입력 -> 예외 발생")
        @ValueSource(strings = {"u", "d", "A", "123"})
        @ParameterizedTest
        void should_ThrowIllegalArgumentException_When_GiveWrongMoving(String input) {
            assertThatThrownBy(() -> bridgeGame.move(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("게임 상태가 진행 중인지 확인한다.")
    @Nested
    class IsOnWay {

        @DisplayName("진행 중인 경우")
        @Test
        void should_ReturnTrue_When_StatusIsOnWay() {
            bridgeGame.move(UPPER_SIDE);
            boolean isOnWay = bridgeGame.isOnWay();
            assertThat(isOnWay).isTrue();
        }

        @DisplayName("실패 상태인 경우")
        @Test
        void should_ReturnFalse_When_StatusIsFail() {
            bridgeGame.move(LOWER_SIDE);
            boolean isOnWay = bridgeGame.isOnWay();
            assertThat(isOnWay).isFalse();
        }
    }

    @DisplayName("게임 상태가 실패 상태인지 확인한다.")
    @Nested
    class IsFail {

        @DisplayName("실패 상태인 경우")
        @Test
        void should_ReturnTrue_When_StatusIsFail() {
            bridgeGame.move(LOWER_SIDE);
            boolean isOnWay = bridgeGame.isFail();
            assertThat(isOnWay).isTrue();
        }

        @DisplayName("진행 중인 경우")
        @Test
        void should_ReturnFalse_When_StatusIsOnWay() {
            bridgeGame.move(UPPER_SIDE);
            boolean isOnWay = bridgeGame.isFail();
            assertThat(isOnWay).isFalse();
        }
    }

    @DisplayName("게임 상태가 종료 상태인지 확인한다.")
    @Nested
    class IsEnd {

        @DisplayName("종료 상태인 경우")
        @Test
        void should_ReturnTrue_When_StatusIsEnd() {
            bridgeGame.move(UPPER_SIDE);
            bridgeGame.move(LOWER_SIDE);
            bridgeGame.move(UPPER_SIDE);
            boolean isOnWay = bridgeGame.isEnd();
            assertThat(isOnWay).isTrue();
        }

        @DisplayName("진행 중인 경우")
        @Test
        void should_ReturnFalse_When_StatusIsOnWay() {
            bridgeGame.move(UPPER_SIDE);
            boolean isOnWay = bridgeGame.isEnd();
            assertThat(isOnWay).isFalse();
        }
    }

    @DisplayName("게임 재시작 여부를 입력 받아, 게임 상태를 조정한다.")
    @Nested
    class Retry {

        @DisplayName("게임을 재시작하는 경우")
        @Test
        void should_BeOnWay_When_Input_Retry() {
            bridgeGame.move(LOWER_SIDE);
            boolean gameStatusBefore = bridgeGame.isFail();
            bridgeGame.retry(RETRY);
            boolean gameStatusAfter = bridgeGame.isOnWay();
            assertThat(gameStatusBefore).isTrue();
            assertThat(gameStatusAfter).isTrue();
        }

        @DisplayName("게임을 종료하는 경우")
        @Test
        void should_BeEnd_When_Input_Quit() {
            bridgeGame.move(LOWER_SIDE);
            boolean gameStatusBefore = bridgeGame.isFail();
            bridgeGame.retry(QUIT);
            boolean gameStatusAfter = bridgeGame.isEnd();
            assertThat(gameStatusBefore).isTrue();
            assertThat(gameStatusAfter).isTrue();
        }

        @DisplayName("올바르지 않은 게임 재시작 여부 입력 -> 예외 발생")
        @ValueSource(strings = {"r", "q", "A", "123"})
        @ParameterizedTest
        void should_ThrowIllegalArgumentException_When_GiveWrongGameCommand(String input) {
            assertThatThrownBy(() -> bridgeGame.retry(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("다리 건너기를 성공했는지 확인한다.")
    @Nested
    class CheckIsCrossBridgeCompletely {

        @DisplayName("성공한 경우")
        @Test
        void should_ReturnTrue_When_SuccessToCrossBridge() {
            bridgeGame.move(UPPER_SIDE);
            bridgeGame.move(LOWER_SIDE);
            bridgeGame.move(UPPER_SIDE);
            boolean isSuccess = bridgeGame.isSuccess();
            assertThat(isSuccess).isTrue();
        }

        @DisplayName("실패한 경우")
        @Test
        void should_ReturnFalse_When_FailToCrossBridge() {
            bridgeGame.move(UPPER_SIDE);
            bridgeGame.move(UPPER_SIDE);
            bridgeGame.retry(QUIT);
            boolean isSuccess = bridgeGame.isSuccess();
            assertThat(isSuccess).isFalse();
        }
    }

    @DisplayName("이동 현황을 반환한다.")
    @Test
    void should_ReturnBridgePicture_When_RequestToGet() {
        bridgeGame.move(UPPER_SIDE);
        bridgeGame.move(LOWER_SIDE);
        bridgeGame.move(UPPER_SIDE);
        String bridgePicture = bridgeGame.getPicture();
        assertThat(bridgePicture).isEqualTo("[ O |   | O ]" + "\n" + "[   | O |   ]");
    }

    @DisplayName("시도 횟수를 반환한다.")
    @Nested
    class GetTryCount {

        @DisplayName("시도 횟수가 1번인 경우")
        @Test
        void should_Be1_When_SuccessToCrossWithNoFail() {
            bridgeGame.move(UPPER_SIDE);
            bridgeGame.move(LOWER_SIDE);
            bridgeGame.move(UPPER_SIDE);
            int tryCount = bridgeGame.getTryCount();
            assertThat(tryCount).isEqualTo(1);
        }

        @DisplayName("시도 횟수가 2번인 경우")
        @Test
        void should_Be3_When_SuccessToCrossWith3TimesTry() {
            bridgeGame.move(UPPER_SIDE);
            bridgeGame.move(LOWER_SIDE);
            bridgeGame.retry(RETRY);
            bridgeGame.move(LOWER_SIDE);
            bridgeGame.move(UPPER_SIDE);
            assertThat(bridgeGame.getTryCount()).isEqualTo(2);
        }
    }
}