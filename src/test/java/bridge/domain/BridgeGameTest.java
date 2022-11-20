package bridge.domain;

import static bridge.constant.GameCommand.QUIT;
import static bridge.constant.GameCommand.RETRY;
import static bridge.constant.Moving.LOWER_SIDE;
import static bridge.constant.Moving.UPPER_SIDE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void initBridgeGame() {
        bridgeGame = new BridgeGame(List.of(UPPER_SIDE, LOWER_SIDE, UPPER_SIDE));
    }

    @DisplayName("게임 상태가 진행 중인지 확인한다.")
    @Nested
    class IsOnWay {

        @DisplayName("진행 중인 경우")
        @Test
        void should_BeTrue_When_StatusIsOnWay() {
            // given
            bridgeGame.move(UPPER_SIDE);
            // when
            boolean isOnWay = bridgeGame.isOnWay();
            // then
            assertThat(isOnWay).isTrue();
        }

        @DisplayName("실패 상태인 경우")
        @Test
        void should_BeFalse_When_StatusIsFail() {
            // given
            bridgeGame.move(LOWER_SIDE);
            // when
            boolean isOnWay = bridgeGame.isOnWay();
            // then
            assertThat(isOnWay).isFalse();
        }
    }

    @DisplayName("게임 상태가 실패 상태인지 확인한다.")
    @Nested
    class IsFail {

        @DisplayName("실패 상태인 경우")
        @Test
        void should_BeTrue_When_StatusIsFail() {
            // given
            bridgeGame.move(LOWER_SIDE);
            // when
            boolean isOnWay = bridgeGame.isFail();
            // then
            assertThat(isOnWay).isTrue();
        }

        @DisplayName("진행 중인 경우")
        @Test
        void should_BeFalse_When_StatusIsOnWay() {
            // given
            bridgeGame.move(UPPER_SIDE);
            // when
            boolean isOnWay = bridgeGame.isFail();
            // then
            assertThat(isOnWay).isFalse();
        }
    }

    @DisplayName("게임 상태가 종료 상태인지 확인한다.")
    @Nested
    class IsEnd {

        @DisplayName("종료 상태인 경우")
        @Test
        void should_BeTrue_When_StatusIsEnd() {
            // given
            bridgeGame.move(UPPER_SIDE);
            bridgeGame.move(LOWER_SIDE);
            bridgeGame.move(UPPER_SIDE);
            // when
            boolean isOnWay = bridgeGame.isEnd();
            // then
            assertThat(isOnWay).isTrue();
        }

        @DisplayName("진행 중인 경우")
        @Test
        void should_BeFalse_When_StatusIsOnWay() {
            // given
            bridgeGame.move(UPPER_SIDE);
            // when
            boolean isOnWay = bridgeGame.isEnd();
            // then
            assertThat(isOnWay).isFalse();
        }
    }

    @DisplayName("게임 재시작 여부를 입력 받아, 게임 상태를 조정한다.")
    @Nested
    class Retry {

        @DisplayName("게임을 재시작하는 경우")
        @Test
        void should_BeOnWay_When_Input_Retry() {
            // given
            bridgeGame.move(UPPER_SIDE);
            boolean isFail = bridgeGame.isFail();
            // when
            bridgeGame.retry(RETRY);
            boolean isOnWay = bridgeGame.isOnWay();
            // then
            assertThat(isFail).isTrue();
            assertThat(isOnWay).isTrue();
        }

        @DisplayName("게임을 종료하는 경우")
        @Test
        void should_BeEnd_When_Input_Quit() {
            // given
            bridgeGame.move(UPPER_SIDE);
            boolean isFail = bridgeGame.isFail();
            // when
            bridgeGame.retry(QUIT);
            boolean isEnd = bridgeGame.isEnd();
            // then
            assertThat(isFail).isTrue();
            assertThat(isEnd).isTrue();
        }
    }

    @DisplayName("다리 건너기를 성공했는지 확인한다.")
    @Nested
    class CheckIsCrossBridgeCompletely {

        @DisplayName("성공한 경우")
        @Test
        void should_BeTrue_When_SuccessToCrossBridge() {
            // given
            bridgeGame.move(UPPER_SIDE);
            bridgeGame.move(LOWER_SIDE);
            bridgeGame.move(UPPER_SIDE);
            // when
            boolean isSuccess = bridgeGame.isSuccess();
            // then
            assertThat(isSuccess).isTrue();
        }

        @DisplayName("실패한 경우")
        @Test
        void should_BeFalse_When_FailToCrossBridge() {
            // given
            bridgeGame.move(UPPER_SIDE);
            bridgeGame.move(UPPER_SIDE);
            bridgeGame.retry(QUIT);
            // when
            boolean isSuccess = bridgeGame.isSuccess();
            // then
            assertThat(isSuccess).isFalse();
        }
    }

    @DisplayName("이동 현황을 반환한다.")
    @Test
    void should_ReturnBridgePicture_When_RequestToGet() {
        // given
        bridgeGame.move(UPPER_SIDE);
        bridgeGame.move(LOWER_SIDE);
        bridgeGame.move(UPPER_SIDE);
        // when
        String bridgePicture = bridgeGame.getPicture();
        // then
        assertThat(bridgePicture).isEqualTo("[ O |   | O ]" + "\n" + "[   | O |   ]");
    }

    @DisplayName("시도 횟수를 반환한다.")
    @Nested
    class GetTryCount {

        @DisplayName("시도 횟수가 1번인 경우")
        @Test
        void should_Be1_When_NotFail() {
            // given
            bridgeGame.move(UPPER_SIDE);
            bridgeGame.move(LOWER_SIDE);
            bridgeGame.move(UPPER_SIDE);
            // when
            int tryCount = bridgeGame.getTryCount();
            // then
            assertThat(tryCount).isEqualTo(1);
        }

        @DisplayName("시도 횟수가 3번인 경우")
        @Test
        void should_Be3_When_Try3Times() {
            // given
            bridgeGame.move(LOWER_SIDE);
            bridgeGame.retry(RETRY);
            bridgeGame.move(LOWER_SIDE);
            bridgeGame.retry(RETRY);
            bridgeGame.move(UPPER_SIDE);
            bridgeGame.move(LOWER_SIDE);
            bridgeGame.move(UPPER_SIDE);
            // when
            int tryCount = bridgeGame.getTryCount();
            // then
            assertThat(tryCount).isEqualTo(3);
        }
    }
}